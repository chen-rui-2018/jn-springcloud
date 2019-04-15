package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/13 15:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="LikedUserInfo",description = "点赞人信息列表")
public class LikedUserInfo implements Serializable {
       @ApiModelProperty(value="账号")
       private  String account;
       @ApiModelProperty(value="昵称")
       private  String nickName;
       @ApiModelProperty(value="头像")
       private  String avatar;
       @ApiModelProperty(value = "个性签名")
       private String signature;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
