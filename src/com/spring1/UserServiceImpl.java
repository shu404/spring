package com.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
    提供和@Component注解功能相同的3个注解，分别应用于不同层
        @Controller
        @Service
        @Repository
 */
// @Component // 将目标类注册到容器中 <bean class="" id="">
@Service
@Scope("prototype")  //<bean class="" id="" scope="">
public class UserServiceImpl implements UserService {
    @Value("李四")
    private String name;
    //@Value("李四")
    public void setName(String name) {
        this.name = name;
    }
    /*
    引用类型属性注入：
        按类型注入   @Autowarid
        按名称注入
                @Autowarid      @Qualifier(id)
                @Resource(name=id)
     */
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int saveUser() {
        System.out.println("name="+name);
        userDao.insertUser();
        return 0;
    }

    //@PostConstruct
    public void init(){
        System.out.println("UserServiceImpl.init");
    }

    //@PreDestory
    public void des(){
        System.out.println("UserServiceImpl.des");
    }

}
