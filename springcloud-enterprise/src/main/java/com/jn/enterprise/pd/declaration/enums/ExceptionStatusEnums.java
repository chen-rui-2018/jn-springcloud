package com.jn.enterprise.pd.declaration.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 异常状态枚举
 *
 * @author： wzy
 * @date： Created on 2019/4/15 15:23
 * @version： v1.0
 * @modified By:
 */
public enum ExceptionStatusEnums implements CodeAndMsg {

    NOTICE_ID_NOT_NULL("5011301", "公告ID不能为空");

    private String code;

    private String message;

    ExceptionStatusEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
