<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈豪
  Date: 2021/1/28
  Time: 19:04
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
            $(".add").click(function () {
                //判断用户登录
                if (($(this).attr("user")) == "") {
                    //未登录，提示登录，并取消操作
                    alert("请先登录");
                    return false
                }else {
                    var id = $(this).attr("Id");
                    $.getJSON("http://localhost:8080/books/cartServlet","action=ajaxAddItem&id="+ id +"",function (data) {
                        $("#totalCount").text("您的购物车有"+ data.totalCount +"件商品");
                        $("#lastName").text("您刚刚将【"+ data.lastName +"】添加到购物车");
                    })

                }
            });
        });


    </script>
    <style type="text/css">
        * {
            box-sizing: border-box;
        }
        #divClass {
            margin-bottom: 30px;
            float: left;
            width: 25%;
            height: 160px;
            text-align: center;
            border-style: groove;

        }
        .clearfix::after {
            content: "";
            clear: both;
            display: table;
        }
        .page {
            text-align: center;
            height: 25%;
        }
        .section {
           text-align: center;
            margin-bottom: 30px;
        }
        .title {
            margin-top: 50px;
            text-align: center;
            height: 25%;
        }
    </style>
</head>
<body>
    <div class="title">
        <c:if test="${ not empty sessionScope.user }" >
            <h1>欢迎${ sessionScope.user.username }登录彦祖书城</h1>

            <a href="manager/UserServlet?action=logout">注销</a>
            <a href="manager/bookServlet?action=page" >图书管理</a>
            <a href="pages/client/Cart.jsp">购物车</a>
            <a href="orderServlet?action=queryOrderByUserId">我的订单</a>

        </c:if>
        <c:if test="${ empty sessionScope.user }" >
            <h1>欢迎光临彦祖书城</h1>
            <a href="pages/client/login.jsp" >登录|</a>
            <a href="http://localhost:8080/books/pages/client/regis.jsp">注册</a>
        </c:if>
    </div>
    <c:forEach items="${requestScope.page.items}" var="book" >
    <div id="divClass" class="clearfix">
        <div><img src="${book.imgPath}"/></div>
        <div>书名：${book.name}</div>
        <div>作者：${book.author}</div>
        <div>价格：${book.price}</div>
        <div>销量：${book.sales}</div>
        <div>库存：${book.stock}</div>
        <div><input type="button"  class="add" user="${sessionScope.user}" Id="${book.id}" value="加入购物车"></input></div>
    </div>
    </c:forEach>
    <div class="section">
        <c:if test="${ not empty sessionScope.user }" >

            <sapn id="totalCount">您的购物车有${sessionScope.cart.totalCount}件商品</sapn><br/>
            <sapn id="lastName">您刚刚将【${sessionScope.lastName}】添加到购物车</sapn></br>
        </c:if>
    </div>
    <form action="client/clientBookServlet" method="post" class="section">
        <span>查询价格区间</span>
        <input type="hidden" name="action" value="pageByPrice"/>
        <input type="text" name="min" value="${ param.min }" style="width: 30px"/>-
        <input type="text" name="max" value="${ param.max }" style="width: 30px"/>
        <input type="submit" value="查询"/>
    </form>
    <div class="page">

        <hr>
        <%-- 静态包含分页条 --%>
        <jsp:include page="/pages/comon/Url.jsp"></jsp:include>

    </div>
</body>
</html>
