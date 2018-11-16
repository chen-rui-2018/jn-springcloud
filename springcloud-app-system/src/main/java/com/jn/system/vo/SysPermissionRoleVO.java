package com.jn.system.vo;

import com.jn.system.model.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 权限界面用于返回权限具有的角色及所有角色
 * @author： shaobao
 * @date： Created on 2018/11/14 19:35
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionRoleVO",description = "权限界面用于返回权限具有的角色及所有角色")
public class SysPermissionRoleVO implements Serializable {
    private static final long serialVersionUID = -4328431622020110494L;
    @ApiModelProperty("权限具有的角色")
    private List<SysRole> roleOfPermissionList;
    @ApiModelProperty("所有角色信息")
    private List<SysRole> sysRoleAll;

    public SysPermissionRoleVO() {
    }

    public SysPermissionRoleVO(List<SysRole> roleOfPermissionList, List<SysRole> sysRoleAll) {
        this.roleOfPermissionList = roleOfPermissionList;
        this.sysRoleAll = sysRoleAll;
    }

    public List<SysRole> getRoleOfPermissionList() {
        return roleOfPermissionList;
    }

    public void setRoleOfPermissionList(List<SysRole> roleOfPermissionList) {
        this.roleOfPermissionList = roleOfPermissionList;
    }

    public List<SysRole> getSysRoleAll() {
        return sysRoleAll;
    }

    public void setSysRoleAll(List<SysRole> sysRoleAll) {
        this.sysRoleAll = sysRoleAll;
    }

    @Override
    public String toString() {
        return "SysPermissionRoleVO{" +
                "roleOfPermissionList=" + roleOfPermissionList +
                ", sysRoleAll=" + sysRoleAll +
                '}';
    }
}
