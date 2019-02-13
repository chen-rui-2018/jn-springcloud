package com.jn.oa.notice.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum RecoreStatusEnums implements CodeAndMsg {
    EFFECTIVE("1", "有效"),
    INVALID("2", "失效"),
    DELETED("0", "已删除");

    private String code;

    private String message;

    RecoreStatusEnums(String key, String message) {
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
