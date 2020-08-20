package com.dfj.service.impl;

import com.dfj.dao.AdminDao;
import com.dfj.entity.Admin;
import com.dfj.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Admin findByName(String username) {
        return adminDao.findByName(username);
    }

    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    public void update(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public Admin findById(Integer id) {
        return adminDao.findById(id);
    }

    @Override
    public void delete(Integer id) {
        adminDao.delete(id);
    }

    @Override
    public Admin findByEmail(String account) {
        return adminDao.findByEmail(account);
    }

    @Override
    public Admin findByTelephone(String account) {
        return adminDao.findByTelephone(account);
    }

    @Override
    public List<Admin> findByOption(Admin admin) {
        return adminDao.findByOption(admin);
    }
}
