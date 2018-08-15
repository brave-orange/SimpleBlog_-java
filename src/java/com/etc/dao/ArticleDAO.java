/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etc.dao;

import com.etc.vo.Article;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yongcheng
 */
public class ArticleDAO {

    public List<Article> selectAll() {
        List<Article> list = new ArrayList<Article>();
        Connection conn = JDBCConnectionFactory.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select id,title,author,body,picture,userid from article order by id desc";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Article(rs.getInt(1), rs.getString(2), rs
                        .getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
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

    public Article selectById(int id) throws SQLException
    {
        PreparedStatement ps;
        String sql = "select * from article where id = ?";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        Connection con = connect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
        }else
        {
            return null;
        }
        
    }
    public List<Article> selectByUserid(String userid) throws SQLException
    {
        PreparedStatement ps;
        String sql = "select * from article where userid = ? order by id desc";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        Connection con = connect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, userid);
        ResultSet rs = ps.executeQuery();
        List<Article> list = new ArrayList<Article>();
        while (rs.next()) {
            list.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));

        }   
        return list;
    }
    
    public int selectIdByname(String name) throws SQLException {
        int id = 0;
        PreparedStatement ps;
        String sql = "select id from article where author = ?";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        Connection con = connect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        con.close();
        return id;
    }

    public int deleteById(int id) {
        PreparedStatement ps;
        String sql = "delete from article where id=?";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        int num = 0;
        try {
            Connection con = connect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            num = ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return num;
    }

    /**
     * @param article
     * @return成功返回插入的记录条数否则返回0
     * @throws SQLException
     */
    public int insert(Article article) throws SQLException {
        int num = 0;
        PreparedStatement ps;
        String sql = "insert into article(title,author,body,userid) values(?,?,?,?)";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        Connection con = connect.getConnection();
        ps = con.prepareStatement(sql);   
        ps.setString(1, article.getTitle());
        ps.setString(2, article.getAuthor());
        ps.setString(3, article.getBody());
        ps.setString(4, article.getUserid());
        num = ps.executeUpdate();
        con.close();

        return num;
    }

    /**
     * @将文章对象转换为TXT文件方便AJAX动态加载 @return
     */
    public void CreateArticleFiles(Article article,String rootpath) {
        OutputStream os = null;
        try {

            String xml = "<div class='picture'>"
                    + "<img src='" + article.getPicture() + "' />"
                    + "</div>"
                    + "<div class='title'>" + article.getTitle()
                    + "</div>"
                    + "<div class='author'>\n"
                    + article.getAuthor() + "\n"
                    + "</div>\n"
                    + "<div class='article'>\n"
                    + article.getBody() + "\n"
                    + "</div>";
            String path = rootpath+"/article/" + article.getId() + ".txt";
            System.out.println(xml);
            System.out.println("ArticleDAO.java:"+path);
            File f = new File(path);
            f.createNewFile();
            byte[] bytexml = xml.getBytes("utf-8");
            os = new FileOutputStream(f);
            os.write(bytexml);
            os.flush();
            os.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public int UpdateArticlePicpath(int id, String picpath) throws SQLException {
        int num = 0;
        PreparedStatement ps;
        String sql = "update article set picture=? where id=?";
        JDBCConnectionFactory connect = new JDBCConnectionFactory();
        Connection con = connect.getConnection();
        ps = con.prepareStatement(sql);
        
        ps.setString(1, picpath);
        ps.setInt(2, id);
        ps.executeUpdate();
        con.close();
        return num;
    }
}
