package com.jn.pay.vo;

import com.jn.pay.model.PayAccountBook;
import com.jn.pay.model.PayAccountBookMoneyRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 我的账本明细组合实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/21 11:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookMoneyRecordVo" ,description = "我的账本明细组合实体类")
public class PayAccountBookMoneyRecordVo extends PayAccountBookMoneyRecord implements Serializable {

    @ApiModelProperty(value="支付状态（如 1：已支付、2：待支付）")
    private String paymentState;

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }
}
