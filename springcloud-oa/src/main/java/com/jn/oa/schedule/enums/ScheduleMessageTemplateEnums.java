package com.jn.oa.schedule.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 短信模板枚举
 * @author： shaobao
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum ScheduleMessageTemplateEnums implements CodeAndMsg {

    MESSAGE_TEMPLATE("1033", "日程管理短信提醒模板");


    private String code;

    private String message;

    ScheduleMessageTemplateEnums(String key, String message) {
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
