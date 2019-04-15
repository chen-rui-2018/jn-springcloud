package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/10 16:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="UserInfoQueryParam",description="通过条件返回对应的用户信息")
public class UserInfoQueryParam implements Serializable {
    @ApiModelProperty(value = "用户昵称",example = "喜洋洋")
    private String nickName;
    @ApiModelProperty(value = "用户电话",example = "188980666666")
    private String phone;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
