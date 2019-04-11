package com.jn.user.point.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户积分明细入参
 * @author： jiangyl
 * @date： Created on 2019/4/3 19:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserPointDetailParam",description = "用户积分明细入参")
public class UserPointDetailParam extends Page implements Serializable {
    @ApiModelProperty(value = "用户账号",required = true,example = "wangsong")
    private String userAccount;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "UserPointDetailParam{" +
                "userAccount='" + userAccount + '\'' +
                '}';
    }
}