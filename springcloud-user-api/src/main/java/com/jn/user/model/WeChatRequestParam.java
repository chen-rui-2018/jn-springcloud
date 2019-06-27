package com.jn.user.model;

import com.jn.user.enums.IsConCornEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/25 10:37
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "WeChatRequestParam",description = "微信授权后系统获得参数")
public class WeChatRequestParam implements Serializable {
    @ApiModelProperty(value = "openId)",required = true)
    @Size(min=28,max=28,message = "请输入正确的28位openId")
    @NotNull(message = "openId不能为空")
    private String openId;
    @ApiModelProperty(value = "unionId)")
    @Size(max=29,message = "请输入正确的29位unionId")
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
    @ApiModelProperty(value = "关注时间（微信服务号关注时间，为时间戳，微信小程序传空，微信服务号必传）)")
    private String subscribeTime;
    @ApiModelProperty(value = "是否关注标志（  CORN('1','关注') ,CANCEL_CORN('0','取消关注')）,微信小程序传空，微信服务号必传)")
    private IsConCornEnum isConcern;

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

    public String getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(String subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public IsConCornEnum getIsConcern() {
        return isConcern;
    }

    public void setIsConcern(IsConCornEnum isConcern) {
        this.isConcern = isConcern;
    }

    @Override
    public String toString() {
        return "WeChatRequestParam{" +
                "openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", language='" + language + '\'' +
                ", subscribeTime='" + subscribeTime + '\'' +
                ", isConcern='" + isConcern + '\'' +
                '}';
    }
}
