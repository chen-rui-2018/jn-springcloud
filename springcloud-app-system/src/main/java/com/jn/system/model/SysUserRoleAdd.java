package com.jn.system.model;

import com.jn.system.enums.SysStatusEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户选择角色
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysUserRoleAdd", description = "用户选择角色实体")
public class SysUserRoleAdd implements Serializable {

    private static final long serialVersionUID = -5110778698071514990L;

    @ApiModelProperty(value = "用户id")
    private String[] userId;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    public String[] getUserId() {
        return userId;
    }

    public void setUserId(String[] userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}