package com.jn.user.userjoin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户注册信息
 *
 * @author： lijun
 * @date： Created on 2019/2/28 19:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserRegister",description = "用户注册信息")
public class UserRegister implements Serializable {
    @ApiModelProperty("注册手机号")
    @NotNull(message = "手机号不能为空")
    private String phone;
    @ApiModelProperty("短信验证码")
    @NotNull(message = "验证码不能为空")
    private String messageCode;
    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
