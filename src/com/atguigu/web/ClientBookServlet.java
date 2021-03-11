package com.atguigu.web;

import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceimpl;
import com.atguigu.utils.WebUtlis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientBookServlet extends baseServlet {
    BookService bookService = new BookServiceimpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、获取请求参�?
        int pageNo = WebUtlis.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtlis.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、将参数传�?�给bookservice.page方法
        Page page = bookService.page(pageNo,pageSize);
        page.setUrl("client/clientBookServlet?action=page");
        //3、将返回的参数保存到request域中
        req.setAttribute("page",page);
        //4、转发到books/pages/manager/control.jsp
        //�?.件[/books/pages/manager/control.jsp] 未找�?
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、获取请求参�?
        int pageNo = WebUtlis.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtlis.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtlis.parseInt(req.getParameter("min"),0);
        int max = WebUtlis.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2、将参数传�?�给bookservice.page方法
        Page page = bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");
        if( req.getParameter("min") != null ) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if( req.getParameter("max") != null ) {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3、将返回的参数保存到request域中
        req.setAttribute("page",page);
        //4、转发到books/pages/manager/index.jsp
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
