package com.jn.hr.employee.enums;

/**
 * @author dt
 * @create 2019-04-19 下午 3:15
 */

import com.jn.common.api.CodeAndMsg;

/**
 * 婚姻状态（1：未婚，2：已婚）
 */
public enum MaritalStatusEnum implements CodeAndMsg {
    NOT_MARRY("1","未婚"),
    MARRY("2","已婚"),
    ;
    private String code;

    private String message;

    MaritalStatusEnum(String code, String message) {
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
