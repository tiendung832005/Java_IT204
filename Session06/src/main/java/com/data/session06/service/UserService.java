package com.data.session06.service;


import com.data.session06.dao.UserDao;
import com.data.session06.model.User;

import java.sql.SQLException;

public class UserService {
    private final UserDao userDao = new UserDao();

    public void registerUser(User user) throws SQLException {
        userDao.registerUser(user);
    }

    public User getUserByUsername(String username) throws SQLException {
        return userDao.getUserByUsername(username);
    }
}
