package com.jn.enterprise.pay.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 账本枚举值
 * @Author: wzy
 * @Date: 2019/5/7 17:33
 * @Version v1.0
 * @modified By:
 */
public enum PayAccountBookEnum implements CodeAndMsg {
    ACCOUNT_BOOK_NOT_AUTO("0","不开通自动付款"),
    ACCOUNT_BOOK_AUTO("1","开通自动付款"),
    ACCOUNT_BOOK_NOT_RECHARGE("0","不可充值"),
    ACCOUNT_BOOK_RECHARGE("1","可充值"),
    ACCOUNT_BOOK_IS_SHOW("2","显示"),
    ACCOUNT_BOOK_IS_NOT_SHOW("1","隐藏"),
    ;


    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    PayAccountBookEnum(String code, String message) {
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
