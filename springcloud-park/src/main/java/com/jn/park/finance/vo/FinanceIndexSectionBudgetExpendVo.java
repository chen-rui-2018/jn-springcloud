package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/14
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIndexSectionBudgetExpendVo",description = "明细-部门支出预算统计柱状图")
public class FinanceIndexSectionBudgetExpendVo implements Serializable {


    private static final long serialVersionUID = -7954035698119529164L;
    @ApiModelProperty(value = "年份")
    private String month;

    @ApiModelProperty(value = "支出")
    private String cost;

    @ApiModelProperty(value = "预算")
    private String budgetNumber;

    @ApiModelProperty(value = "比例")
    private String ratio;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getBudgetNumber() {
        return budgetNumber;
    }

    public void setBudgetNumber(String budgetNumber) {
        this.budgetNumber = budgetNumber;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "FinanceIndexExpendBudgetStatisticsVo{" +
                "month='" + month + '\'' +
                ", cost='" + cost + '\'' +
                ", budgetNumber='" + budgetNumber + '\'' +
                ", ratio='" + ratio + '\'' +
                '}';
    }
}
