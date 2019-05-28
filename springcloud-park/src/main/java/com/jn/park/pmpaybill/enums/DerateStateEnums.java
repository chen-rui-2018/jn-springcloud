package com.jn.park.pmpaybill.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 物业缴费减免状态枚举
 *
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum DerateStateEnums implements CodeAndMsg {
    NO_RELIEF("0", "未减免"),
    RELIEFED("1", "已减免"),
    NOT_RELIEF("2", "无需减免"),
    ;

    private String code;

    private String message;

    DerateStateEnums(String key, String message) {
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
