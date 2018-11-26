package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 权限添加页面功能实体
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 16:31
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionResourceAdd", description = "权限添加页面功能实体")
public class SysPermissionResourceAdd implements Serializable {
    private static final long serialVersionUID = -8384925992839712499L;
    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("页面功能id数组")
    private String[] resourcesIds;

    public SysPermissionResourceAdd() {
    }

    public SysPermissionResourceAdd(String permissionId, String[] resourcesIds) {
        this.permissionId = permissionId;
        this.resourcesIds = resourcesIds;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String[] getResourcesIds() {
        return resourcesIds;
    }

    public void setResourcesIds(String[] resourcesIds) {
        this.resourcesIds = resourcesIds;
    }

    @Override
    public String toString() {
        return "SysPermissionResourceAdd{" +
                "permissionId='" + permissionId + '\'' +
                ", resourcesIds=" + Arrays.toString(resourcesIds) +
                '}';
    }
}
