<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/2/12
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/books/"/>
<html>
<head>
    <title>订单页面</title>
</head>
<body>
    <c:if test="${ not empty sessionScope.Order}">
        <table>
            <tr>
                <th>日期</th>
                <th>金额</th>
                <th>状态</th>
                <th>详情</th>
            </tr>
            <c:forEach items="${sessionScope.Order}" var="Order" >
            <tr>
                <td>${Order.create_Time}</td>
                <td>${Order.price}</td>
                <td>${Order.status}</td>

                <td><a href="orderServlet?action=queryOrderItemByOrderId&OrderId=${Order.order_Id}">查看详情</a></td>
            </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${ empty sessionScope.Order}">
        <span>您还没有任何订单信息！！！</span>
    </c:if>
</body>
</html>
