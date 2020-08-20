package com.dfj.service;

import com.dfj.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    void add(Student student);

    void delete(Integer id);

    List<Student> findByOption(Student student);
}
