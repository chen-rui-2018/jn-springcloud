package com.jn.system.vo;

import com.jn.system.entity.TbSysResources;
import com.jn.system.model.SysResources;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 权限界面用于返回权限具有的功能信息及所有的功能信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/15 14:11
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionResourcesVO", description = "权限界面用于返回权限具有的功能信息及所有的功能信息")
public class SysPermissionResourcesVO implements Serializable {
    private static final long serialVersionUID = -1139805140631331599L;
    @ApiModelProperty("权限具有的功能信息")
    private List<SysResources> sysResourcesOfPermissionList;
    @ApiModelProperty("所有的功能信息")
    private List<SysResources> otherResourceList;

    public SysPermissionResourcesVO() {
    }

    public SysPermissionResourcesVO(List<SysResources> sysResourcesOfPermissionList, List<SysResources> otherResourceList) {
        this.sysResourcesOfPermissionList = sysResourcesOfPermissionList;
        this.otherResourceList = otherResourceList;
    }

    public List<SysResources> getSysResourcesOfPermissionList() {
        return sysResourcesOfPermissionList;
    }

    public void setSysResourcesOfPermissionList(List<SysResources> sysResourcesOfPermissionList) {
        this.sysResourcesOfPermissionList = sysResourcesOfPermissionList;
    }

    public List<SysResources> getOtherResourceList() {
        return otherResourceList;
    }

    public void setOtherResourceList(List<SysResources> otherResourceList) {
        this.otherResourceList = otherResourceList;
    }

    @Override
    public String toString() {
        return "SysPermissionResourcesVO{" +
                "sysResourcesOfPermissionList=" + sysResourcesOfPermissionList +
                ", otherResourceList=" + otherResourceList +
                '}';
    }
}
