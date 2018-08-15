<%-- 
    Document   : fail
    Created on : 2017-6-7, 8:10:43
    Author     : yongcheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登陆失败</title>
        
        <script type="text/javascript"> 
            onload=function(){ 
            setTimeout(go, 2000); 
            }; 
            function go(){ 
            location.href="Login.jsp"; 
           } 
</script> 
    </head>
    <body>
        <h2>用户名或密码错误</h2>
        <br><h4><a href="Login.jsp">正在跳转...</a></h4>
    </body>
</html>
