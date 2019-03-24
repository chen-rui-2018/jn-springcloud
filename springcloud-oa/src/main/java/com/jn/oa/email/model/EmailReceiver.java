package com.jn.oa.email.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 邮件接收人实体类
 *
 * @author： shaobao
 * @date： Created on 2019/3/12 11:18
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "EmailReceiver", description = "邮件接收人实体类")
public class EmailReceiver implements Serializable {
    private static final long serialVersionUID = -4708404167492938555L;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "用户账号")
    private String account;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    public EmailReceiver() {
    }

    public EmailReceiver(String userId, String name, String account, String email) {
        this.userId = userId;
        this.name = name;
        this.account = account;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailReceiver{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
