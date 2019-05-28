package com.jn.enterprise.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 统一支付枚举值
 * @Author: wzy
 * @Date: 2019/5/7 17:33
 * @Version v1.0
 * @modified By:
 */
public enum PaymentBillEnum implements CodeAndMsg {
    BILL_STATE_NOT_DELETE("1","数据有效"),
    BILL_STATE_DELETE("0","数据无效"),
    BILL_ORDER_PAY_CHECKED("4","支付已确认"),
    BILL_ORDER_IS_PAY("1","账单/订单状态：已支付"),
    BILL_ORDER_IS_NOT_PAY("2","账单/订单状态：待支付"),
    BILL_ORDER_CANCEL_PAY("-1","订单状态：取消支付"),
    BILL_OBJ_TYPE_IS_COMPANY("1","缴费对象：1企业"),
    BILL_OBJ_TYPE_IS_INDIVIDUAL("2","缴费对象：2个人"),
    PAY_METHOD_ONLINE("1","支付平台类型：线上"),
    PAY_METHOD_OFFLINE("2","支付平台类型：线下"),
    PAY_REMINDER_NUMBER("0","催缴次数默认为0"),
    BILL_AC_BOOK_CHECK_1("1","缴费已确认"),
    BILL_AC_BOOK_CHECK_2("2","缴费未确认"),
    BILL_ACCOUNT_BOOK_RECHARGE("1","充值"),
    BILL_ACCOUNT_BOOK_FEE("2","扣费"),
    BILL_AC_BOOK_TYPE_1("1","电费账单"),
    BILL_AC_BOOK_TYPE_2("2","物业费账单"),
    BILL_AC_BOOK_TYPE_3("3","维修费账单"),
    BILL_AC_BOOK_TYPE_4("4","房租费账单"),
    BILL_AC_BOOK_TYPE_5("5","物品租赁费账单"),
    BILL_AC_BOOK_TYPE_6("6","停车费账单"),
    BILL_AC_BOOK_TYPE_7("7","车位费账单"),
    BILL_AC_BOOK_TYPE_8("8","水费账单"),
    BILL_AC_BOOK_TYPE_9("9","宣传费账单"),
    BILL_AC_BOOK_TYPE_10("10","体检费账单"),
    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PaymentBillEnum(String code, String message) {
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
