package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 根据权限id批量菜单及页面功能
 * @author： shaobao
 * @date： Created on 2018/11/9 22:55
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionMenuRecourcesAdd",description = "根据权限id批量菜单及页面功能")
public class SysPermissionMenuRecourcesAdd implements Serializable {
    private static final long serialVersionUID = -7541006935977245850L;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("菜单id数组")
    private String[] menuIds;
    @ApiModelProperty("页面功能id数组")
    private String[] resourcesIds;

    public SysPermissionMenuRecourcesAdd() {
    }

    public SysPermissionMenuRecourcesAdd(String permissionId, String[] menuIds, String[] resourcesIds) {
        this.permissionId = permissionId;
        this.menuIds = menuIds;
        this.resourcesIds = resourcesIds;
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

    public String[] getResourcesIds() {
        return resourcesIds;
    }

    public void setResourcesIds(String[] resourcesIds) {
        this.resourcesIds = resourcesIds;
    }

    @Override
    public String toString() {
        return "SysPermissionMenuRecourcesAdd{" +
                "permissionId='" + permissionId + '\'' +
                ", menuIds=" + Arrays.toString(menuIds) +
                ", resourcesIds=" + Arrays.toString(resourcesIds) +
                '}';
    }
}
