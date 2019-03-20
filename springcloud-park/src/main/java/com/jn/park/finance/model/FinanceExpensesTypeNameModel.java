package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/13
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceExpensesTypeNameModel",description = "打标后费用类型")

public class FinanceExpensesTypeNameModel implements Serializable {

    @ApiModelProperty("打标后费用类型ID")
    private int costAfterTypeId ;

    @ApiModelProperty("打标后费用类型名称")
    private String costAfterTypeName;


    public int getCostAfterTypeId() {
        return costAfterTypeId;
    }

    public void setCostAfterTypeId(int costAfterTypeId) {
        this.costAfterTypeId = costAfterTypeId;
    }

    public String getCostAfterTypeName() {
        return costAfterTypeName;
    }

    public void setCostAfterTypeName(String costAfterTypeName) {
        this.costAfterTypeName = costAfterTypeName;
    }
}
