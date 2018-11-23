package com.jn.system.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum SysStatusEnums implements CodeAndMsg {
    EFFECTIVE("1", "有效"),
    INVALID("0", "失效"),
    DELETED("-1","已删除");

    private String code;

    private String message;

    SysStatusEnums(String key, String message) {
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
