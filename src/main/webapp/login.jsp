<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2022/7/19
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登陆界面</title>
    <link rel="stylesheet" type="text/css" href="./CSS/style.css">
</head>
<body>
<div id="login_box">
    <h2>LOGIN</h2>
    <div id="errMsg"> ${login_msg} ${register_msg}</div>
    <form action="/brand-demo/loginServlet" method="post">
        <div id="input_box">
            <input type="text" name="username" placeholder="请输入用户名" value="${cookie.username.value}">
        </div>
        <div class="input_box">
            <input type="password" name="password" placeholder="请输入密码" value="${cookie.password.value}">
        </div>

        <label class="check_box" for="remember">记住密码</label>
        <input type="checkbox" id="remember" name="remember" value="1" >

        <div>
            <input type="submit" name="register" value="登录" class="btn">
        </div>

    </form>
    <div class="msg">
        Don't have account?
        <a href="/brand-demo/register.jsp">Sign up</a>
    </div>

</div>
</body>
</html>
