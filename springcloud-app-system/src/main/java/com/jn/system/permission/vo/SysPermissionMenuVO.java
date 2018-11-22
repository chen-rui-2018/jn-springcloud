package com.jn.system.permission.vo;

import com.jn.system.menu.model.SysMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用户权限界面返回权限已经具有的菜单信息及所有菜单信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/15 11:15
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionMenuVO", description = "用户权限界面返回权限已经具有的菜单信息及所有菜单信息")
public class SysPermissionMenuVO implements Serializable {
    private static final long serialVersionUID = -4381347674315998326L;
    @ApiModelProperty("权限已经具有的菜单信息")
    private List<SysMenu> sysMenuOfPermissionList;
    @ApiModelProperty("所有菜单信息")
    private List<SysMenu> otherMenuList;

    public SysPermissionMenuVO() {
    }

    public SysPermissionMenuVO(List<SysMenu> sysMenuOfPermissionList, List<SysMenu> otherMenuList) {
        this.sysMenuOfPermissionList = sysMenuOfPermissionList;
        this.otherMenuList = otherMenuList;
    }

    public List<SysMenu> getSysMenuOfPermissionList() {
        return sysMenuOfPermissionList;
    }

    public void setSysMenuOfPermissionList(List<SysMenu> sysMenuOfPermissionList) {
        this.sysMenuOfPermissionList = sysMenuOfPermissionList;
    }

    public List<SysMenu> getOtherMenuList() {
        return otherMenuList;
    }

    public void setOtherMenuList(List<SysMenu> otherMenuList) {
        this.otherMenuList = otherMenuList;
    }

    @Override
    public String toString() {
        return "SysPermissionMenuVO{" +
                "sysMenuOfPermissionList=" + sysMenuOfPermissionList +
                ", otherMenuList=" + otherMenuList +
                '}';
    }
}
