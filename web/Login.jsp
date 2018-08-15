<%-- 
    Document   : Login
    Created on : 2017-6-5, 21:48:13
    Author     : yongcheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员管理系统</title>
<link type="text/css" rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src = "./js/SignIn.js"></script>
</head>

<body>
	<div class="div">
        <p class="title">个人博客登陆</p>
        <p class="signin">登录验证</p>
        <form action="Login" method="post" onsubmit="return check1(this)">
            <div><input type="text" name="username" placeholder="学号" /></div>
            <div><input type="password" name="password" placeholder="密码" /></div><br>
            <input type="submit"  class="btn" value="登陆"/>
		    <a href="register.jsp">注册账号</a>
		</form>
	</div>
   
    
</body>
</html>
