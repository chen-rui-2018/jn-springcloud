package com.jn.system.vo;

import com.jn.system.model.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于用户组界面获取用户组具有的角色信息及所有角色信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/14 14:07
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysGroupRoleVO", description = "用于用户组界面获取用户组具有的角色信息及所有角色信息")
public class SysGroupRoleVO implements Serializable {
    private static final long serialVersionUID = -5361397168446883005L;
    @ApiModelProperty("用户组具有的角色集合")
    private List<SysRole> roleAllOfGroup;
    @ApiModelProperty("所有角色集合")
    private List<SysRole> sysRoleAll;

    public SysGroupRoleVO() {
    }

    public SysGroupRoleVO(List<SysRole> roleAllOfGroup, List<SysRole> sysRoleAll) {
        this.roleAllOfGroup = roleAllOfGroup;
        this.sysRoleAll = sysRoleAll;
    }

    public List<SysRole> getRoleAllOfGroup() {
        return roleAllOfGroup;
    }

    public void setRoleAllOfGroup(List<SysRole> roleAllOfGroup) {
        this.roleAllOfGroup = roleAllOfGroup;
    }

    public List<SysRole> getSysRoleAll() {
        return sysRoleAll;
    }

    public void setSysRoleAll(List<SysRole> sysRoleAll) {
        this.sysRoleAll = sysRoleAll;
    }

    @Override
    public String toString() {
        return "SysGroupRoleVO{" +
                "roleAllOfGroup=" + roleAllOfGroup +
                ", sysRoleAll=" + sysRoleAll +
                '}';
    }
}

