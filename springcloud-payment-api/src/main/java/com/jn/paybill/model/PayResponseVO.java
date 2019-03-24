package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 支付发起响应结果
 * @author： jiangyl
 * @date： Created on 2019/3/14 9:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayResponseVO", description = "支付发起响应")
public class PayResponseVO implements Serializable {
    @ApiModelProperty(value = "支付订单ID")
    private String payOrderId;
    @ApiModelProperty(value = "支付发起响应状态")
    private String responseStatus;
    @ApiModelProperty(value = "支付链接")
    private String payUrl;
    @ApiModelProperty(value = "支付发起响应备注")
    private String remark;

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
