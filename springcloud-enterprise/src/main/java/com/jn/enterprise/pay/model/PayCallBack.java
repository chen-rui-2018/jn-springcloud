package com.jn.enterprise.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 支付回调响应结果
 * @author： wzy
 * @date： Created on 2019/5/7 9:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayCallBack", description = "支付回调响应")
public class PayCallBack implements Serializable {
    @ApiModelProperty(value = "订单ID")
    private String orderId;
    @ApiModelProperty(value = "处理状态")
    private String respStatus;
    @ApiModelProperty(value = "处理成功时间")
    private String respTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRespStatus() {
        return respStatus;
    }

    public void setRespStatus(String respStatus) {
        this.respStatus = respStatus;
    }

    public String getRespTime() {
        return respTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }
}
