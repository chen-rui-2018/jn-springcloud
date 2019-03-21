package com.jn.oa.email.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 一键Email发送状态枚举
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum EmailSendStatusEnums implements CodeAndMsg {

    NOT_SEND("1", "未发送"),
    SEND_SUCCESSFULLY("2", "发送成功"),
    SEND_FAILURE("3", "发送失败");

    private String code;

    private String message;

    EmailSendStatusEnums(String key, String message) {
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
