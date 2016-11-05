package com.hermes.application;

import com.hermes.domain.users.Role;
import com.hermes.domain.users.UserFactory;
import com.hermes.infrastructure.dataaccess.repositories.Repositories;
import com.hermes.infrastructure.dataaccess.repositories.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Backdoor {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Repositories main = context.getBean(Repositories.class);
        UserRepository userRepository = main.getUserRepository();

        userRepository.add(UserFactory.createUser("Dudkin", "123", "Pavel Dudkin", Role.ADMIN));
        userRepository.add(UserFactory.createUser("Gurbatov", "123", "Pavel Gurbatov", Role.DRIVER));
        userRepository.add(UserFactory.createUser("Kireev", "123", "Pavel Kireev", Role.MANAGER));
        userRepository.add(UserFactory.createUser("FYL", "123", "Pavel Fyl", Role.PLANNER));
        userRepository.add(UserFactory.createUser("Azanov", "123", "Pavel Fyl", Role.INFORMER));
    }
}
