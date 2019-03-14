package com.jn.miniprogram.register.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/13 19:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AcceptOrgInvitation", description = "小程序注册绑定入参")
public class RegisterInfoParam implements Serializable {
    @ApiModelProperty(value = "手机号)")
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phone;
    @ApiModelProperty(value = "验证码)")
    @NotNull(message = "验证码不能为空")
    @Pattern(regexp = "^([0-9]{6})$",
            message = "{code:'验证码只能是6位的数字'}")
    private String code;
    @ApiModelProperty(value = "openId)")
    @NotNull(message = "openId不能为空")
    private String openId;
    @ApiModelProperty(value = "微信号)")
    private String weChatAccount;
    @ApiModelProperty(value = "微信呢称)")
    private String weChatNickName;
    @ApiModelProperty(value = "微信头像)")
    private String weChatAvatar;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getWeChatAccount() {
        return weChatAccount;
    }

    public void setWeChatAccount(String weChatAccount) {
        this.weChatAccount = weChatAccount;
    }

    public String getWeChatNickName() {
        return weChatNickName;
    }

    public void setWeChatNickName(String weChatNickName) {
        this.weChatNickName = weChatNickName;
    }

    public String getWeChatAvatar() {
        return weChatAvatar;
    }

    public void setWeChatAvatar(String weChatAvatar) {
        this.weChatAvatar = weChatAvatar;
    }
}
