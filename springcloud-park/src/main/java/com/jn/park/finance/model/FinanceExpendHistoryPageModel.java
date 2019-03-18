package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**
 * @author： tangry
 * @date： Created on 2019/3/9
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceExpendHistoryPageModel",description = "支出录入历史查询分页")
public class FinanceExpendHistoryPageModel extends Page implements Serializable {


    private static final long serialVersionUID = -1964455345534916201L;
    @ApiModelProperty(value = "部门ID")
    private String  departmentId;
    @ApiModelProperty(value = "流水号")
    private String  costId;
    @ApiModelProperty(value = "开始时间YYYYMM")
    private String  startTime;
    @ApiModelProperty(value = "结束时间YYYYMM")
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

    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
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
