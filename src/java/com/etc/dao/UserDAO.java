/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etc.vo.*;

public class UserDAO {

    public List<User> selectAll() {
        List<User> list = new ArrayList<User>();
        Connection conn = JDBCConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select userid,name,sex,password,admin from users";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new User(rs.getString(1), rs.getString(2), rs
                        .getString(3), rs.getString(4), rs.getString(5)));
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

    private User ResultToUser(ResultSet rs)//����ѯ������User����
    {
        User user = new User();
        try {

            user.setUserid(rs.getString("userid"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setAdmin(rs.getString("admin"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    public User selectById(String userid) {
        User user = new User();
        PreparedStatement ps;
        String sql = "select * from users where userid=? ";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        try {
            Connection con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = ResultToUser(rs);
            } else {
                user = null;
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    public User selectByIdPwd(String userid, String password) 
    {
        User user = new User();
        PreparedStatement ps;
        String sql = "select * from users where userid=? and password=?";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        try {
            Connection con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = ResultToUser(rs);
            } else {
                user = null;
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    public int insert(User user) {
        PreparedStatement ps;
        String sql = "insert into users values(?,?,?,?,?)";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        try {
            Connection con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUserid());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getAdmin());
            num = ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return num;
    }

    public int update(User user) {
        PreparedStatement ps;
        String sql = "update users set password=?,name=?,sex=?,admin=? where userid=?";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        try {
            Connection con = connect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(5, user.getUserid());
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getAdmin());
            num = ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return num;
    }


    public int deleteById(String userId) {
        PreparedStatement ps;
        String sql = "delete from users where userid=?";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        try {
            Connection con = connect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, userId);

            num = ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return num;
    }

}
