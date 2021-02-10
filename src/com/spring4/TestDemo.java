package com.spring4;

import com.spring3.UserBean;
import com.spring3.UserDao;
import com.spring4.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring4/beans.xml")
public class TestDemo {
    @Autowired
    AccountService accountService;

    @Test
    public void test1(){
        System.out.println(accountService);
        System.out.println(accountService.zhuanZhang(123456789,123456788,200f));
    }
}
