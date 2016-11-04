package com.hermes.domain.users;

import com.hermes.domain.employees.AbstractEmployee;
import com.hermes.domain.employees.EmployeeFactory;

/**
 * Created by ivan on 02.11.16.
 */
public class UserFactory {

    public static AbstractUser createUser(String login, String password, String name, Role role){
        if(role != Role.DRIVER){
            return new BasicUser(login, password, name, role);
        }

        AbstractEmployee representation = EmployeeFactory.createBasicDriver(name);
        AbstractUser user = new RepresentedUser(login, password, name, role, representation);
        return user;
    }
}
