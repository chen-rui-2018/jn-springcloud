package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 角色分配权限
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRolePermissionAdd", description = "角色分配权限实体")
public class SysRolePermissionAdd implements Serializable {

    private static final long serialVersionUID = -5110778698071514990L;

    @ApiModelProperty(value = "权限id数组")
    private String[] permissionId;

    @ApiModelProperty(value = "角色id")
    @NotBlank(message = "角色id不能为空")
    private String roleId;

    public SysRolePermissionAdd() {
    }

    public SysRolePermissionAdd(String[] permissionId, String roleId) {
        this.permissionId = permissionId;
        this.roleId = roleId;
    }

    public String[] getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String[] permissionId) {
        this.permissionId = permissionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysRolePermissionAdd{" +
                "permissionId=" + Arrays.toString(permissionId) +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}