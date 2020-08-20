package com.dfj.dao;

import com.dfj.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentDao {
    @Select("select * from student")
    List<Student> findAll();

    @Select("select * from student where id = #{id}")
    Student findById(Integer id);

    @Insert("insert into student values(null,#{name},#{age},#{score})")
    void save(Student student);

    @Update("update student set name = #{name},age = #{age},score = #{score} where id = #{id}")
    void update(Student student);

    @Delete("delete from student where id = #{id}")
    void deleteById(Integer id);
}
