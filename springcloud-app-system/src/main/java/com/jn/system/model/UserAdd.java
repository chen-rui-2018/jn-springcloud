package com.jn.system.model;

import java.io.Serializable;

/**
 * 新增角色
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
public class UserAdd extends User implements Serializable {

    private String[] roleId;

    public String[] getRoleId() {
        return roleId;
    }

    public void setRoleId(String[] roleId) {
        this.roleId = roleId;
    }
}