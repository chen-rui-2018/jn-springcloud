package com.jn.oa.attendance.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum AttendancePlatformEnums implements CodeAndMsg {

    //考勤平台：1：PC，2：APP，3：钉钉
    PLATFORM_PC("1", "PC"),
    PLATFORM_APP("2", "APP"),
    PLATFORM_DINGDING("3", "钉钉")
    ;


    private String code;

    private String message;

    AttendancePlatformEnums(String key, String message) {
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
