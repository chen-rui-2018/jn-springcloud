package com.jn.enterprise.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付回调响应结果
 * @author： wzy
 * @date： Created on 2019/5/7 9:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayCallBackParam", description = "支付回调响应入参")
public class PayCallBackParam implements Serializable {
    @ApiModelProperty(value = "支付订单号",required = true,example = "5cd80d8624f14737abcc7eda4c0675b8")
    @NotBlank(message = "支付订单号不能为空！")
    private String payOrderId;

    @ApiModelProperty(value = "商户ID",required = true,example = "5cd80d8624f14737abcc7eda4c0675b8")
    @NotBlank(message = "商户ID不能为空！")
    private String mchId;

    @ApiModelProperty(value = "商户订单号",required = true,example = "5cd80d8624f14737abcc7eda4c0675b8")
    @NotBlank(message = "商户订单号不能为空！")
    private String mchOrderNo;

    @ApiModelProperty(value = "渠道ID",required = true,example = "5cd80d8624f14737abcc7eda4c0675b8")
    @NotBlank(message = "渠道ID不能为空！")
    private String channelId;

    @ApiModelProperty(value = "支付金额",required = true,example = "5cd80d8624f14737abcc7eda4c0675b8")
    @NotBlank(message = "支付金额不能为空！")
    private Long amount;

    @ApiModelProperty(value = "状态",required = true,example = "5cd80d8624f14737abcc7eda4c0675b8")
    @NotBlank(message = "状态不能为空！")
    private String status;


}
