package com.jn.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/16 15:07
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="CareUserDetails",description = "关注详下用户信息")
public class CareUserDetails implements Serializable {

    @ApiModelProperty(value="账号")
    private String  account;
    @ApiModelProperty(value="头像")
    private String  avatar;
    @ApiModelProperty(value="昵称")
    private String  nickName;
    @ApiModelProperty(value="关注数")
    private String  careNum;
    @ApiModelProperty(value="粉丝数")
    private String  fansNum;
    @ApiModelProperty(value="获赞数")
    private String  likedNum;
    @ApiModelProperty(value="关注状态-(0:未关注--1:已关注)")
    private String  careStatus;
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCareNum() {
        return careNum;
    }

    public void setCareNum(String careNum) {
        this.careNum = careNum;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public String getLikedNum() {
        return likedNum;
    }

    public void setLikedNum(String likedNum) {
        this.likedNum = likedNum;
    }

    public String getCareStatus() {
        return careStatus;
    }

    public void setCareStatus(String careStatus) {
        this.careStatus = careStatus;
    }
}
