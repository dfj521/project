package com.dfj.mapper;

import com.dfj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where username = #{username} and password = #{password}")
    User findByNameAndPwd(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username = #{username}")
    User findByName(@Param("username") String username);

    @Insert("insert into user values(null,#{username},#{password},#{email},#{telephone})")
    void add(User user);

    @Delete("delete from user where id = #{id}")
    void delById(Integer id);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Update("update user set " +
            "username=#{username}, password=#{password}, email=#{email}, telephone=#{telephone} " +
            "where id=#{id}")
    void updById(User user);

    @Select({"<script>" +
            "select * from user " +
            "<where>" +
            "   <if test=\"username != null and username != ''\">" +
            "           and username = #{username}" +
            "   </if>" +
            "   <if test=\"password != null and password != ''\">" +
            "           and password = #{password}" +
            "   </if>" +
            "   <if test=\"email != null and email != ''\">" +
            "           and email = #{email}" +
            "   </if>" +
            "   <if test=\"telephone != null and telephone != ''\">" +
            "           and telephone = #{telephone}" +
            "   </if>" +
            "</where>"+
            "</script>"})
    List<User> findByOption(User user);
}
