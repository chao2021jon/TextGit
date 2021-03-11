package com.atguigu.web;

import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceimpl;
import com.atguigu.utils.JdbcUtils;
import com.atguigu.utils.WebUtlis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends baseServlet {
    private OrderService orderService = new OrderServiceimpl();

    /**
     * 保存订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车信�?
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取id
        User user = (User) req.getSession().getAttribute("user");

        int userId = user.getId();
        String orderId = null;
        try {
            orderId = orderService.createOrder(cart,userId);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
        }
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/manager/Payment.jsp");
        //http://localhost:8080/books/orderServlet?action=createOrder
    }

    /**
     * 根据用户Id查询订单�?
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryOrderByUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户信息
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();

        //根据用户id查询订单信息
        List order = orderService.queryOrderByUserId(userId);
        //将查询到的订单信息保存到session域中
        req.getSession().setAttribute("Order",order);
        //重定向到Order.jsp
        resp.sendRedirect(req.getContextPath()+"/pages/manager/Order.jsp");
    }

    /**
     * 根据订单id查询订单信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryOrderItemByOrderId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单id
        String OrderId = req.getParameter("OrderId");
        //调用service层的queryOrderItemByOrderId
        List OrderItems = orderService.queryOrderByOrderId(OrderId);

        req.getSession().setAttribute("books",OrderItems);

        resp.sendRedirect(req.getContextPath() + "/pages/manager/OrderItem.jsp");
    }
}
