package com.jn.system.model;

import com.jn.system.enums.SysStatusEnums;

import java.io.Serializable;

/**
 * 用户组分配权限
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class SysUserGroupRoleAdd implements Serializable {

    private static final long serialVersionUID = -9009880146686290643L;
    private String[] userGroupId;

    private String roleId;

    private String status=SysStatusEnums.EFFECTIVE.getKey();

    public String[] getUserGroupId() {
        return userGroupId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserGroupId(String[] userGroupId) {
        this.userGroupId = userGroupId;
    }
}