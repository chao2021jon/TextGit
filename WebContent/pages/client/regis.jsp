<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <base href="http://localhost:8080/books/">
    <style>
        #form{
            text-align: center;
        }
        #table{
            margin: auto;
        }
    </style>

    <script type="text/javascript" src="pages/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#submit").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                var regpassword = $("#regpassword").val();
                var email = $("#email").val();
                //判断用户名是否正确
                var useremp = /^[a-z0-9_-]{5,16}$/;
                if(!useremp.test(username)){
                    $("#div").text("用户名不正确");
                    return false;
                }
                //判断密码是否正确
                var pwdemp = /^[a-z0-9_-]{6,18}$/;
                if(!pwdemp.test(password)){
                    $("#div").text("密码不正确");
                    return false;
                }
                //判断确认密码
                if(password != regpassword){
                    $("#div").text("密码跟确认密码不一致");
                    return false;
                }
                //判断邮箱格式是否正确
                var emailemp = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!emailemp.test(email)){
                        $("#div").text("邮箱格式不正确");
                        return false;

                }
            })
            //给图片验证码绑定单击事件
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
        })
            $("#username").blur(function () {
                var username = $(this).val();

                $.getJSON("http://localhost:8080/books/manager/UserServlet","action=JsonUsernameExist&username=" + username,function (data) {
                    if (data.UsernameExist) {
                        $("#div").text("用户名已存在");
                    } else {
                        $("#div").text("");
                    }
                });

            });
        });

    </script>
</head>
<body>
    <form method="post" action="/books/manager/UserServlet" id="form">
        <input type="hidden" name="action" value="regis"/>
        <h1>注册用户</h1>
        <table id="table">
            <div id="div">${ empty requestScope.ero ? "" : requestScope.ero } </div>
            <tr>
                <td>用户名:</td>
                <td><input type="text" id="username" name="username"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" id="password" name="password"/></td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input type="password" id="regpassword"/></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" id="email" name="email"/></td>
            </tr>
            <tr>
                <td>验证码：</td>
                <td><input type="text" name="code" style="width: 80px"/></td>
                <td><img src="kaptcha.jpg" style="width: 100px;height: 30px"  id="code_img" /></td>
            </tr>
            <tr>
                <td><input type="reset"/></td>
                <td><input type="submit" value="提交" id="submit"/></td>
            </tr>

        </table>
        <!-- 这是书城项目的注册验证 -->
    </form>
</body>
</html>