package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author dt
 * @create 2019-04-23 上午 11:24
 */
public enum EmploySexEnum implements CodeAndMsg {
    MAIL("1","男"),
    FEMAIL("2","女"),
    ;
    private String code;

    private String message;

    EmploySexEnum(String code, String message) {
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
