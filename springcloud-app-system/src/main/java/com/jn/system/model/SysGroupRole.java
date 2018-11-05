package com.jn.system.model;

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
public class SysGroupRole implements Serializable {
    private static final long serialVersionUID = 2429600148501298066L;
    /**
     * id
     */
    private String id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 用户组id
     */
    private String userGroupId;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1 删除
     */
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