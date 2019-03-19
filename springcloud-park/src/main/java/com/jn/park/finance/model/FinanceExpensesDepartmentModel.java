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
@ApiModel(value = "FinanceExpensesDepartmentModel",description = "首页部门支出预算模块")
public class FinanceExpensesDepartmentModel extends Page implements Serializable {


    private static final long serialVersionUID = -8287278418633994400L;


    @ApiModelProperty(value = "部门ID")
    private String  departmentId;

    @ApiModelProperty(value = "部门名称")
    private String  departmentName;

    @ApiModelProperty(value = "开始时间")
    private String  startTime;

    @ApiModelProperty(value = "结束时间")
    private String  endTime;


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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
