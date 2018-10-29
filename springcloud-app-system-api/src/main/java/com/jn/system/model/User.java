package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 用户信息
 */
@ApiModel(value = "User" ,description = "用户信息")
public class User implements Serializable{

	private static final long serialVersionUID = -7484136779753770396L;
    @ApiModelProperty(value = "id")
	private String id;
    @ApiModelProperty("账户名")
    @Size(min = 4,max = 10,message = "账号TEST")
    private String username;
    @ApiModelProperty("密码")
    @Size(min = 4,max = 10,message = "密码TEST")
    private String password;

	public User(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public User(){
		
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