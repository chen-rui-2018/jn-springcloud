package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 部门岗位
 *
 * @author： shaobao
 * @date： Created on 2018/11/8 0:59
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentPost", description = "部门岗位")
public class SysDepartmentPost implements Serializable {

    private static final long serialVersionUID = -5641244659720519896L;
    @ApiModelProperty("部门id")
    private String departmentId;
    @ApiModelProperty("岗位id")
    private String postId;
    @ApiModelProperty("部门岗位是否默认")
    @Pattern(regexp="^[01]$",message="{isDefault:'默认值只允许为0,1'}")
    private String isDefault;

    public SysDepartmentPost() {
    }

    public SysDepartmentPost(String departmentId, String postId, String isDefault) {
        this.departmentId = departmentId;
        this.postId = postId;
        this.isDefault = isDefault;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "SysDepartmentPost{" +
                "departmentId='" + departmentId + '\'' +
                ", postId='" + postId + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
