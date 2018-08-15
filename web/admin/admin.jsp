<%-- 
    Document   : admin
    Created on : 2017-6-5, 22:20:18
    Author     : yongcheng
--%>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.etc.dao.UserDAO"%>
<%@page import="com.etc.vo.User"%>
<%@page import="com.etc.dao.ArticleDAO"%>
<%@page import="com.etc.vo.Article"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>博客后台管理</title>
        <style>
            .right1{
                margin:auto;
                width:60%;
                height:auto;

                margin-top:20px;
                border:double 4px;
                -moz-box-shadow:8px 8px 14px #333333; -webkit-box-shadow:8px 8px 14px #333333; box-shadow:8px 8px 14px #333333;
            }
            .t1{
                font-size:25px;
                font-family:黑体;
                margin-left:20%;
            }
            .footer{
                font-size:20px;
                font-family:黑体;
                position:absolute;
                left:75%;top:20px;

            }
        </style>
    </head>


    <body style="height: 100%;">
        
            <p class="t1">博客文章管理</p>
            <%
                ArticleDAO adao = new ArticleDAO();
                List<Article> article = adao.selectAll();
            %>
            <div class="right1">
            <table width="100%"border='3px'>
                <tr>
                    <td nowrap align="left" style="word-wrap:break-word;">ID</td>
                    <td nowrap align="left" style="word-wrap:break-word;">文章标题</td>
                    <td nowrap align="left" style="word-wrap:break-word;">作者|发表时间</td>
                    <td nowrap align="left" style="word-wrap:break-word;">功能</td>
                </tr>
                <%for (int i = 0; i < article.size(); i++) {
                        Article a = article.get(i);

                        out.println("<tr><td nowrap align='left' style='word-wrap:break-word;'>" + a.getId() + "</td>");
                        out.println("<td nowrap align='left' style='word-wrap:break-word;'>" + a.getTitle() + "</td>");
                        out.println("<td nowrap align='left' style='word-wrap:break-word;'>" + a.getAuthor() + "</td>");
                        out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='/SimpleBlog/Delete?name=article&id="+a.getId()+"'>删除</a></td>");
                        out.println("</tr>");
                    }%>
            </table>
        </div>

        <p class="t1">博客用户管理</p>
        <div class="right1">
            <%UserDAO u = new UserDAO();
                List<User> user = u.selectAll();
            %>
            <table width="100%"border='3px'>
                <tr>
                    <td nowrap align="left" style="word-wrap:break-word;">账号</td>
                    <td nowrap align="left" style="word-wrap:break-word;">名称</td>
                    <td nowrap align="left" style="word-wrap:break-word;">性别</td>              
                    <td nowrap align="left" style="word-wrap:break-word;">是否管理员</td>
                    <td nowrap align="left" style="word-wrap:break-word;" colspan="3">功能</td>

                </tr>
                <%
                    for (int i = 0; i < user.size(); i++) {
                        User a = user.get(i);
                    
                        out.println("<tr><td nowrap align='left' style='word-wrap:break-word;'>"+a.getUserid()+"</td>");
                        out.println("<td nowrap align='left' style='word-wrap:break-word;'>"+a.getName() + "</td>");
                        out.println("<td nowrap align='left' style='word-wrap:break-word;'>"+a.getSex()+ "</td>");
                        out.println("<td nowrap align='left' style='word-wrap:break-word;'>"+a.getAdmin()+ "</td>");
                        if(a.getUserid().equals("123"))
                        {
                             out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='#'></a></td>");
                             out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='/SimpleBlog/Update?id="+a.getUserid() +"'>修改</a></td>");
                             out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='#'></a></td>");
                        }else
                        {
                            out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='/SimpleBlog/Delete?name=users&id="+a.getUserid()+"'>删除</a></td>");
                            out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='/SimpleBlog/Update?id="+a.getUserid()+"'>修改</a></td>");
                       
                            if(a.getAdmin().equals("0"))
                            {
                                out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='/SimpleBlog/ToAdmin?id="+a.getUserid()+"'>设为管理员</a></td>");
                            }
                            else
                            {
                                out.println("<td nowrap align='left' style='word-wrap:break-word;'><a href='/SimpleBlog/ToAdmin?id="+a.getUserid()+"'>取消管理员</a></td>");
                            }
                        }
                        out.println("</tr>"); 
                    }%>
            </table>
        </div>
            <p class="footer"><a href="/SimpleBlog/index.jsp" >前往博客-></a></p>
    </body>         
</html>
