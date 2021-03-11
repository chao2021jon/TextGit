package com.atguigu.service;

import com.atguigu.pojo.User;

public interface Service {
    /**
     * 注册用户
     * @param user
     */
    public void regis(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * �?查用户名是否存在
     * @param username
     * @return 存在返回ture 反之亦然
     */
    public boolean existUsername(String username);
}
