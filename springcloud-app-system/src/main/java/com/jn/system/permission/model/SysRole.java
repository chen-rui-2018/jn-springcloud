package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRole", description = "角色信息")
public class SysRole implements Serializable {
    private static final long serialVersionUID = -514084002440259994L;

    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名称不能为空！")
    private String roleName;
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
     * 状态 1：有效，0：无效，-1：删除
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysRole() {
    }

    public SysRole(String id, String roleName, String creatorAccount, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysRole)) {
            return false;
        }

        SysRole sysRole = (SysRole) o;

        if (id != null ? !id.equals(sysRole.id) : sysRole.id != null) {
            return false;
        }
        if (roleName != null ? !roleName.equals(sysRole.roleName) : sysRole.roleName != null) {
            return false;
        }
        if (creatorAccount != null ? !creatorAccount.equals(sysRole.creatorAccount) : sysRole.creatorAccount != null) {
            return false;
        }
        if (createdTime != null ? !createdTime.equals(sysRole.createdTime) : sysRole.createdTime != null) {
            return false;
        }
        return recordStatus != null ? recordStatus.equals(sysRole.recordStatus) : sysRole.recordStatus == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (creatorAccount != null ? creatorAccount.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (recordStatus != null ? recordStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
