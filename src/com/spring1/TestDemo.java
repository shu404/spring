package com.spring1;

import com.spring2.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring1/beans.xml")
public class TestDemo {
    @Autowired
    UserService userService;

    @Test
    public void test1(){
        System.out.println(userService);
        userService.saveUser();
    }
}
