package com.mylzs.cn.cn.dao;

import com.mylzs.cn.cn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 17/12/4.
 */
public interface StudentDao extends JpaRepository<Student,Integer> {
}
