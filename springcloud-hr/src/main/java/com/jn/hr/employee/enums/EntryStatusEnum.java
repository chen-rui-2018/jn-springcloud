package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 是否发送入职登记表
 */
public enum EntryStatusEnum implements CodeAndMsg {
    NOT_ENTRY("1", "未入职"),
    ENTRY("2", "已入职"),
    DISCARD_ENTRY("3", "放弃入职"),
    ;


    private String code;

    private String message;

    EntryStatusEnum(String code, String message) {
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
