package com.jn.system.model;

import com.jn.system.enums.SysStatusEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户组分配权限
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRolePermissionAdd", description = "角色分配权限实体")
public class SysUserGroupRoleAdd implements Serializable {
    private static final long serialVersionUID = -9009880146686290643L;

    @ApiModelProperty(value = "用户组id")
    private String[] userGroupId;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    public String[] getUserGroupId() {
        return userGroupId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setUserGroupId(String[] userGroupId) {
        this.userGroupId = userGroupId;
    }
}