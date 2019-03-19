package com.jn.paybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： jiangyl
 * @date： Created on 2019/6/12 10:64
 * @version： v1.0
 * @modified By:
 */
public enum PayBillExceptionEnum implements CodeAndMsg {
    NETWORK_ANOMALY("6020901", "网络异常，请稍后重试。"),
    TIME_CONVERSION_ERROR("6020501","时间格式错误，应为：'yyyy-MM-dd HH:mm:ss'"),
    BILL_CREATE_REPLY_ERROR("6020502","账单创建响应错误,请稍后重试"),
    BILL_ID_OR_NUM_IS_NOT_NULL("6020503","账单标识或账单编号不能为空"),
    START_TIME_NOT_AFTER_END_TIME("6020504","结束时间不能少于开始时间"),
    BILL_ID_IS_NOT_NULL("6020505","账单标识不能为空"),
    BILL_STATUS_IS_NOT_NULL("60205014","账单状态不能为空"),
    BILL_IS_NOT_EXIT("6020506","账单不存在"),
    BILL_PAY_ORDER_CREATE_ERROR("6020507","支付订单创建异常，请稍后重试"),
    BILL_ORDER_IS_NOT_EXIT("6020508","支付订单创建异常，请稍后重试"),
    COMMIT_AMOUNT_NOT_EQUAL_BILL_AMOUNT("6020509","提交金额不等于账单金额"),
    CHECK_ORDER_EXIST_CHECKED_BILL("6020510","提交审核数据中包含审核通过账单，请移除审核通过项"),
    PAY_REMIND_IS_NOT_EXIT("6020511","核对单数据不存在，请核实数据"),
    PAYMENT_REMIND_ID_IS_NOT_NULL("6020512","支付核对单ID不能为空"),
    PAYMENT_REMIND_IS_NOT_WAIT_CHECK("6020513","支付核对单已审核，无需再次审核。"),
    PAYMENT_STATUS_IS_NOT_CHECK("6020515","账单状态不为待审核，无需处理数据。"),
    ;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PayBillExceptionEnum(String code, String message) {
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
