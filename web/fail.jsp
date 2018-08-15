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
        <title>注册失败</title>
        
        <script type="text/javascript"> 
            onload=function(){ 
            setTimeout(go, 2000); 
            }; 
            function go(){ 
            location.href="register.jsp"; 
           } 
</script> 
    </head>
    <body>
        <h2>失败原因：<%=request.getParameter("text")%></h2>
        <br><h4><a href="register.jsp">正在跳转...</a></h4>
    </body>
</html>
