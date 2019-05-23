package com.jn.oa.schedule.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 日程是否提醒枚举
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 17:02
 * @version： v1.0
 * @modified By:
 **/
public enum ScheduleRemindEnums implements CodeAndMsg {
    YES("1","是"),
    NO("0","否")
    ;
    private String code;

    private String message;

    ScheduleRemindEnums(String key, String message) {
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
