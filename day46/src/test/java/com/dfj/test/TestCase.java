package com.dfj.test;

import com.dfj.dao.AdminDao;
import com.dfj.dao.EmpDao;
import com.dfj.dao.StudentDao;
import com.dfj.dao.UserInfoDao;
import com.dfj.entity.Admin;
import com.dfj.entity.Emp;
import com.dfj.entity.Student;
import com.dfj.entity.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCase {
    @Test
    public void test1() {
        //初始化spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpDao empDao = ac.getBean("empDao", EmpDao.class);
        List<Emp> empList = empDao.findAll();
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }
    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = ac.getBean("adminDao", AdminDao.class);
        List<Admin> all = adminDao.findAll();
        for (Admin admin : all) {
            System.out.println(admin);
        }
    }
    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = ac.getBean("adminDao", AdminDao.class);
        Admin byId = adminDao.findById(1);
        System.out.println(byId);
        byId.setName("小黄");
        byId.setPassword("123");
        byId.setEmail("123@qq.com");
        byId.setTelephone("15555555555");
        adminDao.update(byId);
    }
    @Test
    public void test4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoDao userInfoDao = ac.getBean("userInfoDao", UserInfoDao.class);
        List<UserInfo> all = userInfoDao.findAll();
        for (UserInfo userInfo : all) {
            System.out.println(userInfo);
        }
    }
    @Test
    public void test5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoDao userInfoDao = ac.getBean("userInfoDao", UserInfoDao.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(12);
        userInfo.setName("小白");
        userInfoDao.save(userInfo);
    }
    @Test
    public void test6() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoDao userInfoDao = ac.getBean("userInfoDao", UserInfoDao.class);
        UserInfo byId = userInfoDao.findById(11);
        System.out.println(byId);
        byId.setAge(13);
        byId.setName("rose");
        userInfoDao.updateById(byId);
    }
    @Test
    public void test7() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoDao userInfoDao = ac.getBean("userInfoDao", UserInfoDao.class);
        userInfoDao.deleteById(10);
    }
    @Test
    public void test8() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = ac.getBean("studentDao", StudentDao.class);
        /*Student student = new Student();
        student.setName("tom");
        student.setAge(18);
        student.setScore(100);
        studentDao.save(student);*/
        /*Student byId = studentDao.findById(1);
        byId.setName("jerry");
        studentDao.update(byId);*/
        //studentDao.deleteById(1);
        List<Student> all = studentDao.findAll();
        for (Student s : all) {
            System.out.println(s);
        }

    }
}
