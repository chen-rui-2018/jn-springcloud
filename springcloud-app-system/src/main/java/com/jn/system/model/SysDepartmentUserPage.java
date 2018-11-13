package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 条件分页用于查询部门具有用户以外用户
 *
 * @author： shaobao
 * @date： Created on 2018/11/7 20:21
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentUserPage", description = "条件分页用于查询部门具有用户以外用户")
public class SysDepartmentUserPage extends Page implements Serializable {

    private static final long serialVersionUID = 1270305903793734287L;
    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("用户名称")
    private String name;

    public SysDepartmentUserPage() {
    }

    public SysDepartmentUserPage(String departmentId, String name) {
        this.departmentId = departmentId;
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysDepartmentUserPage{" +
                "departmentId='" + departmentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
