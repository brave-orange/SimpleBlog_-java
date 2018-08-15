
package com.etc.service;

import com.etc.dao.UserDAO;
import com.etc.vo.User;

/**
 *
 * @author yongcheng
 */
public class UserService {

    public boolean login(String userid, String password) {
        UserDAO userdao = new UserDAO();
        if (userdao.selectByIdPwd(userid, password) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsAdmin(String userid) {
        UserDAO userdao = new UserDAO();
        User user = userdao.selectById(userid);
        if (user.getAdmin().equals("1")) {
            return true;
        } else {
            return false;
        }
    }
    public Boolean toAdmin(String userid)
    {
        UserDAO userdao = new UserDAO();
        User user = userdao.selectById(userid);
        user.setAdmin("1");
        return update(user);      
    }
    public Boolean cancelAdmin(String userid)
    {
        UserDAO userdao = new UserDAO();
        User user = userdao.selectById(userid);
        user.setAdmin("0");
        return update(user);      
    }
    public String register(User user) {
        UserDAO userdao = new UserDAO();
        if (userdao.selectById(user.getUserid()) != null) {
            return "该用户名已存在";
        } else {
            if (userdao.insert(user) != 0) {
                return "ok";
            } else {
                return "注册失败，请重试";
            }
        }
    }
    
    public boolean update(User user) {
        UserDAO userdao = new UserDAO();
        if (userdao.update(user) != 0) {
            return true;
        } else {
            return false;
        }

    }
     public boolean delete(User user) {
        UserDAO userdao = new UserDAO();
        String userid = "";
        userid = user.getUserid();
        if (userdao.deleteById(userid) != 0) {
            return true;
        } else {
            return false;
        }
    }
    public User viewPersonal(String userid) {
        UserDAO userdao = new UserDAO();
        return userdao.selectById(userid);
    }
}
