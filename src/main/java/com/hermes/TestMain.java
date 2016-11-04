package com.hermes;

import org.hibernate.SessionFactory;

public class TestMain {

    SessionFactory sessionFactory;
    private UserDaoImpl userDao;

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
}
