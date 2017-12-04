package com.mylzs.cn.cn.dao;

import com.mylzs.cn.cn.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Created by Administrator on 17/12/4.
 */
public interface AccountDao extends JpaRepository<Account,Integer> {
}
