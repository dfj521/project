package com.dfj.dao;

import com.dfj.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 使用注解
 */
public interface UserInfoMapper {

    @Select("select * from userinfo where name = #{name} and age = #{age}")
    UserInfo findAll(@Param("name") String name, @Param("age") Integer age);

    @Insert("insert into userinfo values(null,#{age},#{name})")
    void add(UserInfo userInfo);

    @Select({"<script>"+
            "select * from userinfo "+
            "where 1=1"+
            "<when test=\"age != null and age != ''\">"+
            "and age = #{age}"+
            "</when>"+
            "<when test=\"name != null and name != ''\">"+
            "and name = #{name}"+
            "</when>"+
            "</script>"})
    List<UserInfo> findByOption(UserInfo userInfo);
}
