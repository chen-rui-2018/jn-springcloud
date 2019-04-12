package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/11 11:14
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "UserRoleInfo",description = "用户指定角色的信息")
public class UserRoleInfo implements Serializable {
    @ApiModelProperty(value = "用户账号")
    private String account;
    @ApiModelProperty(value = "用户角色id")
    private String roleId;
    @ApiModelProperty(value = "用户角色名称")
    private String roleName;
    @ApiModelProperty(value = "用户角色所属用户组id")
    private String groupId;
    @ApiModelProperty(value = "用户角色所属用户组名称")
    private String groupName;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
