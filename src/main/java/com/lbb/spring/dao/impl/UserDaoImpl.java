package com.lbb.spring.dao.impl;

import com.lbb.spring.dao.UserDao;
import com.lbb.spring.model.User;

public class UserDaoImpl implements UserDao {

    public void save(User user) {
        System.out.println(user);
    }
}
