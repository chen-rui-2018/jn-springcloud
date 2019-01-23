package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
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

    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;


    @ApiModelProperty("部门id")
    private String departmentId;

    public SysUserPageDepartmentOne() {
    }

    public SysUserPageDepartmentOne(String name, Byte recordStatus, String departmentId) {
        this.name = name;
        this.recordStatus = recordStatus;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
                ", recordStatus=" + recordStatus +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
