package com.dfj.service;

import com.dfj.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByNameAndPwd(String username, String password);

    User findByName(String username);

    void add(User user);

    void delById(Integer id);

    User findById(Integer id);

    void updById(User user);

    List<User> findByOption(User user);
}
