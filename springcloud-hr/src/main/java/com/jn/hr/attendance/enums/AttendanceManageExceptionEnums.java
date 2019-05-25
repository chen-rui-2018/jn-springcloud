package com.jn.hr.attendance.enums;

import com.jn.common.api.CodeAndMsg;

public enum AttendanceManageExceptionEnums implements CodeAndMsg{
    
    ;
    private String code;

    private String message;

    AttendanceManageExceptionEnums(String code, String message) {
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
