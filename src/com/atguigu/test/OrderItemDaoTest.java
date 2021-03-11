package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemimpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void queryOrderByOrderId() {
        OrderItemDao orderItemDao = new OrderItemimpl();
        List<OrderItem> orderItems = orderItemDao.queryOrderByOrderId("20210");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}