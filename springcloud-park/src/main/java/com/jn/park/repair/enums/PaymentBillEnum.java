package com.jn.park.repair.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 缴费单的支付状态
 *
 * @author： yuanyy
 * @date： Created on 2019/5/15 20:42
 * @version： v1.0
 * @modified By:
 */
public enum PaymentBillEnum implements CodeAndMsg {
    BILL_ORDER_IS_PAY("1","账单/订单状态：已支付"),
    BILL_ORDER_IS_NOT_PAY("2","账单/订单状态：待支付");

    private String code;

    private String message;

    PaymentBillEnum(String key, String message) {
        this.code = key;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
