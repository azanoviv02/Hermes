package com.hermes.application.states;

import com.hermes.domain.users.AbstractUser;
import com.hermes.domain.users.InvalidPasswordException;
import com.hermes.domain.users.RepresentedUser;
import com.hermes.infrastructure.dataaccess.repositories.Repositories;
import com.hermes.infrastructure.dataaccess.specifications.users.UserWhich;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.NoResultException;

/**
 * Created by ivan on 01.11.16.
 */
class UserStateFactory {

    static AbstractUserState createUserState(String login, String password) throws NoSuchLoginException, InvalidPasswordException{
        try {

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
            Repositories repository = context.getBean(Repositories.class);

            AbstractUser user = repository.getUserRepository().getOne(UserWhich.hasLogin(login));
            user.checkPassword(password);
            switch(user.getRole()){
                case ADMIN:
                    return new AdminState(user);
                case DRIVER:
                    if(user instanceof RepresentedUser){
                        return new DriverState((RepresentedUser) user);
                    }else{
                        throw new IllegalStateException();
                    }
                case MANAGER:
                    return new ManagerState(user);
                case PLANNER:
                    return new PlannerState(user);
                case INFORMER:
                    return new InformerState(user);
                default:
                    throw new IllegalStateException();
            }
        }catch (NoResultException nre){
            throw new NoSuchLoginException();
        }
    }
}
