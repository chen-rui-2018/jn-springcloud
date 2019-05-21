package com.jn.hr.attendance.enums;

import com.jn.common.api.CodeAndMsg;

public enum attendanceManageStatusEnums implements CodeAndMsg{
	EFFECTIVE("1","有效"),
    INVALID("2","无效"),
    SIGN_DETELE("0","标记删除"),
    SIGN_NORMAL("1","正常"),
    ;
    
	
	private String code;

    private String message;

    attendanceManageStatusEnums(String code, String message) {
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
