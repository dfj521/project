package com.dfj.test;

import com.dfj.dao.AdminDao;
import com.dfj.dao.ClassGradeDao;
import com.dfj.dao.StudentDao;
import com.dfj.entity.Admin;
import com.dfj.entity.ClassGrade;
import com.dfj.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCase {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = ac.getBean("adminDao", AdminDao.class);
        /*List<Admin> adminList = adminDao.findAll();
        for (Admin admin : adminList) {
            System.out.println(admin);
        }*/
        /*Admin byName = adminDao.findByName("123");
        System.out.println(byName);*/
        ClassGradeDao classGradeDao = ac.getBean("classGradeDao", ClassGradeDao.class);
        /*List<ClassGrade> classGradeList = classGradeDao.findAll();
        for (ClassGrade classGrade : classGradeList) {
            System.out.println(classGrade);
        }*/
        StudentDao studentDao = ac.getBean("studentDao", StudentDao.class);
        /*Student student = new Student();
        student.setName("小明");
        student.setAge(18);
        student.setClassNo(1);
        studentDao.add(student);*/
        //studentDao.delete(13);
        List<Student> studentList = studentDao.findAll();
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
    }
}
