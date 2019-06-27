package com.jn.enterprise.pd.declaration.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 公告推送状态枚举
 *
 * @author： wzy
 * @date： Created on 2019/4/17 16:05
 * @version： v1.0
 * @modified By:
 */
public enum PushEnums implements CodeAndMsg {
    PUSH_SMS("1", "短信推送"),
    PUSH_EMAIL("2","邮件推送"),
    PUSH_WX("3","微信推送"),
    PUSH_APP("4","APP推送")
    ;

    private String code;

    private String message;

    PushEnums(String code, String message) {
        this.code = code;
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

