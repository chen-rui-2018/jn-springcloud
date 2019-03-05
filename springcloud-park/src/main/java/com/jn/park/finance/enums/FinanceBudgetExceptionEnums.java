package com.jn.park.finance.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 预算录入异常枚举类
 * @author： huangbq
 * @date： Created on 2019/3/5 1:30
 * @version： v1.0
 * @modified By:
 */
public enum  FinanceBudgetExceptionEnums implements CodeAndMsg {
    UN_KNOW("5000500","业务提醒");
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    FinanceBudgetExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
