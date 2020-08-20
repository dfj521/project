package com.dfj.dao.impl;

import com.dfj.dao.UserDao;
import com.dfj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user", new UserRowMapper());
    }

    @Override
    public User findById(Integer id) {
        return (User) jdbcTemplate.queryForObject(
                "select * from user where id = ?", new Object[]{id}, new UserRowMapper());
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(
                "insert into user values(null,?,?,?,?)",
                user.getUsername(),user.getPassword(),user.getEmail(),user.getTelephone());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(
                "update user set username = ?, password= ? , email= ? , telephone = ? where id = ?",
                user.getUsername(),user.getPassword(),user.getEmail(),user.getTelephone(),user.getId());
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update(
                "delete from user where id = ?",id);
    }

    /**
     * 封装数据库记录和Java实体类的对应关系
     */
    class UserRowMapper implements RowMapper{

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setTelephone(resultSet.getString("telephone"));
            return user;
        }
    }
}
