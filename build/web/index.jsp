<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="com.etc.dao.ArticleDAO"%>
<%@page import="com.etc.vo.Article"%>
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
<div   id="main">  <!--网页主题内容（通过AJAX加载）--> 
    
    <div class = "blogwall">
	<div class="tip"><img src="./image/tip.png" alt=""></div>
	<ul>
	
	   <li onclick="show1()">
	       <img src="image/t001.jpg" />
	       <figcaption >
              <h2>跨不过去是苟且，跨过去了是远方</h2>
           </figcaption>
	   </li>
	   <li onclick="show2()">
	       <img src="image/t002.jpg" />
	       <figcaption >
              <h2>赵四小姐：世间本无传奇</h2>
           </figcaption>
	   </li>
       <li onclick="show3()">
	       <img src="image/t003.jpg" />
	       <figcaption >
              <h2>对自己狠的人，反而更容易收获善意</h2>
           </figcaption>
	   </li>
       <li onclick="show4()">
	   	   <img src="image/t004.jpg" />
	       <figcaption >
              <h2>青春是一张失效多年的电话卡</h2>
           </figcaption>
	   </li>
	   <li onclick="show5()">
	   <img src="image/t005.jpg" />
	       <figcaption >
              <h2>你想了那么久，为什么还没去做？</h2>
           </figcaption>
	   </li>
	   <li onclick="show6()">
	   <img src="image/t006.jpg" />
	       <figcaption >
              <h2>爱情可能会迟到，但它从不会缺席</h2>
           </figcaption>
	   </li>
	   <li onclick="show7()">
	   <img src="image/t007.jpg" />
	       <figcaption >
              <h2>男女之间的纯友谊，是懂得不越界</h2>
           </figcaption>
	   </li>
	   <li onclick="show8()">
	   <img src="image/t008.jpg" />
	       <figcaption >
              <h2>人年轻时多读一些好书到底有多重要？</h2>
           </figcaption>
	   </li>
	</ul>
</div>
</div>

<div class="footer">
<p>@YongCheng-w的个人博客<br>by:brage-orange<br>联系方式:<a href="https://github.com/brave-orange">github</a></p>
</div>
</div>
<div id="mask" class="mask"></div>  

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

</div> 
</body>
</html>