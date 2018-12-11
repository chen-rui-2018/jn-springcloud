package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 * @author： shaobao
 * @date： Created on 2018/11/9 9:24
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermission",description = "权限")
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 3723725627921993118L;
    @ApiModelProperty("权限id")
    private String id;
    @ApiModelProperty("权限名称")
    @Size(max = 20,message = "权限名称字数不能超过20个字")
    private String permissionName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysPermission() {
    }

    public SysPermission(String id, String permissionName, Date createTime, String status) {
        this.id = id;
        this.permissionName = permissionName;
        this.createTime = createTime;
        this.status = status;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
