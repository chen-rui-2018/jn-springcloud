package com.jn.system.vo;

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
    private List<SysRole> sysRoleOfUser;
    @ApiModelProperty("所有角色")
    private List<SysRole> sysRoleAll;

    public SysUserRoleVO() {
    }

    public SysUserRoleVO(List<SysRole> sysRoleOfUser, List<SysRole> sysRoleAll) {
        this.sysRoleOfUser = sysRoleOfUser;
        this.sysRoleAll = sysRoleAll;
    }

    public List<SysRole> getSysRoleOfUser() {
        return sysRoleOfUser;
    }

    public void setSysRoleOfUser(List<SysRole> sysRoleOfUser) {
        this.sysRoleOfUser = sysRoleOfUser;
    }

    public List<SysRole> getSysRoleAll() {
        return sysRoleAll;
    }

    public void setSysRoleAll(List<SysRole> sysRoleAll) {
        this.sysRoleAll = sysRoleAll;
    }

    @Override
    public String toString() {
        return "SysUserRoleVO{" +
                "sysRoleOfUser=" + sysRoleOfUser +
                ", sysRoleAll=" + sysRoleAll +
                '}';
    }
}
