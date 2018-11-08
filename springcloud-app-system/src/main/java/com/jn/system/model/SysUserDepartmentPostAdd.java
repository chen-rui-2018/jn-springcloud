package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用户添加部门岗位实体
 * @author： shaobao
 * @date： Created on 2018/11/8 1:01
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserDepartmentPostAdd",description = "用户添加部门岗位实体")
public class SysUserDepartmentPostAdd implements Serializable {
    private static final long serialVersionUID = 7361217970856264730L;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("部门岗位id集合")
    private List<SysDepartmentPost> sysDepartmentPostList;

    public SysUserDepartmentPostAdd() {
    }

    public SysUserDepartmentPostAdd(String userId, List<SysDepartmentPost> sysDepartmentPostList) {
        this.userId = userId;
        this.sysDepartmentPostList = sysDepartmentPostList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SysDepartmentPost> getSysDepartmentPostList() {
        return sysDepartmentPostList;
    }

    public void setSysDepartmentPostList(List<SysDepartmentPost> sysDepartmentPostList) {
        this.sysDepartmentPostList = sysDepartmentPostList;
    }

    @Override
    public String toString() {
        return "SysUserDepartmentPostAdd{" +
                "userId='" + userId + '\'' +
                ", sysDepartmentPostList=" + sysDepartmentPostList +
                '}';
    }
}
