package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIncomePeriodVo",description = "收入与同期对比")
public class FinanceIncomePeriodVo implements Serializable {
    @ApiModelProperty(value = "日期")
    private String incomeMonth;
    @ApiModelProperty(value = "月份")
    private String month;
    @ApiModelProperty(value = "收入")
    private String income;
    @ApiModelProperty(value = "去年同期收入")
    private String lastYearIncome;
    @ApiModelProperty(value = "对比去年同期收入")
    private String lastYearPercent;
    @ApiModelProperty(value = "总收入")
    private String sumIncome;
    @ApiModelProperty(value = "对比去年同期")
    private String sumLastYearPercent;


    public String getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(String incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getLastYearIncome() {
        return lastYearIncome;
    }

    public void setLastYearIncome(String lastYearIncome) {
        this.lastYearIncome = lastYearIncome;
    }

    public String getLastYearPercent() {
        return lastYearPercent;
    }

    public void setLastYearPercent(String lastYearPercent) {
        this.lastYearPercent = lastYearPercent;
    }

    public String getSumIncome() {
        return sumIncome;
    }

    public void setSumIncome(String sumIncome) {
        this.sumIncome = sumIncome;
    }

    public String getSumLastYearPercent() {
        return sumLastYearPercent;
    }

    public void setSumLastYearPercent(String sumLastYearPercent) {
        this.sumLastYearPercent = sumLastYearPercent;
    }


}
