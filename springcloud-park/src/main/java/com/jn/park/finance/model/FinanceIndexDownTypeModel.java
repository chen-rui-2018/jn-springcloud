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
@ApiModel(value = "FinanceIndexDownTypeModel",description = "类别下拉框选项")

public class FinanceIndexDownTypeModel implements Serializable {

    @ApiModelProperty("财务项目ID")
    private int financeId;

    @ApiModelProperty("财务项目名称")
    private String financeName;


    public int getFinanceId() {
        return financeId;
    }

    public void setFinanceId(int financeId) {
        this.financeId = financeId;
    }

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    @Override
    public String toString() {
        return "FinanceIndexDownTypeModel{" +
                "financeId=" + financeId +
                ", financeName='" + financeName + '\'' +
                '}';
    }
}
