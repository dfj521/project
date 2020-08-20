package com.dfj.test;

import com.dfj.dao.UserInfoDao;
import com.dfj.entity.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Optional;

public class TestCase {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoDao userInfoDao = ac.getBean("userInfoDao", UserInfoDao.class);
    @Test
    public void test1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("marry");
        userInfo.setAge(19);
        userInfoDao.save(userInfo);
    }
    @Test
    public void test2() {
        userInfoDao.deleteById(1);
    }
    @Test
    public void test3() {
        Iterable<UserInfo> all = userInfoDao.findAll();
        for (UserInfo userInfo : all) {
            System.out.println(userInfo);
        }
    }
    @Test
    public void test4() {
        Optional<UserInfo> byId = userInfoDao.findById(2);
        System.out.println(byId);
    }
    @Test
    public void test5() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("jerry");
        userInfo.setAge(19);
        userInfo.setId(3);
        userInfoDao.save(userInfo);
    }
    @Test
    public void test6() {
        List<UserInfo> tom = userInfoDao.findByName("tom");
        for (UserInfo userInfo : tom) {
            System.out.println(userInfo);
        }
    }
    @Test
    public void test7() {
        List<UserInfo> userInfoList = userInfoDao.findUserInfosByNameOrAge("jerry", 18);
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
    }
    @Test
    public void test8() {
        List<UserInfo> userInfoList = userInfoDao.findUserInfosByNameLike("%a%");
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
    }
    @Test
    public void test9() {
        List<UserInfo> userInfoList = userInfoDao.findByAge(19);
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
    }
}
