package com.jn.hr.employee.enums;

/**
 * @author dt
 * @create 2019-04-19 下午 3:15
 */

import com.jn.common.api.CodeAndMsg;

/**
 * 户口类型（1：城市，2：农村）
 */
public enum RegisteredTypeEnum implements CodeAndMsg {
    CITY("1","城市"),
    COUNTRYSIDE("2","农村"),
    ;
    private String code;

    private String message;

    RegisteredTypeEnum(String code, String message) {
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
