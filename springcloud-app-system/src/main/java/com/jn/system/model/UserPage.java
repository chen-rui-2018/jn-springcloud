package com.jn.system.model;

import com.jn.common.model.Page;

import java.io.Serializable;

/**
 * 用户分页
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class UserPage extends Page implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -7484136779753770396L;
    private String id;
    private String username;
    private String password;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }


}