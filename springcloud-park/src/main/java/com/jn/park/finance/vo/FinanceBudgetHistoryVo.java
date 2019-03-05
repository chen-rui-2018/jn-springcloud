package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="FinanceBudgetHistoryVo",description = "预算录入")
public class FinanceBudgetHistoryVo extends FinanceTotalBudgetVo implements Serializable {

    private static final long serialVersionUID = -8699257566205753723L;


    @ApiModelProperty("录入时间")
    private Date createdTime;

    @ApiModelProperty("预算类型 0：年初预算 1：临时预算")
    private Byte budgetType;

    @ApiModelProperty("预算类型(年初预算,临时预算)")
    private String budgetTypeName;


    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getBudgetTypeName() {
        return budgetTypeName;
    }

    public void setBudgetTypeName(String budgetTypeName) {
        this.budgetTypeName = budgetTypeName;
    }

    public Byte getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(Byte budgetType) {
        this.budgetType = budgetType;
    }
}
