package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.infrastructure.dataaccess.specifications.Specification;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class GenericDao<T extends AbstractPersistentObject>  {

    private Session currentSession;
//    private String tableName;
    private Transaction currentTransaction;
    private final Class<T> typeParameterClass;

    GenericDao(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
//        this.tableName = MappingInfoUtil.getTableName(typeParameterClass);
    }

//    public Session openCurrentSession() {
//        currentSession = HibernateUtil.getSessionFactory().openSession();
//        return currentSession;
//    }

    public void openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
    }

//    public Session openCurrentSessionwithTransaction() {
//        currentSession = HibernateUtil.getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }

    public void openCurrentSessionwithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(T entity) {
        getCurrentSession().save(entity);
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public T findById(UUID id) {
        return typeParameterClass.cast(getCurrentSession().get(typeParameterClass, id));
    }

    public T findById(String id) {
        return findById(UUID.fromString(id));
    }

    public <T> List findAllBySpecification(Specification<T>...specification) {
        Criteria criteria = getCurrentSession().createCriteria(specification[0].getType());
        for(Specification<T> detail : specification) {
            criteria.add(detail.toCriterion());
        }
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
//    public List<T> findAll() {
//        List<T> books = (List<T>) getCurrentSession().createQuery("from "+tableName).list();
//        return books;
//    }

    public List<T> findAll() {
        List<T> books = (List<T>) getCurrentSession().createCriteria(typeParameterClass).list();
        return books;
    }

    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteAll() {
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }
}