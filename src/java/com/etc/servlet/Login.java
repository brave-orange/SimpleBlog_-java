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
import javax.servlet.http.HttpSession;

/**
 *
 * @author yongcheng
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    

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
        String name = "";
        String password = "";
        name = request.getParameter("username");
        password = request.getParameter("password");
        UserService u = new UserService();
        if(u.login(name, password))
        {
            User user = u.viewPersonal(name);
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getUserid());
            session.setAttribute("admin", user.getAdmin());
            session.setAttribute("username", user.getName());
            if(u.IsAdmin(name))
            {
                request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else
        {
            request.getRequestDispatcher("loginfail.jsp").forward(request, response);
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
