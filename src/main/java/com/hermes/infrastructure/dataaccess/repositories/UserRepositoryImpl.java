package com.hermes.infrastructure.dataaccess.repositories;

import com.hermes.domain.users.AbstractUser;
import org.hibernate.SessionFactory;

public class UserRepositoryImpl extends GenericRepositoryImpl<AbstractUser> implements UserRepository{
    public UserRepositoryImpl(Class<? extends AbstractUser> daoType, SessionFactory sessionFactory) {
        super(daoType, sessionFactory);
    }
}
