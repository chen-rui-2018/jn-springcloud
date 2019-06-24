package com.jn.oa.schedule.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 日程管理异常枚举
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 17:02
 * @version： v1.0
 * @modified By:
 **/
public enum ScheduleExceptionEnums implements CodeAndMsg {
    SCHEDULE_TIME_ERROR("6016501","日程开始时间需要在截止时间之前"),
    REMIND_TIME_ERROR("6016502","提醒时间需要在当前时间之后"),
    REMIND_TIME_NOT_NULL("6016503","定时时间不能为空"),
    REMIND_METHOD_NOT_EMPTY("6016504","至少选择一种提醒方式"),
    QUERY_DATE_NOT_EMPTY("6016505","时间段查询不能有时间为空")
    ;
    private String code;

    private String message;

    ScheduleExceptionEnums(String key, String message) {
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
