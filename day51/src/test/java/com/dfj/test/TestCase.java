package com.dfj.test;

import com.dfj.controller.AdminController;
import com.dfj.dao.AdminDao;
import com.dfj.entity.Admin;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCase {

    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = ac.getBean("adminDao", AdminDao.class);
        Admin admin = new Admin();
        admin.setUsername("qwer");
        admin.setPassword("qwer");
        admin.setEmail("qwer@qq.com");
        admin.setTelephone("12344444444");
        adminDao.save(admin);
        List<Admin> adminList = adminDao.findAll();
        for (Admin admin1 : adminList) {
            System.out.println(admin1);
        }
    }

    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminController adminController = ac.getBean("adminController", AdminController.class);
        String s = adminController.addAdmin();
        System.out.println(s);
        AdminDao adminDao = ac.getBean("adminDao", AdminDao.class);
        List<Admin> adminList = adminDao.findAll();
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
}
