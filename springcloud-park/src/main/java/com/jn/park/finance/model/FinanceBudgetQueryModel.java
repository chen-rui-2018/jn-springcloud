package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceBudgetQueryModel",description = "总预算查询条件")
public class FinanceBudgetQueryModel extends Page implements Serializable {
    private static final long serialVersionUID = -361729989487640941L;

    @ApiModelProperty("费用类型ID")
    private Integer costTypeId;

    @ApiModelProperty("部门ID")
    private String departmentId;

    @ApiModelProperty("数据开始月份")
    private String startMonth;

    @ApiModelProperty("数据结束s月份")
    private String endMonth;

    @ApiModelProperty("排序条件")
    private String orderByClause;

    public Integer getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(Integer costTypeId) {
        this.costTypeId = costTypeId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }


    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
