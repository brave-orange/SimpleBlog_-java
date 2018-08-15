/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etc.vo;

/**
 *
 * @author yongcheng
 */
public class User {
    private String userid;
    private String name;
    private String sex;
    private String password;
    private String admin;
   
    
    public User() {
     
    }
    
    public User(String userid,String name,String sex,String password,String admin)
    {
        super();
        this.admin=admin;
        this.name=name;
        this.password=password;
        this.sex=sex;
        this.userid=userid;

    }

 
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    
}
