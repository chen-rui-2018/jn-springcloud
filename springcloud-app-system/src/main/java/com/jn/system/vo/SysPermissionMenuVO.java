package com.jn.system.vo;

import com.jn.system.entity.TbSysMenu;
import com.jn.system.model.SysMenu;
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
    private List<TbSysMenu> sysMenuAll;

    public SysPermissionMenuVO() {
    }

    public SysPermissionMenuVO(List<SysMenu> sysMenuOfPermissionList, List<TbSysMenu> sysMenuAll) {
        this.sysMenuOfPermissionList = sysMenuOfPermissionList;
        this.sysMenuAll = sysMenuAll;
    }

    public List<SysMenu> getSysMenuOfPermissionList() {
        return sysMenuOfPermissionList;
    }

    public void setSysMenuOfPermissionList(List<SysMenu> sysMenuOfPermissionList) {
        this.sysMenuOfPermissionList = sysMenuOfPermissionList;
    }

    public List<TbSysMenu> getSysMenuAll() {
        return sysMenuAll;
    }

    public void setSysMenuAll(List<TbSysMenu> sysMenuAll) {
        this.sysMenuAll = sysMenuAll;
    }

    @Override
    public String toString() {
        return "SysPermissionMenuVO{" +
                "sysMenuOfPermissionList=" + sysMenuOfPermissionList +
                ", sysMenuAll=" + sysMenuAll +
                '}';
    }
}
