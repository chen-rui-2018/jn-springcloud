package com.jn.oa.meeting.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum OaMeetingNoticesTemplateEnums implements CodeAndMsg {

    MESSAGE_TEMPLATE("1001", "会议通知短信模板");


    private String code;

    private String message;

    OaMeetingNoticesTemplateEnums(String key, String message) {
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
