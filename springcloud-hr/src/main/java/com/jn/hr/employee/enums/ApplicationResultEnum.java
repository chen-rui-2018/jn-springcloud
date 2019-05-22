package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 应聘结果（1：通过，2：淘汰，3：等待结果）
 * @author dt
 * @create 2019-04-15 下午 3:57
 */
public enum ApplicationResultEnum implements CodeAndMsg {

    PASS("1", "通过"),
    NOT_PASS("2", "淘汰"),
    WAIT("3", "等待结果"),
    ;


    private String code;

    private String message;

    ApplicationResultEnum(String code, String message) {
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
