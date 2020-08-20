package com.dfj.dao;

import com.dfj.entity.ClassGrade;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassGradeDao {

    @Select("select * from class_grade")
    @Results({
            @Result(id = true,column = "class_no",property = "id"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "classroom",property = "classroom")
    })
    List<ClassGrade> findAll();

    @Select("select * from class_grade where class_no = #{id}")
    ClassGrade findById(Integer id);
}
