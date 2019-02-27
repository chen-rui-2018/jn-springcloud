package com.jn.system.permission.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 9:24
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermission", description = "权限")
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 3723725627921993118L;
    @ApiModelProperty("权限id")
    private String id;
    @ApiModelProperty("权限名称")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "权限名称校验失败")
    private String permissionName;
    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysPermission() {
    }

    public SysPermission(String id, String permissionName, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.permissionName = permissionName;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
