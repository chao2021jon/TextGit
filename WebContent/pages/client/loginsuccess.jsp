<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/1/17
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/books/"/>
</head>
<body>
    <form action="manager/bookServlet" method="post">
        <h1>欢迎${ sessionScope.user }登录书城</h1>
        <input type="hidden" value="page" name="action"/>
        <input type="submit" value="图书管理"/>
    </form>
    <div>
        <a href="index.jsp">返回主页</a>
    </div>
</body>
</html>
