package com.jn.paybill.model;

import com.esotericsoftware.kryo.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付回调响应结果
 * @author： jiangyl
 * @date： Created on 2019/3/14 9:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayCallBackParam", description = "支付回调响应入参")
public class PayCallBackParam implements Serializable {
    @ApiModelProperty(value = "订单ID",required = true,example = "5cd80d8624f14737abcc7eda4c0675b8")
    @NotBlank(message = "订单ID不能为空！")
    private String orderId;
    @ApiModelProperty(value = "支付状态[2已支付3支付失败]",required = true,example = "2")
    @NotBlank(message = "支付状态不能为空！")
    private String payStatus;
    @ApiModelProperty(value = "支付时间")
    private Date payTime;
    @ApiModelProperty(value = "支付平台订单ID",required = true,example = "21314737abcc7eda4c0675b8")
    @NotBlank(message = "支付平台订单ID不能为空")
    private String payOrderId;
    @ApiModelProperty(value = "支付方式[0微信1支付宝2银联]",example = "0")
    private String payType;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
