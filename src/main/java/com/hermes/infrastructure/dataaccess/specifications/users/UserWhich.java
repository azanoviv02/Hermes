package com.hermes.infrastructure.dataaccess.specifications.users;

import com.hermes.domain.users.AbstractUser;
import com.hermes.domain.users.Role;
import com.hermes.infrastructure.dataaccess.specifications.AbstractWhich;
import com.hermes.infrastructure.dataaccess.specifications.Specification;

/**
 * Created by ivan on 02.11.16.
 */
public class UserWhich extends AbstractWhich<AbstractUser> {
    public static Specification<AbstractUser> hasLogin(String login){
        return new hasLogin(login);
    }

    public static Specification<AbstractUser> hasRole(Role role){
        return new hasRole(role);
    }

    public static Specification<AbstractUser> isAdmin(){
        return new hasRole(Role.ADMIN);
    }

    public static Specification<AbstractUser> isDriver(){
        return new hasRole(Role.DRIVER);
    }

    public static Specification<AbstractUser> isManager(){
        return new hasRole(Role.MANAGER);
    }

    public static Specification<AbstractUser> isPlanner(){
        return new hasRole(Role.PLANNER);
    }

    public static Specification<AbstractUser> isInformer(){
        return new hasRole(Role.INFORMER);
    }
}
