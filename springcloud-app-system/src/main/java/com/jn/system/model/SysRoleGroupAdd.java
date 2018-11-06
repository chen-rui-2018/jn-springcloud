package com.jn.system.model;

import com.jn.system.enums.SysStatusEnums;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 为用户组分配角色实体类
 * @author： shaobao
 * @date： Created on 2018/11/5 21:38
 * @version： v1.0
 * @modified By:
 **/
public class SysRoleGroupAdd implements Serializable {
    private static final long serialVersionUID = -2260462623972187088L;
    /**
     * 角色id数组
     */
    private String[] roleIds;
    /**
     * 用户组id
     */
    private String groupId;
    /**
     * 状态
     */
    private String status= SysStatusEnums.EFFECTIVE.getKey();


    public SysRoleGroupAdd() {
    }

    public SysRoleGroupAdd(String[] roleIds, String groupId, String status) {
        this.roleIds = roleIds;
        this.groupId = groupId;
        this.status = status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysRoleGroupAdd{" +
                "roleIds=" + Arrays.toString(roleIds) +
                ", groupId='" + groupId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
