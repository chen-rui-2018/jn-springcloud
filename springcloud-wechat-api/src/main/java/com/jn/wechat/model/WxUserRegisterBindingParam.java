package com.jn.wechat.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 微信服务号绑定手机号码，注册用户信息入参
 *
 * @Author： cm
 * @Date： Created on 2019/6/25 21:26
 * @Version： v1.0
 * @Modified By:
 */
public class WxUserRegisterBindingParam implements Serializable {
    private static final long serialVersionUID = -8807254787828934379L;

    @ApiModelProperty(value = "用户标识",required = true)
    @NotNull(message="用户标识不能为空")
    private String userFlag;
    @ApiModelProperty(value = "手机号码",required = true)
    @NotNull(message = "验证码不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phoneNo;
    @ApiModelProperty(value = "验证码)",required = true)
    @NotNull(message = "验证码不能为空")
    @Pattern(regexp = "^([0-9]{6})$",
            message = "{phoneCode:'验证码只能是6位的数字'}")
    private String phoneCode;

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Override
    public String toString() {
        return "WxUserRegisterBindingParam{" +
                "userFlag='" + userFlag + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                '}';
    }
}
