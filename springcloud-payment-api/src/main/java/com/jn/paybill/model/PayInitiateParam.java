package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/14 10:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayInitiateParam", description = "支付发起参数")
public class PayInitiateParam implements Serializable {

    @ApiModelProperty(value = "账单ID[数组]")
    @NotNull(message = "账单ID[数组]不能为空")
    private String[] billIds;

    @NotNull(message = "支付方式不能为空")
    @Pattern(regexp = "^[012]$", message = "{payMenthed:'支付方式只能为[0、1、2]'}")
    @ApiModelProperty(value = "支付方式[暂定：0微信1支付宝2银联]")
    private String payMenthed;

    public String[] getBillIds() {
        return billIds;
    }

    public void setBillIds(String[] billIds) {
        this.billIds = billIds;
    }

    public String getPayMenthed() {
        return payMenthed;
    }

    public void setPayMenthed(String payMenthed) {
        this.payMenthed = payMenthed;
    }

}
