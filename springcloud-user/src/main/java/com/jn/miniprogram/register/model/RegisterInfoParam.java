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
    @ApiModelProperty(value = "unionId)")
    @NotNull(message = "unionId不能为空")
    private String unionId;
    @ApiModelProperty(value = "用户呢称)")
    private String nickName;
    @ApiModelProperty(value = "用户头像url)")
    private String avatarUrl;
    @ApiModelProperty(value = "性别)")
    @Pattern(regexp="^[0-2]$",message="{gender:'性别只能是 0(未知)、1(男性)、2（女性）'}")
    private String gender;
    @ApiModelProperty(value = "用户所在国家)")
    private String country;
    @ApiModelProperty(value = "用户所在省份)")
    private String province;
    @ApiModelProperty(value = "用户所在城市)")
    private String city;
    @ApiModelProperty(value = "语言)")
    private String language;

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

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
