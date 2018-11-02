package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色关联实体
 */
public class TbSysUserRole implements Serializable {
    private static final long serialVersionUID = -6016435320433311326L;
    private String id;

    private String roleId; //角色id

    private String userId; //用户id

    private String creator; //创造者

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysUserRole() {
    }

    public TbSysUserRole(String id, String roleId, String userId, String creator, Date createTime, String status) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "TbSysUserRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userId='" + userId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}