package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 角色授权用户时,条件分页查询角色为拥有的用户信息
 * @author： shaobao
 * @date： Created on 2018/11/16 14:18
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRoleUserPage",description = "角色授权用户时,条件分页查询角色为拥有的用户信息")
public class SysRoleUserPage extends Page implements Serializable {
    private static final long serialVersionUID = 5004784786615392695L;
    @ApiModelProperty("角色id")
    @NotBlank(message = "角色id不能为空")
    private String roleId;
    @ApiModelProperty("用户名称,用于名称查询")
    private String userName;

    public SysRoleUserPage() {
    }

    public SysRoleUserPage(String roleId, String userName) {
        this.roleId = roleId;
        this.userName = userName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SysRoleUserPage{" +
                "roleId='" + roleId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
