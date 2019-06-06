package com.jn.park.asset.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
* 缴费单参数
* @author： zhuyz
* @date： Created on 2019/5/31 19:41
* @version： v1.0
* @modified By:
*/
@ApiModel(value = "BillParam",description = "缴费单参数")
public class BillParam implements Serializable {

    @ApiModelProperty("缴费单id")
    private String billIds;

    public String getBillIds() {
        return billIds;
    }

    public void setBillIds(String billIds) {
        this.billIds = billIds;
    }
}
