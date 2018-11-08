package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("部门名称数组")
    private String[] departmentNames;

    public SysDepartmentAdd() {
    }

    public SysDepartmentAdd(String parentId, String[] departmentNames) {
        this.parentId = parentId;
        this.departmentNames = departmentNames;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String[] getDepartmentNames() {
        return departmentNames;
    }

    public void setDepartmentNames(String[] departmentNames) {
        this.departmentNames = departmentNames;
    }

    @Override
    public String toString() {
        return "SysDepartmentAdd{" +
                "parentId='" + parentId + '\'' +
                ", departmentNames=" + Arrays.toString(departmentNames) +
                '}';
    }
}
