package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public class OrderItemimpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";

        return update(sql, orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotal_Price(),orderItem.getOrderId());
   }

    @Override
    public List<OrderItem> queryOrderByOrderId(String OrderId) {
        String sql = "SELECT `id`,`name`,`count`,`price`,`total_price`,`order_id` FROM t_order_item WHERE  `order_id`=?";

        return queryForlist(OrderItem.class,sql,OrderId);
    }

}
