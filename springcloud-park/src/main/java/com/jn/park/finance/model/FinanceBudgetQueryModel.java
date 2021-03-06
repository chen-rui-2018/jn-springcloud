package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceBudgetQueryModel",description = "总预算查询条件")
public class FinanceBudgetQueryModel implements Serializable {
    private static final long serialVersionUID = -361729989487640941L;

    @ApiModelProperty(value = "费用类型ID",example = "4")
    private Integer costTypeId;

    @ApiModelProperty(value = "部门ID",example = "281f4005-0363-4528-92a3-60a730532e53")
    private String departmentId;

    @NotNull(message = "数据开始月份不能为空")
    @ApiModelProperty(value = "数据开始月份",example = "201901")
    private String startMonth;

    @NotNull(message = "数据结束月份不能为空")
    @ApiModelProperty(value = "数据结束月份",example = "201912")
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
