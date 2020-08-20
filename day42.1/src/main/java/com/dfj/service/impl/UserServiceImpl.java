package com.dfj.service.impl;

import com.dfj.dao.UserDao;
import com.dfj.entity.User;
import com.dfj.exception.PasswordException;
import com.dfj.exception.UsernameException;
import com.dfj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    //检查登录
    public User checkLogin(String username, String password) {
        User user = userDao.findByName(username);
        if (user.getUsername() == null) {
            throw new UsernameException("账号不存在");
        }else if (!user.getPassword().equals(password)){
            throw new PasswordException("密码错误");
        }else {
            return user;
        }
    }

    @Override
    public void add(User user) {
        User byName = userDao.findByName(user.getUsername());
        if (byName.getUsername() != null) {
            throw new UsernameException("账号已存在");
        }else {
            userDao.add(user);
        }
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}
