package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="FinanceBudgetHistoryQueryModel",description = "预算录入历史记录查询条件")
public class FinanceBudgetHistoryQueryModel extends FinanceBudgetQueryModel implements Serializable {

    private static final long serialVersionUID = 6136152281178177908L;

    @ApiModelProperty("预算类型 0：年初预算 1：临时预算")
    private Byte budgetType;


    public Byte getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(Byte budgetType) {
        this.budgetType = budgetType;
    }

}
