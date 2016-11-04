package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.users.AbstractUser;

/**
 * Created by ivan on 01.11.16.
 */
public class UserRepository extends GenericRepository<AbstractUser> {
    UserRepository() {
        super(AbstractUser.class);
    }
}

