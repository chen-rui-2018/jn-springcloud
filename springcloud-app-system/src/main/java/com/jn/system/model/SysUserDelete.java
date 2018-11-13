package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 批量删除用户实体
 *
 * @author： shaobao
 * @date： Created on 2018/11/12 14:07
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserDelete", description = "批量删除用户实体")
public class SysUserDelete implements Serializable {
    private static final long serialVersionUID = -2909828054438675570L;
    @ApiModelProperty("用户id数组")
    private String[] userIds;

    public SysUserDelete() {
    }

    public SysUserDelete(String[] userIds) {
        this.userIds = userIds;
    }

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    @Override
    public String toString() {
        return "SysUserDelete{" +
                "userIds=" + Arrays.toString(userIds) +
                '}';
    }
}
