package com.dfj.test;

import com.dfj.dao.AdminDao;
import com.dfj.dao.UserInfoMapper;
import com.dfj.entity.Admin;
import com.dfj.entity.UserInfo;
import com.dfj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestCase1 {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Admin> adminList = sqlSession.selectList("com.dfj.dao.AdminDao.findAll");
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Admin> adminList = sqlSession.getMapper(AdminDao.class).findByNameAndAge("admin", "admin");
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Admin> adminList = sqlSession.getMapper(AdminDao.class).findByNameAmdTel("admin","13888888888");
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //UserInfo adminList = sqlSession.getMapper(UserInfoMapper.class).findAll("tom",18);
        //System.out.println(adminList);
        UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(12);
        //userInfo.setName("123");
        //mapper.add(userInfo);
        List<UserInfo> byOption = mapper.findByOption(userInfo);
        System.out.println(byOption);
        sqlSession.commit();
    }
}
