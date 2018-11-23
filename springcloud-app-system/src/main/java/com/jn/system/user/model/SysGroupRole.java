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
    private String creator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("状态 1有效 0无效 -1删除")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysGroupRole() {
    }

    public SysGroupRole(String id, String roleId, String userGroupId, String creator, Date createTime, String status) {
        this.id = id;
        this.roleId = roleId;
        this.userGroupId = userGroupId;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysGroupRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userGroupId='" + userGroupId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}