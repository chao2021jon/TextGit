package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceimpl;
import com.atguigu.utils.WebUtlis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends baseServlet {
        private BookService bookService = new BookServiceimpl();
    protected void ShowBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //1、获取BookService 方法
        bookService = new BookServiceimpl();
        //2、查询所有书
        List<Book> books = bookService.queryBookList();
        //3、把查到的书存到req区域�?
        req.setAttribute("books",books);
        //4、转发到图书管理页面
        req.getRequestDispatcher("/pages/manager/control.jsp").forward(req,resp);
    }

    protected void addBook(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int pageNo = WebUtlis.parseInt(req.getParameter("pageNo"),1);
        req.setCharacterEncoding("UTF-8");   //的作用是设置对客户端请求进行重新编码的编码�??
        resp.setCharacterEncoding("UTF-8");      //的作用是指定对服务器响应进行重新编码的编码�??
        //1、将数据封装到JavaBean�?
        Book book = WebUtlis.copyParamToBean(new Book(),req.getParameterMap());
        //2、调用添加书籍方�?
        BookService bookService = new BookServiceimpl();
        bookService.addBook(book);
        //3、使用重定向，跳转回书库管理页面
        resp.sendRedirect("bookServlet?action=page&pageNo="+pageNo);
    }

    protected void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参数id
        int id = WebUtlis.parseInt(req.getParameter("id"),0);
        //2、调用deleteById方法
        bookService.deleteBookById(id);
        //3、返回到图书管理页面
        resp.sendRedirect( "bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求参�?
        int id = WebUtlis.parseInt(req.getParameter("id"),0);
        //2、根据请求参数查询book信息
        Book book = bookService.queryBookById(id);
        //3、将查到的信息存储到request域中
        req.setAttribute("book",book);
        //4、转发到修改图书页面
        req.getRequestDispatcher("/pages/manager/updatebook.jsp").forward(req,resp);
    }

    protected void updateBook(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、获取请求参数，保存到JavaBean�?
        Book book = WebUtlis.copyParamToBean(new Book(),req.getParameterMap());
        //2、调用updateBook方法修改图书信息
        bookService.updateBook(book);
        //3、重定向到图书管理页�?
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //1、获取请求参�?
        int pageNo = WebUtlis.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtlis.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、将参数传�?�给bookservice.page方法
        Page page = null;
        page = bookService.page(pageNo,pageSize);
        if ( pageNo > page.getPageTotal() ) {
            pageNo = page.getPageTotal();
            page = bookService.page(pageNo,pageSize);
        } else {
            page = bookService.page(pageNo, pageSize);
        }
        StringBuilder sb = new StringBuilder("manager/bookServlet?action=page");
        page.setUrl(sb.toString());
        //3、将返回的参数保存到request域中
        req.setAttribute("page",page);
        //4、转发到books/pages/manager/control.jsp
        //�?.件[/books/pages/manager/control.jsp] 未找�?
        req.getRequestDispatcher("/pages/manager/control.jsp").forward(req,resp);
    }
}
