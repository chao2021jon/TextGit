package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoimpl;
import com.atguigu.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDao userdao = new UserDaoimpl();
    @Test
    public void queryByUserName() {
        System.out.println( userdao.queryByUserName("admin") );
    }

    @Test
    public void queryByUserNameandPassword() {
        System.out.println( userdao.queryByUserNameandPassword("admin","admin") );
    }

    @Test
    public void addUser() {
        System.out.println( userdao.addUser(new User(null,"chenhao","chenhao","chenhao@163.com")) );
    }
}