package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 权限添加
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 9:33
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionAdd", description = "权限添加实体")
public class SysPermissionAdd implements Serializable {

    private static final long serialVersionUID = -438470231901712531L;
    @ApiModelProperty("权限名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "权限名称校验失败")
    private String permissionName;
    @ApiModelProperty("状态，0删除，1有效，2无效")
    @NotNull(message = "状态值不能为空")
    private Byte recordStatus;

    public SysPermissionAdd() {
    }

    public SysPermissionAdd(String permissionName, Byte recordStatus) {
        this.permissionName = permissionName;
        this.recordStatus = recordStatus;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysPermissionAdd{" +
                "permissionName='" + permissionName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
