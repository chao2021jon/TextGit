package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.Service;
import com.atguigu.service.impl.Serviceimpl;
import com.atguigu.utils.WebUtlis;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends baseServlet {
    private Service service = new Serviceimpl();
    /**
     * 处理登录请求的页�?
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //1、获取请求参�?
        User user = WebUtlis.copyParamToBean(new User(), req.getParameterMap());
        User login = null;
        //2、调用登录方法登录用�?
        if (user.getUsername() != "" && user.getPassword() != "") {
            login = service.login(user);
        }
        if ( login!= null) {
                //3、登录成�? 跳转到登录成功页�?
                HttpSession session = req.getSession();
                session.setAttribute("user",login);
                //req.setAttribute("user",user.getUsername());
                //req.getRequestDispatcher("/pages/client/loginsuccess.jsp").forward(req,resp);
                resp.sendRedirect(req.getContextPath());
        } else {
            //4、登录失�? 跳转回登录页�? 并提示用户名或密码错�?
            System.out.println("用户名或密码错误");
            req.setAttribute("ero","用户名或密码错误");
            req.getRequestDispatcher("/pages/client/login.jsp").forward(req,resp);
        }

    }

    /**
     * 注销用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        HttpSession session = req.getSession();

        session.invalidate();

        resp.sendRedirect(req.getContextPath());
    }

    protected void JsonUsernameExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //1、获取请求参�?
        String username = req.getParameter("username");
        //2、调用service查询用户名是否可�?
        boolean UsernameExist = service.existUsername(username);
        Map<String,Object> User = new HashMap<>();
        User.put("UsernameExist",UsernameExist);
        Gson gson = new Gson();
        String UsernameExistJson = gson.toJson(User);
        //3、向客户端回传数�?
        resp.getWriter().write(UsernameExistJson);
    }

    /**
     * 处理注册请求的页�?
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regis(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Service service = new Serviceimpl();
        //1、获取并封装请求参数
        User user = WebUtlis.copyParamToBean(new User(),req.getParameterMap());
        String code = req.getParameter("code");
        String img_code = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //2、检查用户名是否可用
        if ( !service.existUsername(user.getUsername()) ) {
            //3、可用，调用service方法注册并跳转至注册成功页面
            if(img_code.equalsIgnoreCase(code)) {
                service.regis(user);
                req.getRequestDispatcher("/pages/client/registsuccess.jsp").forward(req, resp);
            }else {
                req.setAttribute("ero","验证码错�?");
                req.getRequestDispatcher("/pages/client/regis.jsp").forward(req,resp);
            }
        }
        else{
            //4、不可用，跳回此页面，并提示
            System.out.println("用户名已存在");
            req.setAttribute("ero","用户名已存在");
            req.getRequestDispatcher("/pages/client/regis.jsp").forward(req,resp);
        }
    }
}
