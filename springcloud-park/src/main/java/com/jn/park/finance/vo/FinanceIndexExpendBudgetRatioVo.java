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
@ApiModel(value = "FinanceIndexExpendBudgetRatioVo",description = "明细-各项累计支出占比-饼状图")
public class FinanceIndexExpendBudgetRatioVo implements Serializable {


    private static final long serialVersionUID = 5247456399373021944L;

    @ApiModelProperty("总支出")
    private String sumExpeng;
    @ApiModelProperty("总预算")
    private String budgetnumber;
    @ApiModelProperty("支出类别名称")
    private String costftertypename;
    @ApiModelProperty("支出金额")
    private String cost;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
        return "FinanceIndexExpendBudgetRatioVo{" +
                "sumExpeng='" + sumExpeng + '\'' +
                ", budgetnumber='" + budgetnumber + '\'' +
                ", costftertypename='" + costftertypename + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
