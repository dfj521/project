package com.dfj.service.impl;

import com.dfj.dao.StudentDao;
import com.dfj.entity.Student;
import com.dfj.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }

    @Override
    public List<Student> findByOption(Student student) {
        return studentDao.findByOption(student);
    }
}
