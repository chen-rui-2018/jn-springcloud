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
@ApiModel(value ="FinanceSaveExpensesMonthModel",description = "从记录表保存数据到月表中")
public class FinanceSaveExpensesMonthModel implements Serializable {


    private static final long serialVersionUID = 1669453624178855303L;

    @ApiModelProperty(value = "日期")
    private String  costHappendTime;

    @ApiModelProperty(value = "金额")
    private String  cost;

    @ApiModelProperty(value = "打标类型ID")
    private String  costAfterTypeId;

    @ApiModelProperty(value = "打标类型名称")
    private String  costAfterTypeName;

    @ApiModelProperty(value = "部门ID")
    private String  departmentId;

    @ApiModelProperty(value = "部门名称")
    private String  departmentName;

    @ApiModelProperty(value = "创建人")
    private String  creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCostHappendTime() {
        return costHappendTime;
    }

    public void setCostHappendTime(String costHappendTime) {
        this.costHappendTime = costHappendTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostAfterTypeId() {
        return costAfterTypeId;
    }

    public void setCostAfterTypeId(String costAfterTypeId) {
        this.costAfterTypeId = costAfterTypeId;
    }

    public String getCostAfterTypeName() {
        return costAfterTypeName;
    }

    public void setCostAfterTypeName(String costAfterTypeName) {
        this.costAfterTypeName = costAfterTypeName;
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    @Override
    public String toString() {
        return "FinanceSaveExpensesMonthModel{" +
                "costHappendTime='" + costHappendTime + '\'' +
                ", cost='" + cost + '\'' +
                ", costAfterTypeId='" + costAfterTypeId + '\'' +
                ", costAfterTypeName='" + costAfterTypeName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
