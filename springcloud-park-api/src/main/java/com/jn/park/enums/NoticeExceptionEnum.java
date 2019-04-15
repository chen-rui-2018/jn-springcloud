package com.jn.park.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * @author： chenr
 * @date： Created on 2019/4/2 11:13
 * @version： v1.0
 * @modified By:
 */
public enum NoticeExceptionEnum implements CodeAndMsg {
    NOTICE_TRANCE_DETAILS_DEFAULT("4020601","公告详情转换为byte失败"),
    NOTICE_TIME_PARSE_DEFAULT("4020602","公告生效/失效日期格式有误"),
    NOTICE_NOT_EXIST("4020603","此公告不存在");

    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    NoticeExceptionEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
