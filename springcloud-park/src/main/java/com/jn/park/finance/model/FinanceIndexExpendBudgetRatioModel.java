package com.jn.park.finance.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/8
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIndexExpendBudgetRatioModel",description = "全年支出预算统计图支出")
public class FinanceIndexExpendBudgetRatioModel implements Serializable {

    @ApiModelProperty("总支出")
    private String sumExpeng;
    @ApiModelProperty("总预算")
    private String budgetnumber;
    @ApiModelProperty("支出类别名称")
    private String costftertypename;
    @ApiModelProperty("支出金额")
    private String cost;


    public String getSumExpeng() {
        return sumExpeng;
    }

    public void setSumExpeng(String sumExpeng) {
        this.sumExpeng = sumExpeng;
    }

    public String getBudgetnumber() {
        return budgetnumber;
    }

    public void setBudgetnumber(String budgetnumber) {
        this.budgetnumber = budgetnumber;
    }

    public String getCostftertypename() {
        return costftertypename;
    }

    public void setCostftertypename(String costftertypename) {
        this.costftertypename = costftertypename;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FinanceIndexExpendBudgetRatioModel{" +
                "sumExpeng='" + sumExpeng + '\'' +
                ", budgetnumber='" + budgetnumber + '\'' +
                ", costftertypename='" + costftertypename + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
