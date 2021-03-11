<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/1/23
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/books/"/>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="pages/script/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            $("input:submit").click(function () {
                if(${ empty requestScope.book }) {
                    return confirm("您确定要添加吗？");
                }else if(!${ empty requestScope.book }) {
                    return confirm("您确定要修改吗？");
                }

            })
        })
    </script>
</head>
<body>
<h1>编辑图书</h1>
<form action="manager/bookServlet" method="post">
        <input type="hidden" value="${param.pageNo}" name="pageNo"/>
        <input type="hidden" value="${ empty requestScope.book ? "addBook":"updateBook" }" name="action"/>
        <input type="hidden" value="${requestScope.book .id}" name="id"/>
        书名:<input type="text" name="name" value="${requestScope.book.name}" />
        作者:<input type="text" name="author" value="${requestScope.book.author}"/>
        价格:<input type="text" name="price" value="${requestScope.book.price}"/>
        销量:<input type="text" name="sales" value="${requestScope.book.sales}"/>
        库存:<input type="text" name="stock" value="${requestScope.book.stock}"/>
        <input type="submit" value="提交"/>
</form>
</body>
</html>
