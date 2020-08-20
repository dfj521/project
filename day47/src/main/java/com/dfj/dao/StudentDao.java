package com.dfj.dao;

import com.dfj.entity.ClassGrade;
import com.dfj.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {

    @Select("select * from student")
    @Results({
            @Result(id = true,column = "student_id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(
                    column = "class_no",
                    property = "classGrade",
                    javaType = ClassGrade.class,
                    one = @One(select = "com.dfj.dao.ClassGradeDao.findById")
            )
    })
    List<Student> findAll();

    @Insert("insert into student values(null,#{name},#{age},#{classNo})")
    void add(Student student);

    @Delete("delete from student where student_id = #{id}")
    void delete(Integer id);

    @Select({"<script>" +
            "   select * from student" +
            "       <where>" +
            "           <if test = \"id != null and id != ''\">" +
            "               and student_id = #{id}" +
            "           </if>" +
            "           <if test = \"name != null and name != ''\">" +
            "               and name = #{name}" +
            "           </if>" +
            "           <if test = \"age != null and age != ''\">" +
            "               and age = #{age}" +
            "           </if>" +
            "           <if test = \"classNo != null and classNo != ''\">" +
            "               and class_no = #{classNo}" +
            "           </if>" +
            "       </where>" +
            "</script>"})
    @Results({
            @Result(id = true,column = "student_id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "class_no",property = "classNo")
    })
    List<Student> findByOption(Student student);
}
