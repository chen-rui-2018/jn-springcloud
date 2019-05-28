package com.jn.miniprogram.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 微信用户信息绑定并返回token的入参
 *
 * @Author： cm
 * @Date： Created on 2019/5/25 17:39
 * @Version： v1.0
 * @Modified By:
 */
@ApiModel(value = "WxMiniRegisterUserGetTokenParam",description = "绑定微信用户并获取Token参数")
public class WxMiniRegisterUserGetTokenParam implements Serializable {

    private static final long serialVersionUID = -6552120814413831548L;

    @ApiModelProperty(value = "手机号)",required = true)
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phone;
    @ApiModelProperty(value = "验证码)",required = true)
    @NotNull(message = "验证码不能为空")
    @Pattern(regexp = "^([0-9]{6})$",
            message = "{phoneCode:'验证码只能是6位的数字'}")
    private String phoneCode;
    @ApiModelProperty(value = "小程序登陆凭证code",required = true)
    @NotNull(message = "小程序登陆凭证code不能为空")
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }
}
