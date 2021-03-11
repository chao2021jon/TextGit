<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/3/8
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>书名</th>
        <th>总数</th>
        <th>单价</th>
        <th>总价</th>
    </tr>
    <c:forEach items="${sessionScope.books}" var="OrderItme">
        <tr>
            <td>${OrderItme.name}</td>
            <td>${OrderItme.count}</td>
            <td>${OrderItme.price}</td>
            <td>${OrderItme.total_Price}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
