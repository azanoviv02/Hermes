package com.hermes.application;

import com.hermes.domain.users.Role;
import com.hermes.domain.users.UserFactory;
import com.hermes.infrastructure.dataaccess.repositories.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Backdoor {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserRepository userRepository = context.getBean(UserRepository.class);
        UserFactory userFactory = context.getBean(UserFactory.class);

        userRepository.add(userFactory.createUser("Dudkin", "123", "Pavel Dudkin", Role.ADMIN));
        userRepository.add(userFactory.createUser("Gurbatov", "123", "Pavel Gurbatov", Role.DRIVER));
        userRepository.add(userFactory.createUser("Kireev", "123", "Pavel Kireev", Role.MANAGER));
        userRepository.add(userFactory.createUser("FYL", "123", "Pavel Fyl", Role.PLANNER));
        userRepository.add(userFactory.createUser("Azanov", "123", "Pavel Fyl", Role.INFORMER));
    }
}
