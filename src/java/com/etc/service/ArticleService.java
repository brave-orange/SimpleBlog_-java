/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etc.service;

import com.etc.dao.ArticleDAO;
import com.etc.vo.Article;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.Format;

/**
 *
 * @author yongcheng
 */
public class ArticleService {

    public int pushArticle(Article article) throws SQLException {
        ArticleDAO ado = new ArticleDAO();
        int num = ado.insert(article);
        int id = ado.selectIdByname(article.getAuthor());
        
        Format f1 = new DecimalFormat("0000");
        String picpath = "./image/t" + f1.format(id) + ".jpg";
        
        int num1 = ado.UpdateArticlePicpath(id, picpath);
       
        //ado.CreateArticleFiles(viewArticle(id));
        if (num != 0) {
            return id;
        } else {
            return 0;
        }
    }
    
    public boolean delete(Article article)
    {
        ArticleDAO userdao = new ArticleDAO();
        if(userdao.deleteById(article.getId())!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    public Article viewArticle(int id) throws SQLException {
        ArticleDAO adao = new ArticleDAO();
        return adao.selectById(id);
    }
}
