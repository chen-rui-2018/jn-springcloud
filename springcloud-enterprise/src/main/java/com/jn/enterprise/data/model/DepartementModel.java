package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： yangh
 * @date： Created on 2019/4/24 14:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DepartementModel",description = "部门")
public class DepartementModel {
    @ApiModelProperty(value = "部门ID",example = "001")
    private String departmentId;
    @ApiModelProperty(value = "部门名称",example = "招商部")
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
}
