package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIncomeLastYearContrastModel",description = "往年对比")
public class FinanceIncomeLastYearContrastModel implements Serializable {
    @ApiModelProperty(value = "去年")
    private String lastYearIncome;
    @ApiModelProperty(value = "今年")
    private String income;

    public String getLastYearIncome() {
        return lastYearIncome;
    }

    public void setLastYearIncome(String lastYearIncome) {
        this.lastYearIncome = lastYearIncome;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
