package com.jn.authorization.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2018/11/22 10:28
 * @Version v1.0
 * @modified By:
 */
public class PlatformUserLogin implements Serializable {
    private static final long serialVersionUID = -7484136779753770396L;

    @ApiModelProperty(value = "账户名",required = true)
    @Size(min = 4, max = 10, message = "账号TEST")
    private String account;
    @ApiModelProperty(value = "密码",required = true)
    @Size(min = 4, max = 10, message = "密码TEST")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PlatformUserLogin{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
