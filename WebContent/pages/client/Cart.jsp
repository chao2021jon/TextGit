<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/2/7
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="http://localhost:8080/books/"/>
<html>
<head>
    <title>购物车</title>
    <script type="text/javascript" src="pages/script/jquery-1.7.2.js"></script>
    <script>
        $(function () {
           $("a.delete").click(function () {
               return confirm("确定要删除吗【" + $(this).parent().parent().find("td:first").text() + "】？");
           });
           $("a.clear").click(function () {
               return confirm("确定要清空购物车？");
           });
           $("a.totalCount").click(function () {
               return false;
           });
            $("a.totalPrice").click(function () {
                return false;
            });
            $(".count").change(function () {

                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;
                //判断用户是否输入0
                if( count == 0 ) {
                    alert("请输入正确的数量");
                    //参数变为默认
                    this.value = this.defaultValue;
                    //取消操作
                    return false;
                }
               if (confirm("你确定要将【"+ name +"】商品数量修改为" + count + "吗？")) {
                    //确认，参数修改
                   var id = $(this).attr("bookId");
                   location.href = "cartServlet?action=updateCount&count=" + count +"&id=" +id;
               } else {
                   //取消，参数变为默认
                   this.value = this.defaultValue;
               }
            });
        });
    </script>
</head>
<body>
    <h1>书城购物车</h1>
    <table>
        <c:if test="${ not empty sessionScope.cart.items}">
        <tr>
            <th>商品名称</th>
            <th>数量</th>
            <th>价格</th>
            <th>总价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td>${item.value.name}</td>
                <td><input class="count" type="text" value="${item.value.count}" bookId="${item.value.id}"  style="width: 50px" /></td>
                <td>${item.value.price}</td>
                <td>${item.value.totalPrice}</td>
                <td><a href="cartServlet?action=deleteItem&id=${item.value.id}" class="delete">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td>商品数量</td>
            <td><a href="#" class="totalCount">${sessionScope.cart.totalCount}</a></td>
            <td>总金额</td>
            <td><a href="#" class="totalPrice"> ${sessionScope.cart.totalPrice}</a></td>
            <td><a href="cartServlet?action=clear" class="clear">清空购物车</a></td>
            <td><a href="orderServlet?action=createOrder">去结账</a></td>
        </tr>

        </c:if>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td><a href="/books/index.jsp">还没有添加商品，去商场看看吧<a></td>
            </tr>
        </c:if>
    </table>
</body>
</html>
