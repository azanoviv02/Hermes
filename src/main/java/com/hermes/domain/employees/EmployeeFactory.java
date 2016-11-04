package com.hermes.domain.employees;

/**
 * Created by ivan on 02.11.16.
 */
public class EmployeeFactory {

    public static BasicDriver createBasicDriver(String name){
        return new BasicDriver(name);
    }

    public static BasicDriver createBasicDriver(String name, int salary){
        return new BasicDriver(name, salary);
    }
}
