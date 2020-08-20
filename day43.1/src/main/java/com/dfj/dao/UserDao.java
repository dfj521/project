package com.dfj.dao;

import com.dfj.entity.User;

import java.util.List;

public interface UserDao {

    //根据名字查信息
    User findByName(String username);

    void add(User user);

    List<User> findAll();

}
