package com.dfj.service;

import com.dfj.entity.User;

import java.util.List;

public interface UserService {

    User checkLogin(String username, String password);

    void add(User user);

    List<User> findAll();

}
