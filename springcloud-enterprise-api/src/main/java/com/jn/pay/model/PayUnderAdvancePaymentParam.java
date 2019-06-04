package com.jn.pay.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 线下预缴充值实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/31 17:11
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayUnderAdvancePaymentParam" ,description = "线下预缴充值实体类")
public class PayUnderAdvancePaymentParam implements Serializable {

    private static final long serialVersionUID = -5201638484218023843L;

    @ApiModelProperty(value="账本ID",example = "20190504124")
    private String acBookId;

    @ApiModelProperty(value="充值金额",example = "12.3")
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

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }
}
