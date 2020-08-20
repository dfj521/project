package com.dfj.test;

import com.dfj.entity.User;
import com.dfj.service.UserService;
import com.dfj.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean("userServiceImpl", UserServiceImpl.class);
        User user = new User();
        user.setUsername("qq");
        user.setPassword("qq");
        userService.add(user);
    }
}
