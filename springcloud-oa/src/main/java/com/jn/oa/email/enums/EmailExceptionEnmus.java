package com.jn.oa.email.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 公告管理异常枚举
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 17:02
 * @version： v1.0
 * @modified By:
 **/
public enum EmailExceptionEnmus implements CodeAndMsg {
    SEND_STATUS_NOT_NULL("6013501", "邮件发送状态不能为空"),
    DELAY_SEND_TIME_NOT_NULL("6013502","定时发送时间不能为空"),
    DELAY_SEND_TIME_ERROR("6013503","定时发送时间需要大于当前时间"),
    RECIPIENTS_NOT_EMPTY("6013504","邮件收件人不能为空"),
    TIMING_FAILURE("6013505","邮件定时设置失败,请稍后再试"),
    EMAIL_NOT_EXIST("6013506","一键发送失败,邮件任务不存在或已被删除"),
    ;

    private String code;

    private String message;

    EmailExceptionEnmus(String key, String message) {
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
