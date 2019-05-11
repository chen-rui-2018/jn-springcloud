package com.jn.unionpay.paybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 统一支付枚举值
 * @Author: jiangyl
 * @Date: 2019/2/15 17:33
 * @Version v1.0
 * @modified By:
 */
public enum PayBillEnum implements CodeAndMsg {
    BILL_STATE_NOT_DELETE("1","数据有效"),
    BILL_ORDER_PAY_CHECKED("4","支付已确认"),
    BILL_ORDER_IS_NOT_PAY("1","账单/订单状态：待支付"),
    BILL_ORDER_IS_PAY("2","账单/订单状态：已支付"),
    BILL_ORDER_CANCEL_PAY("-1","订单状态：取消支付"),
    BILL_OBJ_TYPE_IS_COMPANY("1","缴费对象：1企业"),
    BILL_OBJ_TYPE_IS_INDIVIDUAL("2","缴费对象：2个人"),
    PAY_METHOD_ONLINE("10","支付方式：10线上"),
    PAY_METHOD_OFFLINE("11","支付方式：11线下"),
    REMIND_IS_NOT_CHECK("0","核对单状态 0未审核"),
    PAYMENT_CODE_TYPE_BILL("1","数据字典类型 1账单"),
    PAYMENT_ORDER_IS_DELETE("0","订单已删除"),
    PAYMENT_BILL_IS_DELETE("9","账单已删除"),

    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PayBillEnum(String code, String message) {
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
