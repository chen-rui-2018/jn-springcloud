package com.jn.system.permission.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 权限界面用于条件分页获取功能信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 15:57
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionResourcePage",description = "权限界面用于条件分页获取功能信息")
public class SysPermissionResourcePage extends Page implements Serializable {
    private static final long serialVersionUID = -4828984611676294996L;

    @ApiModelProperty("权限id")
    @NotBlank(message = "权限id不能为空")
    private String permissionId;
    @ApiModelProperty("页面功能名称")
    private String resourceName;

    public SysPermissionResourcePage() {
    }

    public SysPermissionResourcePage(String permissionId, String resourceName) {
        this.permissionId = permissionId;
        this.resourceName = resourceName;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "SysPermissionResourcePage{" +
                "permissionId='" + permissionId + '\'' +
                ", resourceName='" + resourceName + '\'' +
                '}';
    }
}
