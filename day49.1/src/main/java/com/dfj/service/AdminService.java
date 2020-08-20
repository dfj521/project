package com.dfj.service;

import com.dfj.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();

    Admin findByName(String username);

    void save(Admin admin);

    void update(Admin admin);

    Admin findById(Integer id);

    void delete(Integer id);

    Admin findByEmail(String account);

    Admin findByTelephone(String account);

    List<Admin> findByOption(Admin admin);
}
