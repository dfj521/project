package com.dfj.service.impl;

import com.dfj.entity.User;
import com.dfj.mapper.UserMapper;
import com.dfj.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByNameAndPwd(String username, String password) {
        return userMapper.findByNameAndPwd(username, password);
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void delById(Integer id) {
        userMapper.delById(id);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void updById(User user) {
        userMapper.updById(user);
    }

    @Override
    public List<User> findByOption(User user) {
        return userMapper.findByOption(user);
    }
}
