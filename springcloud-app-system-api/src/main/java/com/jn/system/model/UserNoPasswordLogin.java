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
@ApiModel(value = "UserNoPasswordLogin" ,description = "用户信息")
public class UserNoPasswordLogin implements Serializable {

    private static final long serialVersionUID = -7484136779753770396L;

    @ApiModelProperty(value = "账户名",required = true)
    @Size(min = 1, max = 16, message = "账号不正确")
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    @Override
    public String toString() {
        return "UserNoPasswordLogin{" +
                "account='" + account + '\'' +
                '}';
    }
}
