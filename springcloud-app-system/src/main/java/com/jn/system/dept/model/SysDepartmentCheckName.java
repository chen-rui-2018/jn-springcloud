package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 部门校验名称实体
 * @author： shaobao
 * @date： Created on 2018/11/23 15:55
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentCheckName",description = "部门校验名称实体")
public class SysDepartmentCheckName implements Serializable {

    private static final long serialVersionUID = -1675079560991801814L;

    @NotBlank(message = "部门父级id不能为空")
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("部门名称数组")
    private String departmentName;

    public SysDepartmentCheckName() {
    }

    public SysDepartmentCheckName(String parentId, String departmentName) {
        this.parentId = parentId;
        this.departmentName = departmentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "SysDepartmentAdd{" +
                "parentId='" + parentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
