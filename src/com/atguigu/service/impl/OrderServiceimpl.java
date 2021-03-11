package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoimpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemimpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceimpl implements OrderService {
    private BookDao bookDao = new BookDaoimpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemimpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        OrderDao orderDao = new OrderDaoImpl();
        //创建订单id
        String orderId = System.currentTimeMillis()+"" + userId;
        //保存订单信息
        orderDao.saveOrder(new Order(userId,new Date(),cart.getTotalPrice(),0,orderId));

        OrderItemDao orderItemDao = new OrderItemimpl();
        //保存订单�?
        for(Map.Entry<Integer, CartItem> Entry: cart.getItems().entrySet()) {

            CartItem cartItem = Entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookOne(cartItem.getId());
            book.setSales( book.getSales() + cartItem.getCount() );
            book.setStock( book.getStock() - cartItem.getCount() );
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;
    }

    public List<Order> queryOrderByUserId(Integer userId) {

        return orderDao.queryOrderByUserId(userId);
    }

    @Override
    public List<OrderItem> queryOrderByOrderId(String OrderId) {
        return orderItemDao.queryOrderByOrderId(OrderId);
    }
}
