package com.jn.pay.vo;

import com.jn.pay.model.PayBill;
import com.jn.pay.model.PayBillDetails;
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
@ApiModel(value = "PayBillDetailsVo" ,description = "账单详情查询VO")
public class PayBillDetailsVo implements Serializable {
    private static final long serialVersionUID = -664525635904525226L;

    @ApiModelProperty(value="账单基础信息")
    private PayBill payBill;

    @ApiModelProperty(value="账单详情信息")
    private List<PayBillDetails> payBillDetails;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public PayBill getPayBill() {
        return payBill;
    }

    public void setPayBill(PayBill payBill) {
        this.payBill = payBill;
    }

    public List<PayBillDetails> getPayBillDetails() {
        return payBillDetails;
    }

    public void setPayBillDetails(List<PayBillDetails> payBillDetails) {
        this.payBillDetails = payBillDetails;
    }
}
