package com.jn.im.enums;


import com.jn.common.api.CodeAndMsg;

/**
 * ImExceptionEnums
 *
 * @author： shenph
 * @date： Created on 2019/5/9 19:53
 * @version： v1.0
 * @modified By:
 */
public enum ImExceptionEnums implements CodeAndMsg {

    IM_SEND_CODE("0000", "IM推送发送人消息成功"),
    IM_RECEIVE_CODE("1111", "IM推送接收人消息成功"),
    IM_ERROR("9999", "IM发送消息失败");

    private String code;
    private String message;

    ImExceptionEnums(String code, String message) {
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
