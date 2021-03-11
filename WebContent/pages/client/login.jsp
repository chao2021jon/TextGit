<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <base href="http://localhost:8080/books/">
</head>
<style type="text/css">
    #form {
        text-align: center;
    }
    #table {
        margin: auto;
    }
</style>
<body>
    <form action="manager/UserServlet" method="post" id="form">
        <input type="hidden" name="action" value="login"/>
        <h1>用户登录</h1>
        <div>${ empty requestScope.ero ? "请输入用户名密码" : requestScope.ero }</div>
        <table id="table">
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" id="username"/></td>
            </tr>
           <tr>
               <td>密码:</td>
               <td><input type="password" name="password" id="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录" style="width: 50px"/></td>
            </tr>
        </table>
    </form>
</body>
</html>