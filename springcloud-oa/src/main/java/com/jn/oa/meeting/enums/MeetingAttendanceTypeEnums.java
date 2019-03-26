package com.jn.oa.meeting.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 会议考勤签到签退类型
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum MeetingAttendanceTypeEnums implements CodeAndMsg {
    //会议考勤签到签退类型:1:签到，2：签退
    MEETING_SIGN_IN("1", "签到"),
    MEETING_SIGN_OUT("2", "签退");

    private String code;

    private String message;

    MeetingAttendanceTypeEnums(String key, String message) {
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
