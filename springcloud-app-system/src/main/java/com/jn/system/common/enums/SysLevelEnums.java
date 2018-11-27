package com.jn.system.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 层级枚举类
 *
 * @author： yuanyy
 * @date： Created on 2018/11/22 15:22
 * @version： v1.0
 * @modified By:
 */
public enum SysLevelEnums implements CodeAndMsg {

    FIRST_LEVEL("1","第一层级");

    private String code;

    private String message;

    SysLevelEnums(String key, String message) {
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
