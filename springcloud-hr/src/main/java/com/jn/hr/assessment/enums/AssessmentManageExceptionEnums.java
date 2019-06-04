package com.jn.hr.assessment.enums;

import com.jn.common.api.CodeAndMsg;

public enum AssessmentManageExceptionEnums implements CodeAndMsg{
    ASSESSMENT_NOT_FINISHED("3000001","还有考核项未结束"),
    ASSESSMENT_NOT_PEOPLE("3000002","还有人未考核结束"),
    ASSESSMENT_PROJECT("3000003","考核项目不存在"),
    ASSESSMENT_TEMPLATE_EXIST("3000004","考核模板名称已存在")
	;
    private String code;

    private String message;

    AssessmentManageExceptionEnums(String code, String message) {
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
