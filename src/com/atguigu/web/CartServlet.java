package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceimpl;
import com.atguigu.utils.WebUtlis;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends baseServlet {
    BookService bookService = new BookServiceimpl();
    /**
     * 添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtlis.parseInt(req.getParameter("id"),0);
        //根据id查询信息
        Book book = bookService.queryBookById(id);
        //从Session中获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断购物车对象是否存�?
        if( cart == null ) {
            //不存在，创建
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //将商品存放到购物车商品中
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",book.getName());
        //重定向回原页�?
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtlis.parseInt(req.getParameter("id"),0);
        //根据id查询信息
        Book book = bookService.queryBookById(id);
        //从Session中获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断购物车对象是否存�?
        if( cart == null ) {
            //不存在，创建
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        //将商品存放到购物车商品中
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",book.getName());
        //返回商品总数量和添加的商品名�?
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("lastName",cartItem.getName());
        map.put("totalCount",cart.getTotalCount());
        Gson gson = new Gson();
        String StringJson = gson.toJson(map);
        resp.getWriter().write(StringJson);
    }

    /**
     * 删除商品�?
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，商品编�?
        int id = WebUtlis.parseInt(req.getParameter("id"),0);
        //获取购物车对�?
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //根据id删除商品
        cart.deleteItem(id);
        //重定向回原页�?
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物�?
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对�?
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if ( cart != null ) {
            //清空购物�?
            cart.clear();
            //重定向回原页�?
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * 修改商品数量
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数总数，编�?
        int id = WebUtlis.parseInt(req.getParameter("id"),0);
        int count = WebUtlis.parseInt(req.getParameter("count"),1);

        //获取购物车对�?
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if( cart != null ) {
            //修改商品数量
            cart.updateCount(id,count);
            //重定向回原页�?
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
}
