package com.dfj.service.impl;

import com.dfj.dao.UserDao;
import com.dfj.entity.User;
import com.dfj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
