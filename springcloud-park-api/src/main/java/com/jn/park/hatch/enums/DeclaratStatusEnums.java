package com.jn.park.hatch.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： wzy
 * @date： Created on 2019/4/10 17:50
 * @version： v1.0
 * @modified By:
 */
public enum DeclaratStatusEnums implements CodeAndMsg {
    DRAFT("1", "草稿"),
    RELEASE("2", "发布"),
    LOWERSHELF("3","下架");

    private String code;

    private String message;

    DeclaratStatusEnums(String key, String message) {
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
