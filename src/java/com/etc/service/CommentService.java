/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.service;

import com.etc.dao.CommentDAO;
import com.etc.vo.Comment;
import java.sql.SQLException;

/**
 *
 * @author yongcheng
 */
public class CommentService {
    public boolean pushComment(Comment comment) throws SQLException
    {
        CommentDAO commentdao = new CommentDAO();
        if(commentdao.insert(comment)!=0)
        {
            return true;
        }else{
            return false;
        }
    }
    
}
