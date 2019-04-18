package com.jn.oa.multiDeptOffice.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 提醒方式枚举类
 *
 * @author： shaobao
 * @date： Created on 2019/4/14 0:06
 * @version： v1.0
 * @modified By:
 **/
public enum RemindWayEnums implements CodeAndMsg {

    WE_CHAT("1","微信"),
    MESSAGE("2","短信"),
    PC("3","PC"),
    APP("4","APP")
    ;


    private String code;

    private String message;

    RemindWayEnums(String key, String message) {
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
