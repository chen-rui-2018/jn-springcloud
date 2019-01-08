package com.jn.send.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 延迟消息服务异常
 *
 * @author： fengxh
 * @date： Created on 2019/01/6 15:28
 * @version： v1.0
 * @modified By:
 */
public enum DelayStreamExceptionEnum implements CodeAndMsg {

    DATE_NOT_NULL("1800101", "延迟日期不能为空"),
    DATE_FORMAT_FAIL("1800102", "日期格式有误"),
    DATE_NOT_LETTER_NOW("1800103", "延迟消息不能小于当前时间");


    private String code;
    private String message;

    DelayStreamExceptionEnum(String code, String message) {
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
