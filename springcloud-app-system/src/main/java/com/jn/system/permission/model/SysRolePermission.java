package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限关系
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 15:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRolePermission", description = "角色权限关系实体")
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 5559883275762448025L;

    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private String roleId;
    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private String permissionId;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String permissionName;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    /**
     * 状态，0删除，1有效，2无效
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysRolePermission() {
    }

    public SysRolePermission(String id, String roleId, String permissionId, String permissionName,
                             String creatorAccount, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
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
        return "SysRolePermission{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
