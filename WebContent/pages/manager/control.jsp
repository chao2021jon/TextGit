<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/1/17
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/books/"/>
<html>
<head>
    <title>图书管理</title>
    <script type="text/javascript" src="pages/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("你确定要删除【"+ $(this).parent().parent().find("td:first").text() +"】?");
            })
        });
        $(function () {
            $("#button").click(function () {
                var pageNo = $("#pn_input").val();
                location.href = "http://localhost:8080/books/${requestScope.page.url}?action=page&pageNo=" + pageNo;
            })
        });
    </script>
    <style type="text/css">
        #form {
            text-align: center;
        }
        #table {
            margin: auto;
            border-collapse: collapse;
            margin-bottom: 50px;
        }
        table,th, td {
            padding: 15px;
            text-align: left;
            border: 1px solid black;
        }
        #operation {
            margin-bottom: 50px;
        }
    </style>
</head>
<body>
    <form id="form" >
        <h1 class="center">图书管理</h1>
            <table id="table">
                <tr>
                    <th>书名</th>
                    <th>作者</th>
                    <th>价格</th>
                    <th>销量</th>
                    <th>库存</th>
                    <th>操作</th>
                    <th>删除</th>
                </tr>
                <c:forEach items="${requestScope.page.items}" var="book">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.sales}</td>
                        <td>${book.stock}</td>

                        <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                        <td><a class="deleteClass" href="manager/bookServlet?action=deleteBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        <div class="center">
            <div id="operation">
                <a href="pages/manager/updatebook.jsp?pageNo=${requestScope.page.pageNo}">添加图书</a>
                <a href="http://localhost:8080/books/">返回首页</a>
            </div>
            <%-- 静态包含分页条 --%>
            <jsp:include page="/pages/comon/Url.jsp"></jsp:include>
        </div>
    </form>
</body>
</html>
