package com.jn.system.model;

import com.jn.system.enums.SysStatusEnums;

import java.io.Serializable;

/**
 * 角色分配权限
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class SysRolePermissionAdd implements Serializable {

    private static final long serialVersionUID = -5110778698071514990L;

    private String[] permissionId;

    private String roleId;

    private String status=SysStatusEnums.EFFECTIVE.getKey();

    public String[] getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String[] permissionId) {
        this.permissionId = permissionId;
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
}