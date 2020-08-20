package com.dfj.dao.impl;

import com.dfj.dao.EmpMapper;
import com.dfj.entity.Emp;
import com.dfj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpMapperImpl implements EmpMapper {
    @Override
    public List<Emp> findAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        return mapper.findAll();
    }

    @Override
    public Emp findById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.findById(id);
        return emp;
    }

    @Override
    public List<Emp> findByName(String name) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        return mapper.findByName(name);
    }

    @Override
    public void save(Emp emp) {
        //对于SqlSession提交事务需要手动提交
        //DML语句才有事务性
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.save(emp);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Emp> findByCondition(Emp emp) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = mapper.findByCondition(emp);
        sqlSession.close();
        return empList;
    }

    @Override
    public void deleteById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.getMapper(EmpMapper.class).deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateById(Emp emp) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        sqlSession.getMapper(EmpMapper.class).updateById(emp);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Emp> findByIds(List<Integer> ids) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        return sqlSession.getMapper(EmpMapper.class).findByIds(ids);
    }

    @Override
    public Emp findByNameAndAge(String name, Integer age) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //Emp emp = sqlSession.getMapper(EmpMapper.class).findByNameAndAge(name, age);
        Map map = new HashMap();
        map.put("name",name);
        map.put("age",age);
        Emp emp = sqlSession.selectOne("findByNameAndAge", map);
        return emp;
    }

    @Override
    public List<Map<String, Object>> findByGender(String gender) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        List<Map<String, Object>> list = sqlSession.selectList("findByGender", gender);
        return list;
    }
}
