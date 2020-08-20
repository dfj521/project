package com.dfj.dao;

import com.dfj.entity.User;

import java.util.List;

public interface UserDao {

    //登录
    User findByName(String username);

    //注册
    void add(User user);

    //查询所有用户信息
    List<User> findAll();

}
