package com.dfj.dao;

import com.dfj.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 使用Mybatis的接口映射
 * 使用接口映射的规则：
 *  1.接口的引用必须是指定的命名空间
 *  2.接口里的抽象方法名必须是sqlId
 *  3.接口里的抽象方法参数列表以及返回值类型要和mapper.xml中的<select>的属性保持一致
 *  4.抽象方法的参数列表，对应的是parameterType属性
 *  5.抽象方法的返回值，对应的是resultType属性
 *  6.mapper.xml中的sql又称为Dao接口的xml实现
 */
public interface AdminDao {

    List<Admin> findAll();

    //对于多个参数的建议是使用注解
    List<Admin> findByNameAndAge(@Param("name") String name, @Param("password") String password);

    List<Admin> findByNameAmdTel(@Param("name") String name, @Param("telephone") String telephone);
}
