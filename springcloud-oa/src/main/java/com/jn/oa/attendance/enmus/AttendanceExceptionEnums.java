package com.jn.oa.attendance.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 考勤异常枚举
 *
 * @author： yuanyy
 * @date： Created on 2019/2/12 17:02
 * @version： v1.0
 * @modified By:
 **/
public enum AttendanceExceptionEnums implements CodeAndMsg {
    ATTENDANCE_SIGN_OUT__ERROR("6015501", "未签到，不能进行签退");

    private String code;

    private String message;

    AttendanceExceptionEnums(String key, String message) {
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
