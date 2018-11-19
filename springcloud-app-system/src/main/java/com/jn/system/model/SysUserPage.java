package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;

/**
 *查询工具类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserPage",description = "用户条件分页查询类")
public class SysUserPage extends Page implements Serializable {

    private static final long serialVersionUID = 2197567068130372509L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("部门id")
    private String[] departmentIds;

    public SysUserPage() {
    }

    public SysUserPage(String name, String status, String[] departmentIds) {
        this.name = name;
        this.status = status;
        this.departmentIds = departmentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(String[] departmentIds) {
        this.departmentIds = departmentIds;
    }

    @Override
    public String toString() {
        return "SysUserPage{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", departmentIds=" + Arrays.toString(departmentIds) +
                '}';
    }
}
