package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.infrastructure.dataaccess.specifications.Specification;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

public class GenericDaoImpl<T extends AbstractPersistentObject> implements GenericDao<T> {

    protected final Class<? extends T> daoType;
    private final SessionFactory sessionFactory;

    public GenericDaoImpl(Class<? extends T> daoType, SessionFactory sessionFactory) {
        this.daoType = daoType;
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T entity) {
        currentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(T entity) {
        currentSession().delete(entity);
    }

    @Override
    public T find(UUID key) {
        return (T) currentSession().get(daoType, key);
    }

    @Override
    public <T> List findAllBySpecification(Specification<T>...specification) {
        Criteria criteria = currentSession().createCriteria(specification[0].getType());
        for(Specification<T> detail : specification) {
            criteria.add(detail.toCriterion());
        }
        return criteria.list();
    }

    @Override
    public List<T> getAll() {
        return currentSession().createCriteria(daoType).list();
    }
}