package com.spring3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring3/beans.xml")
public class TestDemo {
    @Autowired
    UserDao userDao;

    @Test
    public void test1(){
//        userDao.selectUser();
//        System.out.println(userDao.query1());
//        System.out.println(userDao.query2());
//        System.out.println(userDao.query3());
//        System.out.println(userDao.query4());
//        System.out.println(userDao.query51());
//        System.out.println(userDao.query52());
//        System.out.println(userDao.query53());
//        userDao.query54();
//        System.out.println(userDao.query55());

//        userDao.update1();
//        userDao.update2();
//        UserBean userBean = new UserBean();
//        userBean.setUsername("李四");
//        userBean.setPwd("1234");
//        userDao.update4(userBean);
//        System.out.println(userBean);

        List<UserBean> users = new ArrayList<>();
        for(int i=0;i<23;i++){
            UserBean user = new UserBean();
            user.setUsername("TOM"+i);
            user.setPwd("123"+(i+5));
            users.add(user);
        }

        userDao.update53(users);

    }


}
