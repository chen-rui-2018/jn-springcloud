package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 支付回调响应结果
 * @author： jiangyl
 * @date： Created on 2019/3/14 9:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayCallBackVO", description = "支付回调响应")
public class PayCallBackVO implements Serializable {
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
