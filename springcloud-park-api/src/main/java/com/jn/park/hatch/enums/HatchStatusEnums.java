package com.jn.park.hatch.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 孵化企业状态枚举
 *
 * @author： wzy
 * @date： Created on 2019/4/17 16:05
 * @version： v1.0
 * @modified By:
 */
public enum HatchStatusEnums implements CodeAndMsg {
    EFFECTIVE("1", "正常"),
    DELETED("0","删除");

    private String code;

    private String message;

    HatchStatusEnums(String code, String message) {
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

