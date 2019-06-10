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
    BILL_IS_EXIT("6020541","账单已存在"),
    BILL_ACCOUNT_EXIT("6020507","账户已存在"),
    BILL_ORDER_IS_NOT_EXIT("6020508","支付账单创建异常，请稍后重试"),
    COMMIT_AMOUNT_NOT_EQUAL_BILL_AMOUNT("6020509","提交金额不等于账单金额"),
    PAYMENT_STATUS_IS_PAY("6020516","账单已支付，无需再次支付。"),
    BILL_PAY_ORDER_IS_NOT_EXIT("6020521","支付账单不存在。"),
    BILL_PAY_ORDER_MISMATCH("6020522","选择账单与查询支付账单不匹配。"),
    BILL_TYPE_IS_NOT_NULL("6020525","账单类型不能为空"),
    BILL_TYPE_IDENTICAL("6020526","账单类型需一致"),
    BILL_CALLBACK_IS_NULL("6020527","支付回调参数为空"),
    BILL_CALLBACK_ID_IS_NULL("6020528","支付回调参数订单ID为空"),
    BILL_BOOK_IS_NOT_EXIT("6020529","账本查询异常或不存在"),
    BILL_QUERY_ERROR("6020530","账单查询异常"),
    BILL_DEDUCTION_FEE_ERROR("6020531","账单扣费异常"),
    QUERY_ENTERPRISE_INFO_ERROR("6020532","查询企业信息异常"),
    BILL_ACCOUNT_IS_NOT_EXIT("6020533","账户查询异常或不存在"),
    CALL_PAYMENT_EXIT("6020534","调用支付发起接口异常"),
    BILL_MIDDLE_IS_NOT_EXIT("6020535","统一缴费下单号不存在"),
    BILL_BOOK_ADD_ERROR("6020536","新增账本金额&插入流水记录异常"),
    BILL_BOOK_REMOVE_ERROR("6020537","扣除账本金额&插入流水记录异常"),
    BILL_ACCOUNT_NOT_EXIT("6020538","当前登录用户与账单所属用户不一致"),
    PAYMENT_STATUS_IS_PAY_REMIND("6020539","账单已支付，无需核对提醒"),
    PAYMENT_REMIND_IS_SEND_OUT("6020540","已发送核对提醒，无需重复发送"),
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
