package com.jn.oa.meeting.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum MeetingStatusEnums implements CodeAndMsg {
    //会议状态（0:待开始、1:进行中、2:已完成、3:已取消）
    TO_BEGIN("0", "待开始"),
    DOING("1", "进行中"),
    COMPLETED("2", "已完成"),
    CANCELLED("3", "已取消");

    private String code;

    private String message;

    MeetingStatusEnums(String key, String message) {
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
