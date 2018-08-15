<%-- 
    Document   : register
    Created on : 2017-6-5, 22:10:22
    Author     : yongcheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员注册</title>


        <link href="css/SignIn.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="./js/SignIn.js"></script>

    </head>

    <body>
<%
  String userid = "" , name = "" , sex = "", admin = "" ,password = "";
   response.setContentType("text/html;charset=utf-8");
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 
  if(request.getAttribute("userid")!=null)
    {
    	 userid = (String)request.getAttribute("userid");
    	 name = (String)request.getAttribute("name");
    	 sex =(String)request.getAttribute("sex");
    	 admin = (String)request.getAttribute("admin");  
    	 password = (String)request.getAttribute("password");  	
    	 System.out.println(admin);
    } 
   %>
        <div id="contact">
            <h1>会员注册：</h1>
            <form action="Register" method="post" onsubmit="return check(this)" >
                <fieldset>
                    <label class="label" for="sid">账号：</label>
                    <input class="input" type="text" id="sid" name="sid" placeholder="输入您的账号"  value=<%if(request.getAttribute("userid")!=null){out.println("'"+userid+"'"+" readonly='readonly'"); }else{out.println("");}%> >
                    <label class="label" for="name">姓名：</label>
                    <input class="input" type="text" id="name" name="name" placeholder="输入您的姓名" value="<%=name%>" />
                    <label class="label">性别：</label>
                    <input type="radio" id="1"  name="sex" value="男" <%if(sex.equals("男")){%> <%="checked" %>  <%} %>/><label  for="1">&nbsp;男</label>
                    <input type="radio" id="0"  name="sex" value="女"<%if(sex.equals("女")){%> <%="checked" %>  <%} %> /><label  for="0">&nbsp;女</label><br>
                    
                    <label class="label" for="password1">密码：</label>
                    <input class="input" type="password" id="password1"  name="password1" placeholder="请输入密码" value="<%=password%>"/>
                    <label class="label" for="password2">确认密码：</label>
                    <input class="input" type="password" id="password2" name="password2" placeholder="请再次输入密码" />

                    <!-- <label class="<label" for="image">验证码:</label>
                     <img class="input" id="captcha_img" name="captcha_img" src="./php/testimage.php" border="1" width="130" height="40" />
                     <a class="a" href="javascript:void(0)" onclick="document.getElementById('captcha_img').src='http://brave-orange.cn/testimage.php?r='+Math.random();">看不清？</a> <br><br>
                     <label class="label" for="captcha">输入验证码：</label>
                           
         <input class="input" type="text" id="captcha" name="captcha" placeholder="输入图片中的字符" />-->
                    <input type="submit" value="注册" " />

                </fieldset>
            </form>
        </div>
    </body>
</html>