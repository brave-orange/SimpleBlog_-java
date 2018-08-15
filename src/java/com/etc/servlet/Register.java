/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.servlet;

import com.etc.dao.UserDAO;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 
        String userid = "";
        String name = "";
        String sex = "";
        String password = "";
        String admin = "";
        userid = request.getParameter("sid");
        name =  request.getParameter("name");
        sex = request.getParameter("sex");
        password = request.getParameter("password2");
        if(userid.equals("123"))
        {
            System.out.println(userid);
            admin = "1";
        }else
        {
            admin = "0";
        }

        
        User user = new User(userid,name,sex,password,admin);
        UserService u = new UserService();
        if(u.viewPersonal(userid)!=null)
        {
            if(u.update(user))
            {
                response.sendRedirect("UpdateSuccess.jsp");
            }
            else
            {
                 response.sendRedirect("UpdateFail.jsp");
            }
            
        }
        else
        {
            String rs = u.register(user);
            if(rs.equals("ok"))
            {
                response.sendRedirect("success.jsp");
            }
            else
            {
                response.sendRedirect("fail.jsp?text="+rs);
            }
        }
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
