package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="FinanceBudgetHistoryModel",description = "预算录入历史记录通信类")
public class FinanceBudgetHistoryModel implements Serializable {

    private static final long serialVersionUID = -5422189870286665253L;

    @ApiModelProperty("费用类型ID")
    private Integer costTypeId;

    @ApiModelProperty("费用类型名称")
    private String costTypeName;

    @ApiModelProperty("部门")
    private String departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("数据月份")
    private String budgetMonth;

    @ApiModelProperty("预算金额")
    private BigDecimal budgetMoney;

    @ApiModelProperty("预算类型 0：年初预算 1：临时预算")
    private Byte budgetType;

    @ApiModelProperty("创建者账号")
    private String creatorAccount;

    public Integer getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(Integer costTypeId) {
        this.costTypeId = costTypeId;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBudgetMonth() {
        return budgetMonth;
    }

    public void setBudgetMonth(String budgetMonth) {
        this.budgetMonth = budgetMonth;
    }

    public BigDecimal getBudgetMoney() {
        return budgetMoney;
    }

    public void setBudgetMoney(BigDecimal budgetMoney) {
        this.budgetMoney = budgetMoney;
    }

    public Byte getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(Byte budgetType) {
        this.budgetType = budgetType;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }
}
