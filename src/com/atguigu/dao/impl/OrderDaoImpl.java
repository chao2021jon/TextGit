package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

       return update(sql,order.getOrder_Id(),order.getCreate_Time(),order.getPrice(),order.getStatus(),order.getUser_Id());
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {

        String sql = "select `order_id`,`create_time`,`price`,`status`,`user_id` from t_order where  `user_id`=?";
       return  queryForlist(Order.class,sql,userId);
    }

}
