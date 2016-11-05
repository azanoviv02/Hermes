package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.infrastructure.dataaccess.specifications.Specification;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public abstract class GenericRepositoryImpl<T extends AbstractPersistentObject> implements GenericRepository<T>{

    private final GenericDao<T> dao;

    public GenericRepositoryImpl(Class<? extends T> daoType, SessionFactory sessionFactory) {
        this.dao = new GenericDaoImpl<T>(daoType, sessionFactory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(T entity) {
        dao.add(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addAll(Collection<T> allEntities) {
        for(T entity : allEntities){
            dao.add(entity);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(T entity) {
        dao.saveOrUpdate(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T get(UUID id) {
        return dao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T getOne(Specification<T>... specification) {
        List<T> results = dao.findAllBySpecification(specification);
        switch (results.size()){
            case 0:
                throw new NoResultException();
            case 1:
                return results.get(0);
            default:
                throw new NonUniqueResultException("Result list has "+results.size()+" items instead of one");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T getFirst(Specification<T>... specification) {
        List<T> results = dao.findAllBySpecification(specification);
        switch (results.size()) {
            case 0:
                throw new NoResultException();
            default:
                return results.get(0);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> getEvery(Specification<T>... specification) {
        List<T> results = dao.findAllBySpecification(specification);
        return results;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public boolean contains(Specification<T>... specification) {
        List<T> results = dao.findAllBySpecification(specification);
        return (results.size() != 0);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(T entity) {
        dao.remove(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(UUID id) {
        T foundEntity = dao.find(id);
        dao.remove(foundEntity);
    }
}
