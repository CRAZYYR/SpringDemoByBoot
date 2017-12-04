package com.mylzs.cn.cn.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 17/12/4.
 */
@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty(message = "姓名不能为空!")
    @Column(length = 50)
    private  String name;
    @NotNull(message = "年龄不能为空!")
    @Min(value = 18,message = "年龄必须大于18岁!")
    private  String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
