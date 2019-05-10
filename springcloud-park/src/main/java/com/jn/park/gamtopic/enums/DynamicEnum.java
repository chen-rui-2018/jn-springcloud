package com.jn.park.gamtopic.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/5/8 21:25
 * @version： v1.0
 * @modified By:
 */

public enum DynamicEnum implements CodeAndMsg {
    IS_SELF("1","属于自己发布的动态"),
    NOT_IS_SELF("0","不属于自己所发布的动态");

    private String code;
    private String message;
    DynamicEnum(String code, String message){
        this.code= code;
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
