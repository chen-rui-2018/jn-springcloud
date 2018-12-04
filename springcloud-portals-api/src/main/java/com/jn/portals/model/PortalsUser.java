package com.jn.portals.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @Author: yangph
 * @Date: 2018/11/28 9:40
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "User", description = "用户信息")
public class PortalsUser implements Serializable {
    //todo:数据库表未建，待表建好好再完善
    private static final long serialVersionUID = -7484136779753770396L;
    @ApiModelProperty(value = "用户登录令牌")
    private String shiroSessionId;
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "用户id")
    private String userId;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "邮箱")
    private String email;

    public String getShiroSessionId() {
        return shiroSessionId;
    }

    public void setShiroSessionId(String shiroSessionId) {
        this.shiroSessionId = shiroSessionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
