package com.mylzs.cn.cn.controller;

import com.mylzs.cn.cn.service.AccountService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 17/12/4.
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    @Qualifier("accountService")
    private AccountService accountService;
    @RequestMapping("/tranferAccount")
    public  String tranFerAccount(){
        try {
            accountService.tranferAccount(1,2,200);
            return "ok";
        }catch (RuntimeException e){
            return e.toString();
        }

    }
}
