package com.dfj.dao;

import com.dfj.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminDao {

    @Insert("insert into admin values(null,#{username},#{password},#{email},#{telephone})")
    void save(Admin admin);

    @Select("select * from admin")
    List<Admin> findAll();
}
