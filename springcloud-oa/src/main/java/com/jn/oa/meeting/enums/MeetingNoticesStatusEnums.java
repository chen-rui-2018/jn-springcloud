package com.jn.oa.meeting.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum MeetingNoticesStatusEnums implements CodeAndMsg {

    NO_NOTIFICATION("0", "未通知"),
    HAVE_INFORMED("1", "已经通知")
    ;


    private String code;

    private String message;

    MeetingNoticesStatusEnums(String key, String message) {
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
