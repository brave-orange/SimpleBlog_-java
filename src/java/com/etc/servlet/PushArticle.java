/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.servlet;

import com.etc.dao.ArticleDAO;
import com.etc.service.ArticleService;
import com.etc.vo.Article;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yongcheng
 */



@WebServlet(name = "PushArticle", urlPatterns = {"/PushArticle"})
public class PushArticle extends HttpServlet {


    ServletConfig servletconfig;
            
        String title = "";
        String body = "";
    public PushArticle()
    {
        super();
    }
    
    public void init(ServletConfig config)throws ServletException{
        this.servletconfig = config;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         title = request.getParameter("title");
        body = request.getParameter("body");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=utf-8");
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 

        title = request.getParameter("title");
        body = request.getParameter("body");
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(now);
        HttpSession session=request.getSession();
        String name = "",userid = "";
        name = (String)session.getAttribute("username");
        userid = (String)session.getAttribute("id");
        if(name==null)
        {
            name="匿名用户";
            userid=" ";
        }
        String author = name+"|"+time;
        Article article = new Article();
        article.setAuthor(author);
        article.setTitle(title);
        article.setBody(body);
        article.setUserid(userid);
       
        SmartUpload su = new SmartUpload();   
        su.initialize(servletconfig,request,response);
        try {
            su.upload();
        } catch (SmartUploadException ex) {
            Logger.getLogger(PushArticle.class.getName()).log(Level.SEVERE, null, ex);
        }//设置接受文件参数
        
         ArticleService a = new ArticleService();
         ArticleDAO adao =new ArticleDAO();
        try {
         
            Article art = a.viewArticle(a.pushArticle(article));
            String picpath =art.getPicture();//获取图片存放路径
          String rootpath = request.getSession().getServletContext().getRealPath("");
            
            Files fs = su.getFiles();
            File f = fs.getFile(0);
            if(f.getSize()!=0l)
            {

                f.saveAs(picpath,File.SAVEAS_VIRTUAL);
            }
            else
            {           
                adao.UpdateArticlePicpath(art.getId(),"./image/t.jpg");      
            }
            adao.CreateArticleFiles(a.viewArticle(art.getId()),rootpath);
        } catch (SQLException ex) {
            Logger.getLogger(PushArticle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SmartUploadException ex) {
            Logger.getLogger(PushArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
        
        
    }

    
 
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
