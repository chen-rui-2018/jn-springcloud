package com.jn.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 角色
 * @author： huxw
 * @date： Created on 2019-6-25 11:20:11
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysRoleVO", description = "角色信息")
public class SysRoleVO implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "SysRoleVO{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
