package com.dfj.dao;

import com.dfj.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDao {
    @Select("select * from admin")
    List<Admin> findAll();

    @Select("select * from admin where id = #{id}")
    Admin findById(Integer id);

    @Select("select * from admin where username = #{username}")
    Admin findByName(String username);

    @Select("select * from admin where email = #{email}")
    Admin findByEmail(String account);

    @Select("select * from admin where telephone = #{telephone}")
    Admin findByTelephone(String account);

    @Insert("insert into admin values(null,#{username},#{password},#{email},#{telephone})")
    void save(Admin admin);

    @Update("update admin set username=#{username},password=#{password},email=#{email},telephone=#{telephone} where id=#{id}")
    void update(Admin admin);

    @Delete("delete from admin where id = #{id}")
    void delete(Integer id);

    @Select({"<script>" +
            "   select * from admin" +
            "       <where>" +
            "           <if test = \"id != null and id != ''\">" +
            "               and id = #{id}" +
            "           </if>" +
            "           <if test = \"username != null and username != ''\">" +
            "               and username = #{username}" +
            "           </if>" +
            "           <if test = \"password != null and password != ''\">" +
            "               and password = #{password}" +
            "           </if>" +
            "           <if test = \"email != null and email != ''\"> " +
            "               and email = #{email}" +
            "           </if> " +
            "           <if test = \"telephone != null and telephone != ''\">" +
            "               and telephone = #{telephone}" +
            "           </if>" +
            "       </where>" +
            "</script>"})
    List<Admin> findByOption(Admin admin);
}
