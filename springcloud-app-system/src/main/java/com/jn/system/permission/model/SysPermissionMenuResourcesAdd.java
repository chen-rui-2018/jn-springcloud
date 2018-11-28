package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 权限授权菜单及功能实体
 *
 * @author： shaobao
 * @date： Created on 2018/11/24 20:56
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionMenuResourcesAdd", description = "权限授权菜单及功能实体")
public class SysPermissionMenuResourcesAdd implements Serializable {
    private static final long serialVersionUID = 7185294540530910633L;
    @ApiModelProperty("菜单及权限id数组")
    private String[] menuAndResourcesIds;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;

    public SysPermissionMenuResourcesAdd() {
    }

    public SysPermissionMenuResourcesAdd(String[] menuAndResourcesIds, String permissionId) {
        this.menuAndResourcesIds = menuAndResourcesIds;
        this.permissionId = permissionId;
    }

    public String[] getMenuAndResourcesIds() {
        return menuAndResourcesIds;
    }

    public void setMenuAndResourcesIds(String[] menuAndResourcesIds) {
        this.menuAndResourcesIds = menuAndResourcesIds;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "SysPermissionMenuResourcesAdd{" +
                "menuAndResourcesIds=" + Arrays.toString(menuAndResourcesIds) +
                ", permissionId='" + permissionId + '\'' +
                '}';
    }
}
