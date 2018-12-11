package com.jn.portals.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户扩展信息
 *
 * @Author: yangph
 * @Date: 2018/11/28 9:40
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "UserExtension", description = "用户扩展信息")
public class UserExtension implements Serializable {
    @ApiModelProperty(value = "企业用户扩展信息")
    private UserCompany userCompanyInfo;
    @ApiModelProperty(value = "个人用户扩展信息")
    private UserPerson userPersonInfo ;

    private static final long serialVersionUID = 1L;

    public UserCompany getUserCompanyInfo() {
        return userCompanyInfo;
    }

    public void setUserCompanyInfo(UserCompany userCompanyInfo) {
        this.userCompanyInfo = userCompanyInfo;
    }

    public UserPerson getUserPersonInfo() {
        return userPersonInfo;
    }

    public void setUserPersonInfo(UserPerson userPersonInfo) {
        this.userPersonInfo = userPersonInfo;
    }
}
