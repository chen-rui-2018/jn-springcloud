package com.jn.oa.email.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 一键Email是否定时状态枚举
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum EmailIsDelayEnums implements CodeAndMsg {

    YES("1", "是"),
    NO("0", "否");

    private String code;

    private String message;

    EmailIsDelayEnums(String key, String message) {
        this.code = key;
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
