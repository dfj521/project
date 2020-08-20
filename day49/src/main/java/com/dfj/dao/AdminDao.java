package com.dfj.dao;

import com.dfj.entity.Admin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminDao {

    @Select("select * from admin")
    List<Admin> findAll();
}
