package com.jn.system.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于菜单进行批量排序
 * @author： shaobao
 * @date： Created on 2018/11/26 19:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysMenus",description = "用于菜单进行批量排序")
public class SysMenus implements Serializable {
    private static final long serialVersionUID = 9087710919904505740L;
    @ApiModelProperty("菜单排序实体类集合")
    private List<SysMenuUpdate> sysMenuSortList;

    public SysMenus() {
    }

    public SysMenus(List<SysMenuUpdate> sysMenuSortList) {
        this.sysMenuSortList = sysMenuSortList;
    }

    public List<SysMenuUpdate> getSysMenuSortList() {
        return sysMenuSortList;
    }

    public void setSysMenuSortList(List<SysMenuUpdate> sysMenuSortList) {
        this.sysMenuSortList = sysMenuSortList;
    }

    @Override
    public String toString() {
        return "SysMenus{" +
                "sysMenuSortList=" + sysMenuSortList +
                '}';
    }
}
