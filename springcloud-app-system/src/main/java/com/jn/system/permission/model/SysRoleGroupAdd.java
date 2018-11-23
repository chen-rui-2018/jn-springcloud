package com.jn.system.permission.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 为用户组分配角色实体类
 * @author： shaobao
 * @date： Created on 2018/11/5 21:38
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRoleGroupAdd",description = "用户组添加角色实体")
public class SysRoleGroupAdd implements Serializable {
    private static final long serialVersionUID = -2260462623972187088L;
    @ApiModelProperty("角色id数组")
    private String[] roleIds;
    @NotBlank(message = "用户组id不能为空")
    @ApiModelProperty("用户组id")
    private String groupId;

    public SysRoleGroupAdd() {
    }

    public SysRoleGroupAdd(String[] roleIds, String groupId) {
        this.roleIds = roleIds;
        this.groupId = groupId;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "SysRoleGroupAdd{" +
                "roleIds=" + Arrays.toString(roleIds) +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
