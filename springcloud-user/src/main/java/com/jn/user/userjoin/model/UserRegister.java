package com.jn.user.userjoin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @ApiModelProperty(value = "注册手机号",required = true,example = "18177770000")
    @NotNull(message = "手机号不能为空")
    private String phone;
    @ApiModelProperty(value = "短信验证码",required = true,example = "123456")
    @NotNull(message = "验证码不能为空")
    @Pattern(regexp ="[0-9]{6}",message = "验证码只能是6位数字")
    private String messageCode;
    @ApiModelProperty(value = "密码", required = true)
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
