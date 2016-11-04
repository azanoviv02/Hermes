package com.hermes.application;

import com.hermes.TestMain;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Backdoor {

    public static void main(String[] args) {
//        UserRepository userRepository = Repositories.getUserRepository();
//        userRepository.add(UserFactory.createUser("Dudkin", "123", "Pavel Dudkin", Role.ADMIN));
//        userRepository.add(UserFactory.createUser("Gurbatov", "123", "Pavel Gurbatov", Role.DRIVER));
//        userRepository.add(UserFactory.createUser("Kireev", "123", "Pavel Kireev", Role.MANAGER));
//        userRepository.add(UserFactory.createUser("FYL", "123", "Pavel Fyl", Role.PLANNER));
//        userRepository.add(UserFactory.createUser("Azanov", "123", "Pavel Fyl", Role.INFORMER));

//        TestUser pasha = new TestUser();
//        pasha.printUser();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        TestMain main = context.getBean(TestMain.class);
        main.getSessionFactory().openSession();
    }
}
