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
@ApiModel(value = "FinanceIncomeGetDaysModel",description = "获取每天的收入")
public class FinanceIncomeGetDaysModel implements Serializable {

    private static final long serialVersionUID = -4135271981608382871L;

    @ApiModelProperty(value = "费用日期")
    private Date incomeDay;

    @ApiModelProperty(value = "收入类型标识 0：电费 ；1：物业费；2：楼宇租；3：其他；4：合计")
    private String incomeType;

    @ApiModelProperty(value = "收入类型名称")
    private String incomeTypename;

    @ApiModelProperty(value = "收入金额")
    private String income;

    @ApiModelProperty(value = "创建人")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date creatorTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getIncomeDay() {
        return incomeDay;
    }

    public void setIncomeDay(Date incomeDay) {
        this.incomeDay = incomeDay;
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatorTime() {
        return creatorTime;
    }

    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }


    @Override
    public String toString() {
        return "FinanceIncomeGetDaysModel{" +
                "incomeDay=" + incomeDay +
                ", incomeType='" + incomeType + '\'' +
                ", incomeTypename='" + incomeTypename + '\'' +
                ", income='" + income + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", creatorTime=" + creatorTime +
                '}';
    }
}
