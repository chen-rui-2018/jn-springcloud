package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 回调各业务侧接口入參实体类
 *
 * @author： wzy
 * @date： Created on 2019/6/14 15:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayCallbackServiceSideParam" ,description = "回调各业务侧接口入參实体类")
public class PayCallbackServiceSideParam implements Serializable {
    private static final long serialVersionUID = 8625847482864385473L;

    @ApiModelProperty(value="账单编号",example = "201905090000003")
    private String billId;

    @ApiModelProperty(value="账单类型【ELECTRIC:电费，PROPERTY:物业费，REPAIR:维修费，ROOM_LEASE:房租费，GOODS_LEASE:物品租赁费，TEMPORARY_PARKING:停车费，PARKING_LEASE:车位费，WATER:水费，PROMOTION:宣传费，HEALTH:体检费】",example = "ELECTRIC")
    private String acBookType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType;
    }

    @Override
    public String toString() {
        return "PayCallbackServiceSideParam{" +
                "billId='" + billId + '\'' +
                ", acBookType='" + acBookType + '\'' +
                '}';
    }
}
