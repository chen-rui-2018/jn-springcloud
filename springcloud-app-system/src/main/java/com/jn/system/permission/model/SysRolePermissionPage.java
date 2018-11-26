package com.jn.system.permission.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用于角色界面条件分页查询角色未拥有权限信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/16 15:50
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRolePermissionPage", description = "用于角色界面条件分页查询角色未拥有权限信息")
public class SysRolePermissionPage extends Page implements Serializable {
    private static final long serialVersionUID = 3026445168839392351L;
    @ApiModelProperty("角色id")
    @NotBlank(message = "角色id不能为空")
    private String roleId;
    @ApiModelProperty("用户名称,用于名称查询")
    private String permissionName;

    public SysRolePermissionPage() {
    }

    public SysRolePermissionPage(String roleId, String permissionName) {
        this.roleId = roleId;
        this.permissionName = permissionName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "SysRolePermissionPage{" +
                "roleId='" + roleId + '\'' +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
