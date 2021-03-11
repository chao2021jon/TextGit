package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
    public List<Order> queryOrderByUserId(Integer userId);

    public List<OrderItem> queryOrderByOrderId(String OrderId);
}
