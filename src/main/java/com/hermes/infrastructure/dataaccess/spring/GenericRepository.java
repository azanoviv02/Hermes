package com.hermes.infrastructure.dataaccess.spring;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.infrastructure.dataaccess.specifications.Specification;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by ivan on 04.11.16.
 */
public interface GenericRepository<T extends AbstractPersistentObject> {
    GenericDao<T> getGenericDao();

    void setGenericDao(GenericDao<T> dao);

    @Transactional(propagation = Propagation.REQUIRED)
    abstract void add(T entity);

    @Transactional(propagation = Propagation.REQUIRED)
    abstract void addAll(Collection<T> allEntities);

    @Transactional(propagation = Propagation.REQUIRED)
    abstract void saveOrUpdate(T entity);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    T getOne(Specification<T>... specification);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    T getFirst(Specification<T>... specification);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    List<T> getEvery(Specification<T>... specification);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    boolean contains(Specification<T>... specification);

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    abstract List<T> getAll();

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    abstract T get(UUID id);

    @Transactional(propagation = Propagation.REQUIRED)
    abstract void update(T entity);

    @Transactional(propagation = Propagation.REQUIRED)
    abstract void remove(T entity);

    @Transactional(propagation = Propagation.REQUIRED)
    void remove(UUID id);
}