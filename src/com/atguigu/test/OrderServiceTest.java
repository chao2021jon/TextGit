package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceimpl;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        OrderService orderService = new OrderServiceimpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(1,"java从入门到精�??",1,new BigDecimal(39.5),new BigDecimal(39.5)));
        cart.addItem(new CartItem(2,"Python基础",1,new BigDecimal(69.0),new BigDecimal(69.0)));
        System.out.println(orderService.createOrder(cart,1));
    }

    @Test
    public void queryOrderByOrderId() {
        OrderService orderService = new OrderServiceimpl();
        for ( Order order : orderService.queryOrderByUserId(8)) {
            System.out.println(order);
        }
    }

    @Test
    public void testQueryOrderByOrderId() {
        OrderService orderService = new OrderServiceimpl();
        List<OrderItem> orderItems = orderService.queryOrderByOrderId("20210");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}