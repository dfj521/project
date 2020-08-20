package com.dfj.dao;

import com.dfj.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 传统的几个方法：CRUD
     */
    //查询所有
    List<User> findAll();

    //根据id查询信息
    User findById(Integer id);

    //插入信息
    void save(User user);

    //更新信息
    void update(User user);

    //根据id删除信息
    void deleteById(Integer id);
}
