package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户组角色关系
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 15:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRolePermissionAdd", description = "角色分配权限实体")
public class SysUserGroupRole implements Serializable {
    private static final long serialVersionUID = 4289655721908438550L;

    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id" )
    private String roleId;
    /**
     * 用户组id
     */
    @ApiModelProperty(value = "用户组id" )
    private String userGroupId;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creatorAccount;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    @Pattern(regexp="^[012]$",message="{status:'状态值只允许为0,1,2'}")
    private Byte recordStatus;

    public SysUserGroupRole() {
    }

    public SysUserGroupRole(String id, String roleId, String userGroupId, String creatorAccount,
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
        return "SysUserGroupRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userGroupId='" + userGroupId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
