package com.jn.system.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 用户状态
 *
 * @author： shenph
 * @date： Created on 2018/10/30 10:07
 * @version： v1.0
 * @modified By:
 */
public enum ShiroUserEnum implements CodeAndMsg {

    ACCOUNT_EFFECTIVE("1", "有效");

    private String code;
    private String message;

    ShiroUserEnum(String code, String message) {
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
