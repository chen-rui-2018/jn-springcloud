package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 用户添加用户组实体
 * @author： shaobao
 * @date： Created on 2018/11/13 11:04
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserGroupAdd",description = "用户添加用户组实体")
public class SysUserGroupAdd implements Serializable {
    private static final long serialVersionUID = 8063898964840641572L;
    @ApiModelProperty("用户组id数组")
    private String[] groupIds;
    @NotBlank(message = "用户id不能为空！")
    @ApiModelProperty("用户id")
    private String userId;

    public SysUserGroupAdd() {
    }

    public SysUserGroupAdd(String[] groupIds, String userId) {
        this.groupIds = groupIds;
        this.userId = userId;
    }

    public String[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(String[] groupIds) {
        this.groupIds = groupIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SysUserGroupAdd{" +
                "groupIds=" + Arrays.toString(groupIds) +
                ", userId='" + userId + '\'' +
                '}';
    }
}
