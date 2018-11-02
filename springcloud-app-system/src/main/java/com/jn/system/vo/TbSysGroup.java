package com.jn.system.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 用户组表
 */
public class TbSysGroup implements Serializable {

    private static final long serialVersionUID = 2758645323376032467L;
    private String id; //组id

    private String groupName; // 组名称

    private Date createTime; // 创建时间

    private String status; //状态 1:有效 0:无效 -1:删除

    private String creator; //创建人

    private List<TbSysRole> sysRoles; //关联角色

    private List<TbSysUser> sysUsers = new ArrayList<TbSysUser>(); //用户组中用户

    public TbSysGroup() {
    }

    public TbSysGroup(String id, String groupName, Date createTime, String status, String creator,
                      List<TbSysRole> sysRoles, List<TbSysUser> sysUsers) {
        this.id = id;
        this.groupName = groupName;
        this.createTime = createTime;
        this.status = status;
        this.creator = creator;
        this.sysRoles = sysRoles;
        this.sysUsers = sysUsers;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public List<TbSysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<TbSysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public List<TbSysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<TbSysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TbSysGroup)) return false;

        TbSysGroup sysGroup = (TbSysGroup) o;

        if (id != null ? !id.equals(sysGroup.id) : sysGroup.id != null) return false;
        if (groupName != null ? !groupName.equals(sysGroup.groupName) : sysGroup.groupName != null) return false;
        if (createTime != null ? !createTime.equals(sysGroup.createTime) : sysGroup.createTime != null) return false;
        if (status != null ? !status.equals(sysGroup.status) : sysGroup.status != null) return false;
        if (creator != null ? !creator.equals(sysGroup.creator) : sysGroup.creator != null) return false;
        if (sysRoles != null ? !sysRoles.equals(sysGroup.sysRoles) : sysGroup.sysRoles != null) return false;
        return sysUsers != null ? sysUsers.equals(sysGroup.sysUsers) : sysGroup.sysUsers == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        result = 31 * result + (sysRoles != null ? sysRoles.hashCode() : 0);
        result = 31 * result + (sysUsers != null ? sysUsers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TbSysGroup{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", creator='" + creator + '\'' +
                ", sysRoles=" + sysRoles +
                ", sysUsers=" + sysUsers +
                '}';
    }
}