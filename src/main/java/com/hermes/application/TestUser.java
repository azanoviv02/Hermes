package com.hermes.application;

import com.hermes.domain.users.AbstractUser;
import com.hermes.infrastructure.dataaccess.repositories.UserRepository;

import java.util.List;

/**
 * Created by ivan on 04.11.16.
 */
public class TestUser {
    private UserRepository userRepository;

    public void printUser(){
        List<? extends AbstractUser> allUsers = userRepository.getAll();
        for(AbstractUser user: allUsers){
            System.out.println(user.getLogin());
        }
    }
}
