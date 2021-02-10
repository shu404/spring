package com.spring2;

import com.spring1.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring2/beans.xml")
public class TestDemo {
    @Autowired
    UserDao userDao;

    @Test
    public void test1(){
        userDao.selectUser();
    }
}
