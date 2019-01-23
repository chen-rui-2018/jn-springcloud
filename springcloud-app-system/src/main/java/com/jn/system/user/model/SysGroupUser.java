package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 *用户组用户实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupUser",description = "用户组用户实体")
public class SysGroupUser implements Serializable {

    private static final long serialVersionUID = -3719419034027851775L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户组id")
    private String groupId;

    @ApiModelProperty("创建人")
    private String creatorAccount;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("创建时间")
    private Date createdTime;

    @ApiModelProperty("状态")
    private Byte recordStatus;

    public SysGroupUser() {
    }

    public SysGroupUser(String id, String groupId, String creatorAccount, String userId, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.groupId = groupId;
        this.creatorAccount = creatorAccount;
        this.userId = userId;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "SysGroupUser{" +
                "id='" + id + '\'' +
                ", groupId='" + groupId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", userId='" + userId + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}