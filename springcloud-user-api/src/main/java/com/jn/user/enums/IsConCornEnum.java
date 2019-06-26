package com.jn.user.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @Author: yangph
 * @Date: 2019/6/25 21:01
 * @Version v1.0
 * @modified By:
 */
public enum IsConCornEnum implements CodeAndMsg {
    CORN("1","关注"),
    CANCEL_CORN("0","取消关注"),
    ;
    private String code;
    private String message;

    IsConCornEnum(String code, String message) {
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
