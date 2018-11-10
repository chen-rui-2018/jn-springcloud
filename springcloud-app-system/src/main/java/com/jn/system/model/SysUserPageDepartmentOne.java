package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户条件分页查询
 * @author： shaobao
 * @date： Created on 2018/11/10 11:25
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserPage",description = "用户条件分页查询")
public class SysUserPageDepartmentOne implements Serializable {
    private static final long serialVersionUID = -7606963081636682180L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("部门id")
    private String departmentId;

    public SysUserPageDepartmentOne() {
    }

    public SysUserPageDepartmentOne(String name, String status, String departmentId) {
        this.name = name;
        this.status = status;
        this.departmentId = departmentId;
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
        return "SysUserPageDepartmentOne{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
