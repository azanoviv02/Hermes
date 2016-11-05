package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.users.AbstractUser;

public class UserRepositoryImpl extends GenericRepositoryImpl<AbstractUser> implements UserRepository{
    public UserRepositoryImpl(GenericDao<AbstractUser> dao) {
        super(dao);
    }
}
