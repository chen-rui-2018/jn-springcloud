package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色关系
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 15:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysUserRole", description = "用户角色关系实体")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 6938418955984330913L;

    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private String roleId;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;
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
    private Byte recordStatus;

    public SysUserRole() {
    }

    public SysUserRole(String id, String roleId, String userId, String userName, String creatorAccount,
                       Date createdTime, Byte recordStatus) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
        this.userName = userName;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "SysUserRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
