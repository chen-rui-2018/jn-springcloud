package com.jn.hr.employee.enums;

/**
 * @author dt
 * @create 2019-04-19 下午 3:15
 */

import com.jn.common.api.CodeAndMsg;

/**
 * 政治面貌（1：党员，2：团员，3：其他）
 */
public enum PoliticalOutlookEnum implements CodeAndMsg {
    PARTYMEMBERS("1","党员"),
    LEAGUEMEMBERS("2","团员"),
    OTHER("3","其他"),
    ;
    private String code;

    private String message;

    PoliticalOutlookEnum(String code, String message) {
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
