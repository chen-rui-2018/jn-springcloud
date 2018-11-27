package com.jn.system.permission.vo;

import com.jn.system.menu.vo.SysMenuTreeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用于权限授权功能所有菜单,页面功能信息,及权限已有菜单,功能信息对应id
 * @author： shaobao
 * @date： Created on 2018/11/24 20:26
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysMenuResourcesVO",description = "用于权限授权功能所有菜单,页面功能信息,及权限已有菜单,功能信息对应id")
public class SysMenuResourcesVO implements Serializable {
    private static final long serialVersionUID = 7154732583772161542L;
    @ApiModelProperty("菜单及功能id集合")
    private List<String> menuAndResourcesIds;
    @ApiModelProperty("菜单树信息")
    private List<SysMenuTreeVO> sysMenuTreeVOList;

    public SysMenuResourcesVO() {
    }

    public SysMenuResourcesVO(List<String> menuAndResourcesIds, List<SysMenuTreeVO> sysMenuTreeVOList) {
        this.menuAndResourcesIds = menuAndResourcesIds;
        this.sysMenuTreeVOList = sysMenuTreeVOList;
    }

    public List<String> getMenuAndResourcesIds() {
        return menuAndResourcesIds;
    }

    public void setMenuAndResourcesIds(List<String> menuAndResourcesIds) {
        this.menuAndResourcesIds = menuAndResourcesIds;
    }

    public List<SysMenuTreeVO> getSysMenuTreeVOList() {
        return sysMenuTreeVOList;
    }

    public void setSysMenuTreeVOList(List<SysMenuTreeVO> sysMenuTreeVOList) {
        this.sysMenuTreeVOList = sysMenuTreeVOList;
    }

    @Override
    public String toString() {
        return "SysMenuResourcesVO{" +
                "menuAndResourcesIds=" + menuAndResourcesIds +
                ", sysMenuTreeVOList=" + sysMenuTreeVOList +
                '}';
    }
}
