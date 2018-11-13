package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 部门删除实体
 *
 * @author： shaobao
 * @date： Created on 2018/11/12 20:19
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepaetmentDelete", description = "部门删除实体")
public class SysDepaetmentDelete implements Serializable {

    private static final long serialVersionUID = -6308448628820206249L;
    @ApiModelProperty("部门id数组")
    private String[] departmentIds;

    public SysDepaetmentDelete() {
    }

    public SysDepaetmentDelete(String[] departmentIds) {
        this.departmentIds = departmentIds;
    }

    public String[] getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String[] departmentIds) {
        this.departmentIds = departmentIds;
    }

    @Override
    public String toString() {
        return "SysDepaetmentDelete{" +
                "departmentIds=" + Arrays.toString(departmentIds) +
                '}';
    }
}
