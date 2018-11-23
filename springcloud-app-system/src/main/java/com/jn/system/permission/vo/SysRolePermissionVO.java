package com.jn.system.permission.vo;

import com.jn.system.permission.model.SysPermission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 角色界面返回权限信息实体
 * @author： shaobao
 * @date： Created on 2018/11/16 16:25
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRolePermissionVO",description = "角色界面返回权限信息实体")
public class SysRolePermissionVO implements Serializable {

    private static final long serialVersionUID = -1933417894246258585L;
    @ApiModelProperty("角色已经具有的权限信息")
    private List<SysPermission> permissionOfRoleList;
    @ApiModelProperty("角色未具有的权限信息")
    private List<SysPermission> otherPermissionList;

    public SysRolePermissionVO() {
    }

    public SysRolePermissionVO(List<SysPermission> permissionOfRoleList, List<SysPermission> otherPermissionList) {
        this.permissionOfRoleList = permissionOfRoleList;
        this.otherPermissionList = otherPermissionList;
    }

    public List<SysPermission> getPermissionOfRoleList() {
        return permissionOfRoleList;
    }

    public void setPermissionOfRoleList(List<SysPermission> permissionOfRoleList) {
        this.permissionOfRoleList = permissionOfRoleList;
    }

    public List<SysPermission> getOtherPermissionList() {
        return otherPermissionList;
    }

    public void setOtherPermissionList(List<SysPermission> otherPermissionList) {
        this.otherPermissionList = otherPermissionList;
    }

    @Override
    public String toString() {
        return "SysRolePermissionVO{" +
                "permissionOfRoleList=" + permissionOfRoleList +
                ", otherPermissionList=" + otherPermissionList +
                '}';
    }
}
