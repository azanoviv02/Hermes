package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.employees.AbstractEmployee;

/**
 * Created by ivan on 05.11.16.
 */
public class EmployeeRepositoryImpl extends GenericRepositoryImpl<AbstractEmployee> implements EmployeeRepository {
    public EmployeeRepositoryImpl(GenericDao<AbstractEmployee> dao) {
        super(dao);
    }
}

