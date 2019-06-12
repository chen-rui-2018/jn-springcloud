package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author dt
 * @create 2019-04-23 上午 10:46
 */
public enum EmployStatusEnum implements CodeAndMsg {
    ON_JOB("1","在职"),
    NOT_ON_JOB("2","医疗期"),
    JOB_3("3","退休"),
    JOB_4("4","离职"),
    RELATIONS_ENTRY_STATUS_1("1","未入职"),
    RELATIONS_ENTRY_STATUS_2("2","已入职"),
    RELATIONS_ENTRY_STATUS_3("3","放弃入职"),
    RELATIONS_ENTRY_IS_REGIST_1("1","已发送"),
    RELATIONS_ENTRY_IS_REGIST_2("2","未发送"),
    RELATIONS_SUPPLY_STATUS_1("1","待补充"),
    RELATIONS_SUPPLY_STATUS_2("2","已补充"),
    RELATIONS_STATUS_4("4","未审核")
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
