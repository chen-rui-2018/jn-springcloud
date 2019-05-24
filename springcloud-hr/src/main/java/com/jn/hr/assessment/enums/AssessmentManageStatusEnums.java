package com.jn.hr.assessment.enums;

import com.jn.common.api.CodeAndMsg;

public enum AssessmentManageStatusEnums implements CodeAndMsg{
    SIGN_DETELE("0","标记删除"),
    SIGN_NORMAL("1","正常"),
    NOT_BEGIN("1","未开始"),
    NOT_ASSESSMENT("0","未开始"),
    ASSESSMENT_ING("1","考核中"),
    ASSESSMENT_OVER("2","考核结束"),
    ;
    
	
	private String code;

    private String message;

    AssessmentManageStatusEnums(String code, String message) {
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
