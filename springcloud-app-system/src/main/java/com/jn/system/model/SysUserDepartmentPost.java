package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * 根据用户id查询用户部门岗位
 * @author： shaobao
 * @date： Created on 2018/11/7 11:41
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserPage",description = "根据用户id查询用户部门岗位")
public class SysUserDepartmentPost extends Page {

    @ApiModelProperty("userId")
    private String userId;

    @ApiModelProperty("部门岗位状态")
    private String departmentPostStatus;

    @ApiModelProperty("是否默认")
    @Pattern(regexp="^[01]$",message="{isDefault:'默认值值只允许为0,1'}")
    private String isDefault;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("状态")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    @ApiModelProperty("部门id")
    private String departmentId;

    public SysUserDepartmentPost() {
    }

    public SysUserDepartmentPost(String userId, String departmentPostStatus, String isDefault,
                                 String name, String status, String departmentId) {
        this.userId = userId;
        this.departmentPostStatus = departmentPostStatus;
        this.isDefault = isDefault;
        this.name = name;
        this.status = status;
        this.departmentId = departmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentPostStatus() {
        return departmentPostStatus;
    }

    public void setDepartmentPostStatus(String departmentPostStatus) {
        this.departmentPostStatus = departmentPostStatus;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "SysUserDepartmentPost{" +
                "userId='" + userId + '\'' +
                ", departmentPostStatus='" + departmentPostStatus + '\'' +
                ", isDefault='" + isDefault + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
