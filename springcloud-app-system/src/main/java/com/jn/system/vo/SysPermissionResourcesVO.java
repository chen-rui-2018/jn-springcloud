package com.jn.system.vo;

import com.jn.system.entity.TbSysResources;
import com.jn.system.model.SysResources;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 权限界面用于返回权限具有的功能信息及所有的功能信息
 * @author： shaobao
 * @date： Created on 2018/11/15 14:11
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysPermissionResourcesVO",description = "权限界面用于返回权限具有的功能信息及所有的功能信息")
public class SysPermissionResourcesVO implements Serializable {
    private static final long serialVersionUID = -1139805140631331599L;
    @ApiModelProperty("权限具有的功能信息")
    private List<SysResources> sysResourcesOfPermission;
    @ApiModelProperty("所有的功能信息")
    private List<TbSysResources> sysResourceAll;

    public SysPermissionResourcesVO() {
    }

    public SysPermissionResourcesVO(List<SysResources> sysResourcesOfPermission, List<TbSysResources> sysResourceAll) {
        this.sysResourcesOfPermission = sysResourcesOfPermission;
        this.sysResourceAll = sysResourceAll;
    }

    public List<SysResources> getSysResourcesOfPermission() {
        return sysResourcesOfPermission;
    }

    public void setSysResourcesOfPermission(List<SysResources> sysResourcesOfPermission) {
        this.sysResourcesOfPermission = sysResourcesOfPermission;
    }

    public List<TbSysResources> getSysResourceAll() {
        return sysResourceAll;
    }

    public void setSysResourceAll(List<TbSysResources> sysResourceAll) {
        this.sysResourceAll = sysResourceAll;
    }


    @Override
    public String toString() {
        return "SysPermissionResourcesVO{" +
                "sysResourcesOfPermission=" + sysResourcesOfPermission +
                ", sysResourceAll=" + sysResourceAll +
                '}';
    }
}
