package com.jn.hr.employee.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 是否完成背景调查
 * @author dt
 * @create 2019-04-15 下午 3:51
 */
public enum BackgroundInvestEnum implements CodeAndMsg {
    YES("1", "是"),
    NO("2", "否"),
    ;
    private String code;

    private String message;

    BackgroundInvestEnum(String code, String message) {
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
