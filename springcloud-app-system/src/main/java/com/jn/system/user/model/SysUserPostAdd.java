package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户及岗位
 * @author： shaobao
 * @date： Created on 2018/11/8 9:13
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserPostAdd",description = "用户及岗位")
public class SysUserPostAdd implements Serializable {
    private static final long serialVersionUID = 1144521838334957110L;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("岗位id")
    private String postId;

    public SysUserPostAdd() {
    }

    public SysUserPostAdd(String userId, String postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "SysUserPostAdd{" +
                "userId='" + userId + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
