package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *查询工具类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserPage",description = "用户条件分页查询类")
public class SysUserPage extends Page implements Serializable {

    private static final long serialVersionUID = 2197567068130372509L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("部门岗位状态")
    private String departmentPostStatus;

    @ApiModelProperty("是否默认")
    private String isDefault;

    public SysUserPage() {
    }

    public SysUserPage(String id, String name, String status, String departmentId,
                       String departmentPostStatus, String isDefault) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.departmentId = departmentId;
        this.departmentPostStatus = departmentPostStatus;
        this.isDefault = isDefault;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "SysUserPage{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentPostStatus='" + departmentPostStatus + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
