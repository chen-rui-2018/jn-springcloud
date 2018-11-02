package com.jn.system.vo;

import java.util.Date;

/**
 * 用户组角色关联表
 */
public class TbSysGroupRole {
    private String id;

    private String roleId; //角色id

    private String userGroupId; // 用户组id

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysGroupRole() {
    }

    public TbSysGroupRole(String id, String roleId, String userGroupId, Date createTime, String status) {
        this.id = id;
        this.roleId = roleId;
        this.userGroupId = userGroupId;
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

    @Override
    public String toString() {
        return "TbSysGroupRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userGroupId='" + userGroupId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}