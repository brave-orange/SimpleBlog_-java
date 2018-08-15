/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.servlet;

import com.etc.dao.CommentDAO;
import com.etc.vo.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yongcheng
 */
@WebServlet(name = "LoadComment", urlPatterns = {"/LoadComment"})
public class LoadComment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=utf-8");
          response.setCharacterEncoding("UTF-8"); 
           request.setCharacterEncoding("UTF-8"); 
           String id = "";
           id = request.getParameter("id");
           int cid = 0;
           try {
                 cid = Integer.valueOf(id).intValue();
            } catch (NumberFormatException e) {
                    e.printStackTrace();
            }
           CommentDAO c = new CommentDAO();
           List<Comment> list = c.selectAll(cid);
           String json_str="[";
           for (int i = 0; i < list.size(); i++) {
               Comment a = list.get(i);
              
               if(i==(list.size()-1))
               {
                   json_str = json_str +"{\"name\":\""+a.getComm_name() +"\",\"body\":\""+a.getComm_body()+"\"}]"; 
               }   else{
                    json_str = json_str +"{\"name\":\""+a.getComm_name() +"\",\"body\":\""+a.getComm_body()+"\"},"; 
               }  
           }  
           System.out.println("LoadComment.java:"+json_str);
           PrintWriter out = response.getWriter(); 
               out.write(json_str); 
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
