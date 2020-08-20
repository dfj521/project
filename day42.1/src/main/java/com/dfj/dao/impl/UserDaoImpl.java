package com.dfj.dao.impl;

import com.dfj.dao.UserDao;
import com.dfj.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
    数据持久层
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByName(String username) {
        return jdbcTemplate.queryForObject(
                "select * from user where username = ?",
                new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void add(User user) {
        jdbcTemplate.update(
                "insert into user values(null,?,?,?,?)",
                user.getUsername(),user.getPassword(),user.getEmail(),user.getTelephone());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from user", new BeanPropertyRowMapper<>(User.class));
    }
}
