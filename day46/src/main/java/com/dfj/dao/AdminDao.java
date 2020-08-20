package com.dfj.dao;

import com.dfj.annotation.MyBatisRepository;
import com.dfj.entity.Admin;

import java.util.List;

@MyBatisRepository
public interface AdminDao {
    List<Admin> findAll();
    Admin findById(Integer id);
    void save(Admin admin);
    void update(Admin admin);
    void deleteById(Integer id);
}
