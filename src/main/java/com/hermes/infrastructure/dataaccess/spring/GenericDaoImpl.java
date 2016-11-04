package com.hermes.infrastructure.dataaccess.spring;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.infrastructure.dataaccess.specifications.Specification;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class GenericDaoImpl<T extends AbstractPersistentObject> implements GenericDao<T> {

    protected Class<? extends T> daoType;
    private SessionFactory sessionFactory;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
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