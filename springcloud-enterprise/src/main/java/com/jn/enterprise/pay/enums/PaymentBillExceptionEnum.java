package com.jn.enterprise.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： wzy
 * @Date: 2019/5/7 17:33
 * @version： v1.0
 * @modified By:
 */
public enum PaymentBillExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("6020901", "网络异常，请稍后重试。"),
    TIME_CONVERSION_ERROR("6020501","时间格式错误，应为：'yyyy-MM-dd HH:mm:ss'"),
    BILL_CREATE_REPLY_ERROR("6020502","账单创建响应错误,请稍后重试"),
    BILL_ID_OR_NUM_IS_NOT_NULL("6020503","账单标识或账单编号不能为空"),
    START_TIME_NOT_AFTER_END_TIME("6020504","结束时间不能少于开始时间"),
    BILL_ID_IS_NOT_NULL("6020505","账单标识不能为空"),
    BILL_STATUS_IS_NOT_NULL("60205014","账单状态不能为空"),
    BILL_IS_NOT_EXIT("6020506","账单不存在"),
    BILL_PAY_ORDER_CREATE_ERROR("6020507","支付账单创建异常，请稍后重试"),
    BILL_ORDER_IS_NOT_EXIT("6020508","支付账单创建异常，请稍后重试"),
    COMMIT_AMOUNT_NOT_EQUAL_BILL_AMOUNT("6020509","提交金额不等于账单金额"),
    PAYMENT_STATUS_IS_PAY("6020516","账单已支付，无需再次支付。"),
    BILL_PAY_ORDER_IS_NOT_EXIT("6020521","支付账单不存在。"),
    BILL_TYPE_IS_NOT_NULL("6020525","账单类型不能为空"),
    BILL_TYPE_IDENTICAL("6020526","账单类型需一致"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PaymentBillExceptionEnum(String code, String message) {
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
