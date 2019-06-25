package com.jn.pay.vo;

import com.jn.pay.model.PayBill;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 账单详情查询VO
 *
 * @author： wzy
 * @date： Created on 2019/5/2 16:57
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillParamVo" ,description = "账单详情查询VO")
public class PayBillParamVo extends PayBill implements Serializable {
    private static final long serialVersionUID = -6645256359045252226L;

    @ApiModelProperty(value="缴费类型")
    private String payType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
