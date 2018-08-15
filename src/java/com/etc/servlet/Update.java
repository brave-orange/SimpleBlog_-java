/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.servlet;

import com.etc.service.UserService;
import com.etc.vo.User;
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
@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 
        String userid = "";
        userid = request.getParameter("id");
        UserService u = new UserService();
        User user = u.viewPersonal(userid);
        request.setAttribute("userid", user.getUserid());
        request.setAttribute("name", user.getName());
        request.setAttribute("sex", user.getSex());
        request.setAttribute("admin", user.getAdmin());
        request.setAttribute("password", user.getPassword());
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
