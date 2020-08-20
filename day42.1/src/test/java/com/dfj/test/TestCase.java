package com.dfj.test;

import com.dfj.dao.impl.UserDaoImpl;
import com.dfj.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
    @Test
    public void test1() {
        //初始化Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDaoImpl = ac.getBean("userDaoImpl", UserDaoImpl.class);
        User user = new User();
        user.setUsername("1234");
        user.setPassword("1234");
        user.setEmail("1234");
        user.setTelephone("1234");
        userDaoImpl.add(user);
    }
}
