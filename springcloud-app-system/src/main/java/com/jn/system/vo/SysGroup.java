package com.jn.system.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO:用户组实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysGroup implements Serializable {

    private static final long serialVersionUID = 2758645323376032467L;
    /**
     * 组id
     */
    private String id;
    /**
     * 组名称
     */
    private String groupName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    private String status;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 关联角色
     */
    private List<SysRole> sysRoles;
    /**
     * 用户组中用户
     */
    private List<SysUser> sysUsers = new ArrayList<SysUser>();

    public SysGroup() {
    }

    public SysGroup(String id, String groupName, Date createTime, String status, String creator,
                    List<SysRole> sysRoles, List<SysUser> sysUsers) {
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

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public List<SysUser> getSysUsers() {
        return sysUsers;
    }

    public void setSysUsers(List<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SysGroup)){
            return false;
        }

        SysGroup sysGroup = (SysGroup) o;

        if (id != null ? !id.equals(sysGroup.id) : sysGroup.id != null){
            return false;
        }
        if (groupName != null ? !groupName.equals(sysGroup.groupName) : sysGroup.groupName != null){
            return false;
        }
        if (createTime != null ? !createTime.equals(sysGroup.createTime) : sysGroup.createTime != null){
            return false;
        }
        if (status != null ? !status.equals(sysGroup.status) : sysGroup.status != null){
            return false;
        }
        if (creator != null ? !creator.equals(sysGroup.creator) : sysGroup.creator != null) {
            return false;
        }
        if (sysRoles != null ? !sysRoles.equals(sysGroup.sysRoles) : sysGroup.sysRoles != null){
            return false;
        }
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
        return "SysGroup{" +
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