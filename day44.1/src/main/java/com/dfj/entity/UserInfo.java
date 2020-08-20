package com.dfj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 这个Entity的注解会告诉配置文件这是一个实体类
 * 配置文件会根据EntityManagerFactory来判断是否
 * 有这个表，如果没有将自动生成
 */
@Entity
public class UserInfo {
    private Integer id;
    private String name;
    private Integer age;

    @GeneratedValue //这个主键id是自增长的
    @Id //这个注解就是告诉配置文件这个id是主键
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 20, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
