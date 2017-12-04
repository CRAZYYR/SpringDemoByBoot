package com.mylzs.cn.cn.service;

/**
 * Created by Administrator on 17/12/4.
 */
public interface AccountService {
    /**
     * 转账
     * @param fromUser
     * @param toUser
     * @param account  转账金额
     */
    public void tranferAccount(int fromUser,int toUser,float account);
}
