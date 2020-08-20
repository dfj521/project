package com.dfj.dao;

import com.dfj.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInfoDao extends CrudRepository<UserInfo, Integer> {
    /**
     * 查询方法必须以find|get|read开头
     * 涉及查询条件时，条件的属性用条件关键字连接
     * 要注意的是，条件属性以首字母大写
     * @param name
     * @return
     */
    List<UserInfo> findByName(String name);

    List<UserInfo> findUserInfosByNameOrAge(String name, Integer Age);

    List<UserInfo> findUserInfosByNameLike(String name);

    /**
     * HQL: hibernate
     * JPQL: SpringDataJPA
     * @param age
     * @return
     */
    @Query("from UserInfo where age = ?1")
    List<UserInfo> findByAge(Integer age);
}
