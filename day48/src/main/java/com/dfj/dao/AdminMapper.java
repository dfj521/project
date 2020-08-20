package com.dfj.dao;

import com.dfj.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    List<Admin> findByName(String username);

    List<Admin> findById(Integer id);

    List<Admin> findByNameAndPwd(@Param("username") String username, @Param("password") String password);

    void update(Admin admin);

    List<Admin> findByEmailOrTel(@Param("email")String email,@Param("telephone") String telephone);

    List<Admin> findByIds(@Param("ids")Integer[] ids);
}
