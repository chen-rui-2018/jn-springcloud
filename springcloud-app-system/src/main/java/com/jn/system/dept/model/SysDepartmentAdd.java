package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 部门添加实体
 * @author： shaobao
 * @date： Created on 2018/11/7 14:16
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentAdd",description = "部门添加实体")
public class SysDepartmentAdd implements Serializable {

    private static final long serialVersionUID = -5667858257333477069L;
    @NotBlank(message = "部门父级id不能为空")
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("部门名称数组")
    private String departmentName;

    public SysDepartmentAdd() {
    }

    public SysDepartmentAdd(String parentId, String departmentName) {
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
