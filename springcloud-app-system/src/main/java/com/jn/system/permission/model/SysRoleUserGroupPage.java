package com.jn.system.permission.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 角色界面用于授权用户组时条件查询用户组信息
 * @author： shaobao
 * @date： Created on 2018/11/16 15:01
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRoleUserGroupPage",description = "角色界面用于授权用户组时条件查询用户组信息")
public class SysRoleUserGroupPage extends Page implements Serializable {
    private static final long serialVersionUID = -8328513289055722693L;
    @ApiModelProperty("角色id")
    @NotBlank(message = "角色id不能为空")
    private String roleId;
    @ApiModelProperty("用户组名称,用于名称查询")
    private String userGroupName;

    public SysRoleUserGroupPage() {
    }

    public SysRoleUserGroupPage(String roleId, String userGroupName) {
        this.roleId = roleId;
        this.userGroupName = userGroupName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    @Override
    public String toString() {
        return "SysRoleUserGroupPage{" +
                "roleId='" + roleId + '\'' +
                ", userGroupName='" + userGroupName + '\'' +
                '}';
    }
}
