package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户组角色实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupRole",description = "用户组角色实体")
public class SysGroupRole implements Serializable {
    private static final long serialVersionUID = 2429600148501298066L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("用户组id")
    private String userGroupId;

    @ApiModelProperty("创建人")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    private Date createdTime;

    @ApiModelProperty("状态")
    private Byte recordStatus;

    public SysGroupRole() {
    }

    public SysGroupRole(String id, String roleId, String userGroupId, String creatorAccount,
                        Date createdTime, Byte recordStatus) {
        this.id = id;
        this.roleId = roleId;
        this.userGroupId = userGroupId;
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

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
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
        return "SysGroupRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userGroupId='" + userGroupId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}