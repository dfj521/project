package com.dfj.service;

import com.dfj.entity.ClassGrade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassGradeService {

    List<ClassGrade> findAll();
}
