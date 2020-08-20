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
}
