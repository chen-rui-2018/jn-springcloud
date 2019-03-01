package com.jn.system.user.vo;

import com.jn.system.model.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用户界面返回用户具有的角色及所有角色信息
 * @author： shaobao
 * @date： Created on 2018/11/14 19:19
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserRoleVO",description = "用户界面返回用户具有的角色及所有角色信息")
public class SysUserRoleVO implements Serializable {
    private static final long serialVersionUID = -6753835711994878991L;
    @ApiModelProperty("用户具有的角色")
    private List<SysRole> sysRoleOfUserList;
    @ApiModelProperty("用户未拥有角色")
    private List<SysRole> otherRoleList;

    public SysUserRoleVO() {
    }

    public SysUserRoleVO(List<SysRole> sysRoleOfUserList, List<SysRole> otherRoleList) {
        this.sysRoleOfUserList = sysRoleOfUserList;
        this.otherRoleList = otherRoleList;
    }

    public List<SysRole> getSysRoleOfUserList() {
        return sysRoleOfUserList;
    }

    public void setSysRoleOfUserList(List<SysRole> sysRoleOfUserList) {
        this.sysRoleOfUserList = sysRoleOfUserList;
    }

    public List<SysRole> getOtherRoleList() {
        return otherRoleList;
    }

    public void setOtherRoleList(List<SysRole> otherRoleList) {
        this.otherRoleList = otherRoleList;
    }

    @Override
    public String toString() {
        return "SysUserRoleVO{" +
                "sysRoleOfUserList=" + sysRoleOfUserList +
                ", otherRoleList=" + otherRoleList +
                '}';
    }
}
