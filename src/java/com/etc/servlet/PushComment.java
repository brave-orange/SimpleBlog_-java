/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.servlet;

import com.etc.service.CommentService;
import com.etc.vo.Comment;
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
@WebServlet(name = "PushComment", urlPatterns = {"/PushComment"})
public class PushComment extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=utf-8");
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 
        String id = "",name="",text="";
        id=request.getParameter("id");
        name = request.getParameter("name");
        text = request.getParameter("text");
        if(name.equals("null") || name.equals(""))
        {
            name="匿名评论";
        }
        int cid = 0;
        try {
                 cid = Integer.valueOf(id).intValue();
        } catch (NumberFormatException e) {
                e.printStackTrace();
        }
        CommentService cs = new CommentService();
        Comment comment =new Comment(cid,name,text);
        System.out.println("PushComment.java:"+comment.getId()+comment.getComm_name()+comment.getComm_body());
        try {
            cs.pushComment(comment);
        } catch (SQLException ex) {
            Logger.getLogger(PushComment.class.getName()).log(Level.SEVERE, null, ex);
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
