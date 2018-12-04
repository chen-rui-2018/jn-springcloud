package com.jn.system.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用于用户界面条件分页获取用户未拥有的角色信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 10:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserRolePage",description = "用于用户界面条件分页获取用户未拥有的角色信息")
public class SysUserRolePage extends Page implements Serializable {
    private static final long serialVersionUID = -4475137845859798194L;
    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty("角色名称,用于条件查询")
    private String roleName;

    public SysUserRolePage() {
    }

    public SysUserRolePage(String userId, String roleName) {
        this.userId = userId;
        this.roleName = roleName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysUserRolePage{" +
                "userId='" + userId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
