package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author： tangry
 * @date： Created on 2019/3/15
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceSelectDepartmentModel",description = "获取部门信息")
public class FinanceSelectDepartmentModel extends Page implements Serializable {


    private static final long serialVersionUID = -8287278418633994400L;


    @ApiModelProperty(value = "部门ID")
    private String  departmentId;

    @ApiModelProperty(value = "部门名称")
    private String  departmentName;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
        return "FinanceSelectDepartmentModel{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
