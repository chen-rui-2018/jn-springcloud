package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 部门条件分页查询
 *
 * @author： shaobao
 * @date： Created on 2018/11/7 19:18
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentPage", description = "部门条件分页查询")
public class SysDepartmentPage extends Page implements Serializable {

    private static final long serialVersionUID = 4050951256991437887L;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("状态")
    private String status;

    public SysDepartmentPage() {
    }

    public SysDepartmentPage(String departmentName, String status) {
        this.departmentName = departmentName;
        this.status = status;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysDepartmentPage{" +
                "departmentName='" + departmentName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
