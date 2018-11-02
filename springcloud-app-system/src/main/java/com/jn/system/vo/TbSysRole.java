package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 */
public class TbSysRole implements Serializable {
    private static final long serialVersionUID = 2885231996482043241L;
    private String id;

    private String roleName; //角色名称

    private String creator;

    private Date createTime; // 创建时间

    private String status; //状态 1:有效 0:无效 -1:删除

    public TbSysRole() {
    }

    public TbSysRole(String id, String roleName, String creator, Date createTime, String status) {
        this.id = id;
        this.roleName = roleName;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TbSysRole)) return false;

        TbSysRole sysRole = (TbSysRole) o;

        if (id != null ? !id.equals(sysRole.id) : sysRole.id != null) return false;
        if (roleName != null ? !roleName.equals(sysRole.roleName) : sysRole.roleName != null) return false;
        if (creator != null ? !creator.equals(sysRole.creator) : sysRole.creator != null) return false;
        if (createTime != null ? !createTime.equals(sysRole.createTime) : sysRole.createTime != null) return false;
        return status != null ? status.equals(sysRole.status) : sysRole.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TbSysRole{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}