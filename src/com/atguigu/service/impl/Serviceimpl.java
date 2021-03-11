package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoimpl;
import com.atguigu.pojo.User;
import com.atguigu.service.Service;

public class Serviceimpl implements Service {

    UserDao userdao = new UserDaoimpl();
    @Override
    public void regis(User user) {
        userdao.addUser(user);
    }

    @Override
    public User login(User user) {
        return userdao.queryByUserNameandPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if( userdao.queryByUserName(username) != null) {
            return true;
        }else{
            return false;
        }
    }
}
