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
public class Comment {
    private int id;
    private String comm_name;
    private String comm_body;
    
    public Comment()
    {
        
    }
    
    public Comment(int id,String comm_name,String comm_body)
    {
        super();
        this.comm_body = comm_body;
        this.comm_name = comm_name;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComm_name() {
        return comm_name;
    }

    public void setComm_name(String comm_name) {
        this.comm_name = comm_name;
    }

    public String getComm_body() {
        return comm_body;
    }

    public void setComm_body(String comm_body) {
        this.comm_body = comm_body;
    }

}
