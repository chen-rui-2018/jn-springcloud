package com.jn.system.dept.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
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
    private Byte recordStatus;

    public SysDepartmentPage() {
    }

    public SysDepartmentPage(String departmentName, Byte recordStatus) {
        this.departmentName = departmentName;
        this.recordStatus = recordStatus;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysDepartmentPage{" +
                "departmentName='" + departmentName + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
