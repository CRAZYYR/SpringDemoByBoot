package com.mylzs.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 17/11/29.
 */
@Controller
@RequestMapping("/user")
public class MyController {
    @RequestMapping("/one")

    public String view(HttpServletRequest request){
        request.setAttribute("name","zhangsan");
        return "one";
    }
}
