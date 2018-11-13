package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 权限添加角色
 * @author： shaobao
 * @date： Created on 2018/11/9 11:41
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionRolesAdd" ,description = "权限添加角色")
public class SysPermissionRolesAdd implements Serializable {
    private static final long serialVersionUID = -1745882055362489572L;
    @ApiModelProperty("权限ID")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("角色id数组")
    private String[] roleIds;

    public SysPermissionRolesAdd() {
    }

    public SysPermissionRolesAdd(String permissionId, String[] roleIds) {
        this.permissionId = permissionId;
        this.roleIds = roleIds;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "SysPermissionRolesAdd{" +
                "permissionId='" + permissionId + '\'' +
                ", roleIds=" + Arrays.toString(roleIds) +
                '}';
    }
}
