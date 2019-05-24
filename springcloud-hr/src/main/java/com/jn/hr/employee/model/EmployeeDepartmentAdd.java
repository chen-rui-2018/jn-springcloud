package com.jn.hr.employee.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-18 下午 5:33
 */
@ApiModel(value = "EmployeeDepartmentAdd", description = "组织架构添加实体")
public class EmployeeDepartmentAdd implements Serializable {
    @ApiModelProperty(value = "部门ID")
    private String departmentId;
    @ApiModelProperty(value = "部门名称")
    @NotNull(message = "部门名称不能为空")
    private String departmentName;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeDepartmentAdd{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
