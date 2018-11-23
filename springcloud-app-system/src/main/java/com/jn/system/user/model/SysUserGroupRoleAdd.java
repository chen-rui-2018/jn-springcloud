package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用户组分配权限
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysUserGroupRoleAdd", description = "用户组分配权限")
public class SysUserGroupRoleAdd implements Serializable {
    private static final long serialVersionUID = -9009880146686290643L;

    @ApiModelProperty(value = "用户组id")
    private String[] userGroupId;

    @ApiModelProperty(value = "角色id")
    @NotBlank(message = "角色id不能为空")
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