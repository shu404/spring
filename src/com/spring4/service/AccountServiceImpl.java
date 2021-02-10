package com.spring4.service;

import com.spring4.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean zhuanZhang(Integer out, Integer in, Float money) {
        accountDao.out(out,money);
//        int a = 3/0;
        accountDao.in(in,money);
        return true;
    }
}
