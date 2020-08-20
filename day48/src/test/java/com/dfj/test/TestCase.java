package com.dfj.test;

import com.dfj.dao.AdminMapper;
import com.dfj.entity.Admin;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.List;

public class TestCase {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper adminMapper = ac.getBean("adminMapper", AdminMapper.class);
        List<Admin> byNames = adminMapper.findByName("");
        for (Admin byName : byNames) {
            System.out.println(byName);
        }
    }
    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper adminMapper = ac.getBean("adminMapper", AdminMapper.class);
        List<Admin> byIds = adminMapper.findById(2);
        for (Admin byId : byIds) {
            System.out.println(byId);
        }
    }
    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper adminMapper = ac.getBean("adminMapper", AdminMapper.class);
        List<Admin> byNameAndPwd = adminMapper.findByNameAndPwd("admin", "admin");
        for (Admin admin : byNameAndPwd) {
            System.out.println(admin);
        }
    }
    @Test
    public void test4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper adminMapper = ac.getBean("adminMapper", AdminMapper.class);
        Admin admin = new Admin();
        admin.setId(1);
        admin.setEmail("admin@qq.com");
        adminMapper.update(admin);
        List<Admin> byId = adminMapper.findById(0);
        for (Admin admin1 : byId) {
            System.out.println(admin1);
        }
    }
    @Test
    public void test5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper adminMapper = ac.getBean("adminMapper", AdminMapper.class);
        List<Admin> byEmailOrTel = adminMapper.findByEmailOrTel("123", "13211111122");
        for (Admin admin : byEmailOrTel) {
            System.out.println(admin);
        }
    }
    @Test
    public void test6() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminMapper adminMapper = ac.getBean("adminMapper", AdminMapper.class);
        Integer[] ids = {4,5};
        List<Admin> byIds = adminMapper.findByIds(ids);
        for (Admin byId : byIds) {
            System.out.println(byId);
        }
    }
}
