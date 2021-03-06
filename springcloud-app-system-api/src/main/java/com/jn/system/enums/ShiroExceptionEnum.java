package com.jn.system.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * shiro的异常枚举
 *
 * @author： fengxh
 * @date： Created on 2018/10/30 10:07
 * @version： v1.0
 * @modified By: shenph
 */
public enum ShiroExceptionEnum implements CodeAndMsg {

    UNKNOWN_ACCOUNT("1110101", "帐号不存在"),
    UNKNOWN_PASSWORD("1110102", "帐号或密码错误"),
    UNKNOWN_EFFECTIVE("1110103", "帐号无效");

    private String code;
    private String message;

    ShiroExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
