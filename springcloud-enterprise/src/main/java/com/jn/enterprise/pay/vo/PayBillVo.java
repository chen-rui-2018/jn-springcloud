package com.jn.enterprise.pay.vo;

import com.jn.enterprise.pay.entity.TbPayBillDetails;
import com.jn.enterprise.pay.model.PayAccountBookMoneyRecord;
import com.jn.enterprise.pay.model.PayBill;
import com.jn.enterprise.pay.model.PayBillDetails;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * 账单查询VO
 *
 * @author： wzy
 * @date： Created on 2019/5/2 16:57
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillVo" ,description = "账单查询VO")
public class PayBillVo extends PayBill implements Serializable {
    private static final long serialVersionUID = -6645256359045252226L;

    PayAccountBookMoneyRecord payAccountBookMoneyRecord;

    List<TbPayBillDetails> payBillDetails;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public PayAccountBookMoneyRecord getPayAccountBookMoneyRecord() {
        return payAccountBookMoneyRecord;
    }

    public void setPayAccountBookMoneyRecord(PayAccountBookMoneyRecord payAccountBookMoneyRecord) {
        this.payAccountBookMoneyRecord = payAccountBookMoneyRecord;
    }

    public List<TbPayBillDetails> getPayBillDetails() {
        return payBillDetails;
    }

    public void setPayBillDetails(List<TbPayBillDetails> payBillDetails) {
        this.payBillDetails = payBillDetails;
    }
}
