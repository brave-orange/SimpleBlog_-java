/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.servlet;


import com.etc.service.ArticleService;
import com.etc.service.UserService;
import com.etc.vo.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yongcheng
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");   
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 
        String method = "";
        String id = "";
        method = request.getParameter("name");
        id = request.getParameter("id");
        if(method.equals("article"))
        {
            int aid = Integer.valueOf(id).intValue();
            try {
                
                ArticleService a = new ArticleService();
                a.delete(a.viewArticle(aid));
                request.getRequestDispatcher("admin/admin.jsp").forward(request, response);      
            } catch (SQLException ex) {
                Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(method.equals("users"))
        {
            UserService u = new UserService();   
            u.delete(u.viewPersonal(id));
            request.getRequestDispatcher("admin/admin.jsp").forward(request, response);      
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
