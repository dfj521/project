package com.dfj.test;

import com.dfj.dao.EmpMapper;
import com.dfj.dao.impl.EmpMapperImpl;
import com.dfj.entity.Emp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCase {
    EmpMapper empMapper = new EmpMapperImpl();
    @Test
    public void test1() {
        List<Emp> empList = empMapper.findAll();
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }
    @Test
    public void test2() {
        Emp emp = empMapper.findById(1);
        System.out.println(emp);
    }
    @Test
    public void test3() {
        List<Emp> empList = empMapper.findByName("小红");
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }
    @Test
    public void test4() {
        Emp emp = new Emp();
        emp.setName("小明");
        emp.setAge(20);
        emp.setGender("M");
        emp.setSalary(88888.0);
        empMapper.save(emp);
    }
    @Test
    public void test5() {
        Emp emp = new Emp();
        emp.setId(3);
        emp.setName("小明");
        System.out.println(empMapper.findByCondition(emp));
    }
    @Test
    public void test6() {
        empMapper.deleteById(3);
    }
    @Test
    public void test7() {
        Emp emp = empMapper.findById(4);
        emp.setName("小绿");
        emp.setAge(21);
        emp.setGender("F");
        emp.setSalary(99999.9);
        empMapper.updateById(emp);
    }
    @Test
    public void test8() {
        List<Integer> ids = new ArrayList<>();
        //ids.add(1);
        //ids.add(2);
        //ids.add(3);
        //ids.add(4);
        List<Emp> empList = empMapper.findByIds(ids);
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }
    @Test
    public void test9() {
        Emp emp = empMapper.findByNameAndAge("小红", 18);
        System.out.println(emp);
    }
    @Test
    public void test10() {
        List<Map<String, Object>> byGender = empMapper.findByGender("F");
        System.out.println(byGender);
    }
}
