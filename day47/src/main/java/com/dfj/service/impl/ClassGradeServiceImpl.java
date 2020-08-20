package com.dfj.service.impl;

import com.dfj.dao.ClassGradeDao;
import com.dfj.entity.ClassGrade;
import com.dfj.service.ClassGradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassGradeServiceImpl implements ClassGradeService {

    @Resource
    private ClassGradeDao classGradeDao;

    @Override
    public List<ClassGrade> findAll() {
        return classGradeDao.findAll();
    }
}
