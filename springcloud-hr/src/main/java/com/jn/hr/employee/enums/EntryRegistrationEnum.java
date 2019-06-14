package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 是否发送入职登记表
 */
public enum EntryRegistrationEnum implements CodeAndMsg {
    SEND("1", "已发送"),
    NOT_SEND("2", "未发送"),
    NONE("3", "无"),
    ;


    private String code;

    private String message;

    EntryRegistrationEnum(String code, String message) {
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
