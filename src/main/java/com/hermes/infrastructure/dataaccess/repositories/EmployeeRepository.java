package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.employees.AbstractEmployee;

/**
 * Created by ivan on 01.11.16.
 */
public class EmployeeRepository extends GenericRepository<AbstractEmployee> {
    EmployeeRepository() {
        super(AbstractEmployee.class);
    }
}