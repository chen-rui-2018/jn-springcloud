package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 预缴充值入參实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/20 16:53
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayPrepaidRechargeParam" ,description = "预缴充值入參实体类")
public class PayPrepaidRechargeParam implements Serializable {
    private static final long serialVersionUID = -8294086529255687999L;

    @ApiModelProperty(value = "账本编号",required = true,example = "20190504123")
    @NotBlank(message = "账本编号不能为空")
    private String acBookId;

    @ApiModelProperty(value = "支付渠道ID（WX_APP：微信APP支付，ALIPAY_MOBILE：支付宝移动支付）",required = true,example = "ALIPAY_MOBILE")
    @NotBlank(message = "支付渠道ID不能为空")
    private String channelId;

    @ApiModelProperty(value = "充值金额",required = true,example = "123.00")
    @NotBlank(message = "充值金额不能为空")
    private BigDecimal rechargeAmount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }
}
