package com.jn.oa.attendance.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 状态枚举
 * @author： yuanyy
 * @date： Created on 2018/11/1 17:03
 * @version： v1.0
 * @modified By:
 */
public enum AttendanceTypeEnums implements CodeAndMsg {

    //参会类型：1：签到，2:签退
    SIGN_IN("1", "签到"),
    SIGN_OUT("2", "签退")
    ;


    private String code;

    private String message;

    AttendanceTypeEnums(String key, String message) {
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
