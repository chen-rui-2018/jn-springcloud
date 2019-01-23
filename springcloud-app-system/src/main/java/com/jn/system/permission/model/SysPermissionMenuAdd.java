package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 权限界面添加菜单信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 16:23
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionMenuAdd", description = "权限界面添加菜单信息")
public class SysPermissionMenuAdd implements Serializable {
    private static final long serialVersionUID = 3378361800319026127L;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("菜单id数组")
    private String[] menuIds;

    public SysPermissionMenuAdd() {
    }

    public SysPermissionMenuAdd(String permissionId, String[] menuIds) {
        this.permissionId = permissionId;
        this.menuIds = menuIds;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(String[] menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "SysPermissionMenuAdd{" +
                "permissionId='" + permissionId + '\'' +
                ", menuIds=" + Arrays.toString(menuIds) +
                '}';
    }
}
