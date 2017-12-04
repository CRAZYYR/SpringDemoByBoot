package com.mylzs.cn.cn.controller;

import com.mylzs.cn.cn.entity.Student;
import com.mylzs.cn.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by Administrator on 17/12/4.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    @Qualifier("studentService")
    private StudentService  studentService;

    /**
     * 学生信息添加
     * @param student
     * @return
     */
    @PostMapping("/add")
    public String addStudent(@Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return bindingResult.getFieldError().getDefaultMessage();

try {
    studentService.add(student);

    return "ok";
}catch (Exception e){
    return e.toString();
}

    }

}
