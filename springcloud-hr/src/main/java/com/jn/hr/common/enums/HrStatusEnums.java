package com.jn.hr.common.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum HrStatusEnums implements CodeAndMsg {
    EFFECTIVE("1", "有效"),
    INVALID("2", "失效"),
    DELETED("0","已删除"),
	NOTDELETED("1","未删除");

    private String code;

    private String message;

    HrStatusEnums(String key, String message) {
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
