<%--
  Created by IntelliJ IDEA.
  User: 86186
  Date: 2022/7/19
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>注册界面</title>
    <link rel="stylesheet" type="text/css" href="./CSS/style.css">
</head>
<body>
<div id="login_box">
    <h2>REGISTER</h2>
    <div id="errMsg"> ${register_msg} </div>
    <form action="/brand-demo/registerServlet" method="post">
        <div id="input_box">
            <input type="text" name="username" placeholder="请输入用户名">
        </div>
        <div class="input_box">
            <input type="password" name="password" placeholder="请输入密码">
        </div>
        <div>
            <input type="submit" name="login" value="注册" class="btn">
        </div>
    </form>
</div>
</body>
</html>
