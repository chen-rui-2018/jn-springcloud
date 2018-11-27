package com.jn.authorization.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 平台异常枚举
 * @Author: yangph
 * @Date: 2018/11/26 14:11
 * @Version v1.0
 * @modified By:
 */
public enum PlatformExcepitonEnum implements CodeAndMsg {
    ACCOUNT_OR_PASSWORD_UNKNOWN("1110101","用户名或密码错误")
    ;
    private String code;
    private String message;

    PlatformExcepitonEnum(String code, String message) {
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
