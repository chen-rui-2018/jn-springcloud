package com.jn.oa.meeting.enums;

import com.jn.common.api.CodeAndMsg;

/**
 * 会议管理异常枚举
 * @author： yuanyy
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum MeetingExceptionEnums implements CodeAndMsg {

    CTEATE_QRCODE_FAIL("6014501", "生成二维码失败"),
    ADD_MEETINGROOM_CONFLICT("6014502","添加失败,会议室冲突"),
    UPDATE_MEETINGROOM_CONFLICT("6014503","修改失败,会议室冲突"),
    ADD_MEETING_TIME_CONFLICT("6014505","添加失败,会议开始时间不能小于当前时间"),
    UPDATE_MEETING_TIME_CONFLICT("6014506","修改失败,会议开始时间不能小于当前时间"),
    MEETING_ATTENDANCE_SIGN_OUT("6014507","签退失败，未签到不能进行签退"),
    MEETING_ATTENDANCE_SIGN_IN("6014508","签到失败，不能进行多次签到"),
    MEETING_ATTENDANCE_ERROR("6014509","考勤类型异常，不存在该类型"),
    MEETING_ATTENDANCE_CANCELLED_ERROR("6014510","考勤失败，该会议已取消"),
    MEETING_ATTENDANCE_TO_BEGIN_ERROR("6014511","考勤失败，该会议未开始"),
    MEETING_ATTENDANCE_COMPLETED_ERROR("6014512","考勤失败，该会议已结束")
    ;

    private String code;
    private String message;

    MeetingExceptionEnums(String code, String message) {
        this.code = code;
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
