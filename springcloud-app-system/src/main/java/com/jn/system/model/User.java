package com.jn.system.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class User implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -7484136779753770396L;

    private String id;
    @Size(min = 4,max = 10,message = "测试")
    private String username;
    private String password;

    public User(String id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
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