package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: tangry
 * @Date: 2019/3/21
 * @Version 1.0
 */
@ApiModel(value = "FinanceDerpartmentModel",description = "部门信息")
public class FinanceDerpartmentModel {

    @ApiModelProperty(value = "部门ID")
    private String  departmentId;

    @ApiModelProperty(value = "部门名称")
    private String  departmentName;


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
        return "FinanceDerpartmentModel{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
