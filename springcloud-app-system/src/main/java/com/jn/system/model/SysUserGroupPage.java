package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.bouncycastle.cms.PasswordRecipientId;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 用于用户界面条件分页获取用户组信息
 *
 * @author： shaobao
 * @date： Created on 2018/11/17 10:05
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserGroupPage",description = "用于用户界面条件分页获取用户组信息")
public class SysUserGroupPage extends Page implements Serializable {
    private static final long serialVersionUID = -8503186859976394778L;
    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty("用户组名称,用于条件查询")
    private String userGroupName;

    public SysUserGroupPage() {
    }

    public SysUserGroupPage(String userId, String userGroupName) {
        this.userId = userId;
        this.userGroupName = userGroupName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    @Override
    public String toString() {
        return "SysUserGroupPage{" +
                "userId='" + userId + '\'' +
                ", userGroupName='" + userGroupName + '\'' +
                '}';
    }
}
