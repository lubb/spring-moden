package com.lbb.spring.service;

import com.lbb.spring.dao.UserDao;
import com.lbb.spring.model.User;

public class UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user){
        userDao.save(user);
    }
}
