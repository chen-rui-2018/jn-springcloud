package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: tangry
 * @Date: 2019/3/22
 * @Version 1.0
 */
@ApiModel(value = "FinanceIncomeUpdateMonthModel",description = "更新月表")
public class FinanceIncomeUpdateMonthModel implements Serializable {

    private static final long serialVersionUID = -4135271981608382871L;

    @ApiModelProperty(value = "费用日期")
    private String incomeMonth;

    @ApiModelProperty(value = "收入类型标识 0：电费 ；1：物业费；2：楼宇租；3：其他；4：合计")
    private String incomeType;

    @ApiModelProperty(value = "收入类型名称")
    private String incomeTypename;

    @ApiModelProperty(value = "收入金额")
    private String income;

    @ApiModelProperty(value = "去年同期收入")
    private String lastYearIncome;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(String incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getIncomeTypename() {
        return incomeTypename;
    }

    public void setIncomeTypename(String incomeTypename) {
        this.incomeTypename = incomeTypename;
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

    @Override
    public String toString() {
        return "FinanceIncomeUpdateMonthModel{" +
                "incomeDay=" + incomeMonth +
                ", incomeType='" + incomeType + '\'' +
                ", incomeTypename='" + incomeTypename + '\'' +
                ", income='" + income + '\'' +
                ", lastYearIncome='" + lastYearIncome + '\'' +
                '}';
    }
}
