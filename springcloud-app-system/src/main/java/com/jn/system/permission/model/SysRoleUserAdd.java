package com.jn.system.permission.model;

import com.jn.common.util.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import sun.java2d.pipe.SolidTextRenderer;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 用户添加角色实体
 * @author： shaobao
 * @date： Created on 2018/11/13 11:08
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysRoleUserAdd",description = "用户添加角色实体")
public class SysRoleUserAdd implements Serializable {
    private static final long serialVersionUID = 7571554827328255079L;
    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空！")
    private String userId;
    @ApiModelProperty("角色id")
    private String[] roleIds;

    public SysRoleUserAdd() {
    }

    public SysRoleUserAdd(String userId, String[] roleIds) {
        this.userId = userId;
        this.roleIds = roleIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "SysRoleUserAdd{" +
                "userId='" + userId + '\'' +
                ", roleIds=" + Arrays.toString(roleIds) +
                '}';
    }
}
