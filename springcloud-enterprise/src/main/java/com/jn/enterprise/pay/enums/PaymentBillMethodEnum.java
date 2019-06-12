package com.jn.enterprise.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 付款方式枚举值
 * @Author: wzy
 * @Date: 2019/5/7 17:33
 * @Version v1.0
 * @modified By:
 */
public enum PaymentBillMethodEnum implements CodeAndMsg {
    BILL_STATE_QIAN_BAO("QIAN_BAO","1"),
    BILL_STATE_WX_("WX","2"),
    BILL_STATE_ALIPAY_("ALIPAY","3"),
    BILL_STATE_UNDER("5","线下支付"),
    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PaymentBillMethodEnum(String code, String message) {
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
