package com.dfj.service;

import com.dfj.entity.User;

import java.util.List;

public interface UserService {

    User findByName(String username);

    void add(User user);

    List<User> findAll();

}
