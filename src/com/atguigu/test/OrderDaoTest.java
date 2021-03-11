package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemimpl;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        System.out.println( orderDao.saveOrder(new Order(1,new Date(),new BigDecimal(39.9),0,"20210")));
    }

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemimpl();
        orderItemDao.saveOrderItem(new OrderItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5),"20210"));
        orderItemDao.saveOrderItem(new OrderItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5),"20210"));
        orderItemDao.saveOrderItem(new OrderItem(2,"Python基础",1,new BigDecimal(69.0),new BigDecimal(69.0),"20210"));
    }
    @Test
    public void queryOrderByOrderId() {

        OrderDao orderDao = new OrderDaoImpl();

        for (Order i: orderDao.queryOrderByUserId(1)) {
            System.out.println(i);
        }

    }
}