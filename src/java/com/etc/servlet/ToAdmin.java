/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.servlet;

import com.etc.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yongcheng
 */
@WebServlet(name = "ToAdmin", urlPatterns = {"/ToAdmin"})
public class ToAdmin extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 
        String id="";
        
        id = request.getParameter("id");
        UserService u = new UserService();
        if(u.IsAdmin(id))
        {
            u.cancelAdmin(id);
            request.getRequestDispatcher("admin/admin.jsp").forward(request, response);          
        }else
        {
            u.toAdmin(id);
            request.getRequestDispatcher("admin/admin.jsp").forward(request, response);      
        }
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
