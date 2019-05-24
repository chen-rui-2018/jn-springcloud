package com.jn.hr.exam.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 考试服务异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum ExaminaExceptionEnums implements CodeAndMsg {

	EXAMINA_NOT_EXIST("7000101","当前考试不存在"),
	EXAMINA_BANK_NOT_EXIST("7000102","当前题目不存在"),
	BANK_ANSWER_NOT_EXIST("7000103","当前答案不存在"),
	RESULT_NOT_EXIST("7000104","当前考试信息不存在"),
	SEND_MANAGEMENT_ERROR("7000105","发放考试失败"),
	JOIN_MANAGEMENT_ERROR("7000106","参加考试失败"),
	NOT_NULL_ERROR("7000107","当前参数不能为空"),
	EXIST_RESULT_INFO("7000108","当前用户已完成考试"),

    ;

    private String code;
    private String message;

    ExaminaExceptionEnums(String code, String message) {
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
