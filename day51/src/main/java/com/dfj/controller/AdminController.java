package com.dfj.controller;

import com.dfj.dao.AdminDao;
import com.dfj.entity.Admin;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*凡是涉及到多个DML语句在同一个方法中执行的时候必须加上事务的约束*/
@RestController
//@Transactional
public class AdminController {

    @Resource
    private AdminDao adminDao;

    //@Transactional
    @GetMapping("/addAdmin.do")
    public String addAdmin() {
        //添加一个admin
        Admin admin = new Admin();
        admin.setUsername("tom");
        admin.setPassword("123");
        admin.setEmail("tom@qq.com");
        admin.setTelephone("55555555555");
        adminDao.save(admin);
        //模拟异常
        Integer.valueOf("abc");
        //添加第二个admin
        Admin admin2 = new Admin();
        admin2.setUsername("jerry");
        admin2.setPassword("123");
        admin2.setEmail("tom@qq.com");
        admin2.setTelephone("55555555555");
        adminDao.save(admin2);
        return "success";
    }
}
