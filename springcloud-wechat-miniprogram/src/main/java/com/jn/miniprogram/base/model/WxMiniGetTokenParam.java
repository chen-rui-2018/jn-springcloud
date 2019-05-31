package com.jn.miniprogram.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 获取Token所需的参数
 *
 * @Author： cm
 * @Date： Created on 2019/5/25 16:07
 * @Version： v1.0
 * @Modified By:
 */
@ApiModel(value = "WxMiniGetTokenParam",description = "保存微信用户信息并获取Token参数")
public class WxMiniGetTokenParam implements Serializable {
    private static final long serialVersionUID = 3644266231495911516L;
    @ApiModelProperty(value = "小程序登陆凭证code",required = true)
    @NotNull(message="小程序登陆凭证code不能为空")
    private String code;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "所在地市语言")
    private String language;
    @ApiModelProperty(value = "用户所在地市")
    private String city;
    @ApiModelProperty(value = "用户所在省")
    private String province;
    @ApiModelProperty(value = "用户所在国家")
    private String country;
    @ApiModelProperty(value = "用户头像图片的URL")
    private String avatarUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "WxMiniGetTokenParam{" +
                "code='" + code + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
