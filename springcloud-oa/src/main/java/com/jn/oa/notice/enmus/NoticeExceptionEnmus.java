package com.jn.oa.notice.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 公告管理异常枚举
 *
 * @author： shaobao
 * @date： Created on 2019/2/12 17:02
 * @version： v1.0
 * @modified By:
 **/
public enum NoticeExceptionEnmus implements CodeAndMsg {
    NOTICE_TIME_PARSE_ERROR("6011201", "公告管理时间格式转换错误"),
    NOTICE_TIME_ERROR("6011502", "失效时间需要大于生效时间"),
    NOTICE_NOT_EXIST("6011503", "修改信息不存在"),
    GET_NOTICE_ERROR("6011504", "公告信息不存在,或已被删除");
    private String code;

    private String message;

    NoticeExceptionEnmus(String key, String message) {
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
