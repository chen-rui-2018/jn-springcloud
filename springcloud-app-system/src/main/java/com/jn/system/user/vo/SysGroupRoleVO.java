package com.jn.system.user.vo;

import com.jn.system.permission.model.SysRole;
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
    private List<SysRole> roleOfGroupList;
    @ApiModelProperty("所有角色集合")
    private List<SysRole> otherRoleList;

    public SysGroupRoleVO() {
    }

    public SysGroupRoleVO(List<SysRole> roleOfGroupList, List<SysRole> otherRoleList) {
        this.roleOfGroupList = roleOfGroupList;
        this.otherRoleList = otherRoleList;
    }

    public List<SysRole> getRoleOfGroupList() {
        return roleOfGroupList;
    }

    public void setRoleOfGroupList(List<SysRole> roleOfGroupList) {
        this.roleOfGroupList = roleOfGroupList;
    }

    public List<SysRole> getOtherRoleList() {
        return otherRoleList;
    }

    public void setOtherRoleList(List<SysRole> otherRoleList) {
        this.otherRoleList = otherRoleList;
    }

    @Override
    public String toString() {
        return "SysGroupRoleVO{" +
                "roleOfGroupList=" + roleOfGroupList +
                ", otherRoleList=" + otherRoleList +
                '}';
    }
}

