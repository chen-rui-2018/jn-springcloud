package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限添加
 * @author： shaobao
 * @date： Created on 2018/11/9 9:33
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionAdd",description = "权限添加实体")
public class SysPermissionAdd implements Serializable {

    private static final long serialVersionUID = -438470231901712531L;
    @ApiModelProperty("权限名称")
    private String permissionName;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    private String status;

    public SysPermissionAdd() {
    }

    public SysPermissionAdd(String permissionName, String status) {
        this.permissionName = permissionName;
        this.status = status;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysPermissionAdd{" +
                "permissionName='" + permissionName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
