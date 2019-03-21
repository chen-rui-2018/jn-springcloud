package com.jn.park.finance.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 支出录入异常枚举类
 * @author： tangry
 * @date： Created on 2019/3/12
 * @version： v1.0
 * @modified By:
 */
public enum FinanceExceptionEnums implements CodeAndMsg {
    UN_KNOW("5000600","业务提醒");
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

    FinanceExceptionEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
