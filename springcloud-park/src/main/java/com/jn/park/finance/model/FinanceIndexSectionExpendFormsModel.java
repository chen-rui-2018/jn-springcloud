package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIndexSectionExpendFormsModel",description = "部门预算支出报表")
public class FinanceIndexSectionExpendFormsModel implements Serializable {

    /*@ApiModelProperty("日期")
    private String budgetmonth;
    @ApiModelProperty("支出类型")
    private String costtypename;
    @ApiModelProperty("预算")
    private String budgetnumber;
    @ApiModelProperty("支出")
    private String cost;*/

    @ApiModelProperty("日期")
    private String month;
    @ApiModelProperty("预算")
    private BigDecimal budgetNumber;
    @ApiModelProperty("支出")
    private BigDecimal cost;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getBudgetNumber() {
        return budgetNumber;
    }

    public void setBudgetNumber(BigDecimal budgetNumber) {
        this.budgetNumber = budgetNumber;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FinanceIndexSectionExpendFormsModel{" +
                "month='" + month + '\'' +
                ", budgetNumber=" + budgetNumber +
                ", cost=" + cost +
                '}';
    }
}
