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
    BILL_IS_NOT_EXIT("6020506","账单不存在"),
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
