package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.Service;
import com.atguigu.service.impl.Serviceimpl;
import org.junit.Test;

public class ServiceTest {
    Service service = new Serviceimpl();
    @Test
    public void regis() {
        service.regis(new User(null,"eson","eson","eson@163.com"));
    }

    @Test
    public void login() {
        System.out.println(service.login(new User(null,"eson","eson",null)));
    //service.login(new User(null,"chenhao","chenhao",null));
    }

    @Test
    public void existUsername() {
        if ( service.existUsername("yison") != true ) {
            System.out.println("用户名不存在");
        }else {
            System.out.println("用户名已存在");
        }
    }
}