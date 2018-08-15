<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="com.etc.dao.ArticleDAO"%>
<%@page import="com.etc.dao.UserDAO"%>
<%@page import="com.etc.vo.Article"%>
<%@page import="com.etc.vo.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="head">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link rel="stylesheet" href="css/about.css">
<link rel="stylesheet" href="css/write.css">
<link rel="stylesheet" href="css/list.css">
<link rel="stylesheet" href="css/blog.css">
    <link rel="stylesheet" href="css/movie.css">
<script type="text/javascript" src="./js/blog.js"></script>
<script type="text/javascript" src="./js/list.js"></script>
<script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./js/movie.js"></script>
<script type="text/javascript" src="./js/write.js"></script>

<script type="text/javascript" src="http://ip.chinaz.com/getip.aspx"></script>
</head>

<body>
<div class="main">

<header>
  <div class="quotes">
    <p>我们不停的翻弄着回忆<br>
       却再也找不回那时的自己<br>
       红尘一梦，不再追寻</p>
       <%
                String name="";
                String admin = "";
                name = (String)session.getAttribute("username");
                admin = (String)session.getAttribute("admin");
                out.println(name+admin);
               if(name!=null)
                {
                    if(admin.equals("1"))
                    {
                        out.println("<a class='login' href='admin/admin.jsp'>欢迎您!"+name+"|</a><a class='login1' href='Login.jsp'> 更换用户</a>");
                    }else{
                        out.println("<a class='login' href='#'>欢迎您!"+name+"|</a><a class='login1' href='Login.jsp'> 更换用户</a>");
                    }
                }else
                {
                    out.println("<a class='login' href='Login.jsp'>登陆|注册</a>");
                }
       %>
    <div class="text5">记录·回忆</div>
    <div class="flower"><img src="image/flower.jpg"></div>
  </div>
  <!--nav begin-->
  <div id="nav">
    <ul>
      <li><a href="javascript:void(0);" onclick="GotoIndex()">首页</a></li>
      <li><a href="javascript:void(0);" onclick="GotoMovie()">光影流年</a></li>
      <li><a href="javascript:void(0);" onclick="GotoWrite()">发布文章</a></li>
      <li><a href="javascript:void(0);" onclick="GotoList()">文章列表</a></li>
	  <li><a href="javascript:void(0);" onclick="GotoAbout()">关于我</a></li>
    </ul>
  </div>
  <!--nav end--> 
</header>
    <%
               
        ArticleDAO adao = new ArticleDAO();
        List<Article> article = null;
        String uid = null;
        uid = request.getParameter("viewid");
        if(uid=="all")
        {
              article = adao.selectAll();
        }else
        {
            if(uid==null)
            {
                article = adao.selectAll();
            }else
            {
                article = adao.selectByUserid(uid);
            }
        }
        UserDAO udao = new UserDAO();
        List<User> users = udao.selectAll();
         
    %>
<div   id="main">  <!--网页主题内容（通过AJAX加载）--> 
    <div class = "listwall">
        <div class="tip">
            <select onchange="window.location=this.value">  
                <option value='List.jsp?viewid=all'>浏览全部</option>
                <%
                
                    for (int i = 0; i < users.size(); i++) {
                        User a = users.get(i);
                        out.println("<option value='List.jsp?viewid="+a.getUserid()+"'>"+a.getName()+"</option>");
                    }
                
                 %>
            </select>  
            
        </div>
    <ul> 
            <%
        
        
            for (int i = 0; i < article.size(); i++) {
                Article a = article.get(i);
                String str = "<li id='"
                        +a.getId()+"'value='"+name+"' onclick='show(this.id,this.value)'><div class='img'><img src='"
                        +a.getPicture()+"' /></div><div class='title1'>"
                        +a.getTitle()+"</div><div class='body'>"
                        +a.getBody()+"</div><div class='author1'>"
                        +a.getAuthor()+"</div></li>";
                    
                out.println(str);
            }%>
    </ul>	
</div>
  
</div>

<div class="footer">
<p>@YongCheng-w的个人博客<br>by:brage-orange<br>联系方式:<a href="https://github.com/brave-orange">github</a></p>
</div>
</div>
<div id="mask" class="mask"></div>  
<div id="opendiv" class="opendiv"> 
 <div id="opendiv1">
  </div><br><br><br><br><br><hr>
    <div class="comment" >
            <textarea id="comment"  class="comm_area" placeholder="在此处输入评论"></textarea><br><br>
            <input id='comm_btn'  type="button"  onclick="comment('<%=name%>')"  class="comm_sub"  name="" value="评论"/><br><br><hr>
    </div>
    <h>评论区：</h>                         
    <div id="comm_list" class="comm_list">
  
    </div><br><br><br><br><br><br><br><br>
</div>

<div id="playpage" class="playpage"> 
	<video onclick="pause()" preload="meta" id="player" src="" controls="controls" poster="./image/movpic.jpg" >
	对不起，你的浏览器不支持播放</video>
</div>
<div id="indexdiv" class="opendiv1"> 
</div>
<div id="movbtn" class="closebtn1" onmouseover="style.backgroundImage= 'url(./image/cbtn1.png)';"  
onmouseout= "style.backgroundImage='url(./image/cbtn.png)';" onclick="hidemov()">
</div> 
<div id="indexbtn" class="closebtn2" onmouseover="style.backgroundImage= 'url(./image/cbtn1.png)';"  
onmouseout= "style.backgroundImage='url(./image/cbtn.png)';" onclick="hideindex()">  
</div> 
<div id="openbtn" class="closebtn" onmouseover="style.backgroundImage= 'url(./image/cbtn1.png)';"  
onmouseout= "style.backgroundImage='url(./image/cbtn.png)';" onclick="hide()">  
</div> 
</body>
</html>