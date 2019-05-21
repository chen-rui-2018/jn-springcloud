package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author dt
 * @create 2019-04-23 上午 10:46
 */
public enum EmployStatusEnum implements CodeAndMsg {
    ON_JOB("1","在职"),
    NOT_ON_JOB("2","医疗期"),
    ;
    private String code;

    private String message;

    EmployStatusEnum(String code, String message) {
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
