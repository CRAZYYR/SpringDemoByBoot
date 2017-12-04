package com.mylzs.cn.cn.service;

import com.mylzs.cn.cn.dao.StudentDao;
import com.mylzs.cn.cn.entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 17/12/4.
 */
@Service("studentService")
public class StudentServiceImp implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public void add(Student student) {
        studentDao.save(student);
    }
}
