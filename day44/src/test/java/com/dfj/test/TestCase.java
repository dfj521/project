package com.dfj.test;

import com.dfj.dao.impl.UserDaoImpl;
import com.dfj.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCase {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test1() {
        UserDaoImpl userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
        List<User> all = userDaoImpl.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        User byId = userDaoImpl.findById(1);
        System.out.println(byId);
    }
    @Test
    public void test2() {
        UserDaoImpl userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
        User user = new User();
        user.setUsername("111111");
        user.setPassword("111111");
        user.setEmail("123");
        user.setTelephone("123");
        userDaoImpl.save(user);
    }
    @Test
    public void test3() {
        UserDaoImpl userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
        User user = new User();
        user.setId(3);
        user.setUsername("111111");
        user.setPassword("111111");
        user.setEmail("123");
        user.setTelephone("123");
        userDaoImpl.update(user);
    }
    @Test
    public void test4() {
        UserDaoImpl userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
        userDaoImpl.deleteById(5);
    }
}
