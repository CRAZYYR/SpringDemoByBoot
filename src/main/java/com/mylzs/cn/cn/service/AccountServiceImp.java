package com.mylzs.cn.cn.service;

import com.mylzs.cn.cn.dao.AccountDao;
import com.mylzs.cn.cn.entity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 17/12/4.
 */
@Service("accountService")
public class AccountServiceImp implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    @Transactional
    /**
     * 业务转账
     */
    public void tranferAccount(int fromUser, int toUser, float account) {
        Account fromAccount= accountDao.getOne(fromUser);
        fromAccount.setBalance(fromAccount.getBalance()-account);
        if (fromAccount.getBalance()<0){
            throw  new RuntimeException("卡上余额不足!");
        }
        accountDao.save(fromAccount);
        Account toAccount=accountDao.getOne(toUser);

        toAccount.setBalance(toAccount.getBalance()+account);
        accountDao.save(toAccount);
    }
}
