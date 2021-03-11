package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户是否存�?
     * @param username 查询的用户名
     * @return 返回空表示用户名不存�?
     */
    public User queryByUserName(String username);

    /**
     * 根据用户名密码查询用�?,用于登录
     * @param username 用户�?
     * @param password 密码
     * @return 返回空表示用户名或密码错�?
     */
    public User queryByUserNameandPassword(String username, String password);

    /**
     * 保存用户
     * @param user 用户信息�?
     * @return 返回-1表示用户名存�?,保存失败
     */
    public int addUser(User user);

}
