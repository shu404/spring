package com.spring1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public int insertUser() {
        System.out.println("插入用户");
        return 0;
    }
}
