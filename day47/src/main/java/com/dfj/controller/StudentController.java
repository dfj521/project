package com.dfj.controller;

import com.dfj.entity.ClassGrade;
import com.dfj.entity.Student;
import com.dfj.service.ClassGradeService;
import com.dfj.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private ClassGradeService classGradeService;

    //查询所有学生基本信息
    @RequestMapping("/studentList.do")
    public String studentList(ModelMap modelMap) {
        List<Student> studentList = studentService.findAll();
        modelMap.addAttribute("studentList", studentList);
        return "student/studentList";
    }

    //添加学生信息页面
    @RequestMapping("/addStudent.do")
    public String addStudent(ModelMap modelMap) {
        List<ClassGrade> classGradeList = classGradeService.findAll();
        modelMap.addAttribute("classGradeList", classGradeList);
        return "student/addStudent";
    }

    //添加学生信息成功
    @RequestMapping("/addOneStudent.do")
    public String addOneStudent(Student student) {
        studentService.add(student);
        return "redirect:/studentList.do";
    }

    //根据条件查询学生信息
    @RequestMapping("/findByStudentOption.do")
    public String findByStudentOption(Student student, ModelMap modelMap) {
        List<Student> studentList = studentService.findByOption(student);
        modelMap.addAttribute("studentList", studentList);
        modelMap.addAttribute("studentOption", student);
        return "student/studentList";
    }

    //删除学生信息
    @RequestMapping("/delStudent.do")
    public String delStudent(Integer id) {
        studentService.delete(id);
        return "redirect:/studentList.do";
    }
}
