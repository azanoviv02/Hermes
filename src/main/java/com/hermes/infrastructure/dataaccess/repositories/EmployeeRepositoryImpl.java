package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.employees.AbstractEmployee;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 05.11.16.
 */
public class EmployeeRepositoryImpl extends GenericRepositoryImpl<AbstractEmployee> implements EmployeeRepository {
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        super(AbstractEmployee.class, sessionFactory);
    }
}

