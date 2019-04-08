package com.jn.enterprise.data.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 15:06
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Reminder", description = "园区提醒人信息")
public class Reminder {
    @ApiModelProperty(value = "部门ID")
    private String departmentId;

    @ApiModelProperty(value = "部门名称")
    private String getDepartmentName;

    @ApiModelProperty(value = "联系人")
    private String linkName;

    @ApiModelProperty(value = "账号")
    private String linkAccount;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getGetDepartmentName() {
        return getDepartmentName;
    }

    public void setGetDepartmentName(String getDepartmentName) {
        this.getDepartmentName = getDepartmentName;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkAccount() {
        return linkAccount;
    }

    public void setLinkAccount(String linkAccount) {
        this.linkAccount = linkAccount;
    }
}
