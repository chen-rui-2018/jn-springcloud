package com.jn.enterprise.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 支付行为枚举值
 * @Author: wzy
 * @Date: 2019/5/7 17:33
 * @Version v1.0
 * @modified By:
 */
public enum PaymentBillActionEnum implements CodeAndMsg {
    BILL_STATE_MANUAL("1","手动支付"),
    BILL_STATE_AUYTO("2","自动付款"),
    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PaymentBillActionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
