/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etc.dao;

import com.etc.vo.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yongcheng
 */
public class CommentDAO {

    public List<Comment> selectAll(int id) {
        List<Comment> list = new ArrayList<Comment>();
        PreparedStatement ps;
        Connection conn = JDBCConnectionFactory.getConnection();
        try {
            
            String sql = "select id,comm_name,comm_body from comment where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt(1), rs.getString(2), rs
                        .getString(3)));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public int insert(Comment comment) throws SQLException {
        PreparedStatement ps;
        String sql = "insert into comment values(?,?,?)";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        Connection con = connect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, comment.getId());
        ps.setString(2, comment.getComm_name());
        ps.setString(3, comment.getComm_body());
        num = ps.executeUpdate();
        con.close();
        return num;
    }
}
