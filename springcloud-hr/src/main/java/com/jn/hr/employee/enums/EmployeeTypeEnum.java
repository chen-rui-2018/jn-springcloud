package com.jn.hr.employee.enums;

/**
 * @author dt
 * @create 2019-04-19 下午 3:14
 */

import com.jn.common.api.CodeAndMsg;

/**
 * 员工类型（1：正式，2：实习生）
 */
public enum EmployeeTypeEnum implements CodeAndMsg {
    FORMAL("1","正式"),
    PRACTICE("2","实习生"),
    ;
    private String code;

    private String message;

    EmployeeTypeEnum(String code, String message) {
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
