package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 登陆DEMO
 *
 * @author： fengxh
 * @date： Created on 2018/11/5 19:34
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserLogin" ,description = "用户信息")
public class UserLogin implements Serializable {

    private static final long serialVersionUID = -7484136779753770396L;

    @ApiModelProperty(value = "账户名",required = true,example = "wangsong")
    @Size(min = 6, max = 16, message = "账号不正确")
    private String account;
    @ApiModelProperty(value = "密码",required = true,example = "wangsong")
    @Size(min = 6, max = 16, message = "密码不正确")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
