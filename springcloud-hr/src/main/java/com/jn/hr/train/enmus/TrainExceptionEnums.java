package com.jn.hr.train.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 培训服务异常枚举
 * @author： shaobao
 * @date： Created on 2018/11/21 16:56
 * @version： v1.0
 * @modified By:
 **/
public enum TrainExceptionEnums implements CodeAndMsg {

	MANAGEMENT_NOT_EXIST("7000801","当前调研/调查/课程不存在"),
	QUESTION_NOT_EXIST("7000802","当前题目不存在"),
	ANSWER_NOT_EXIST("7000803","当前答案不存在"),
	RESEARCH_SET_NOT_EXIST("7000804","当前调研不存在"),
	SEND_ERROR("7000805","发放失败"),
	JOIN_MANAGEMENT_ERROR("7000806","参加调研/调查失败"),
	NOT_NULL_ERROR("7000807","当前参数不能为空"),
	EXIST_RESULT_INFO("7000808","当前用户已完成考试"),
	INTERFACE_NOT_EXIT("7000809","当前界面不存在"),

    ;

    private String code;
    private String message;

    TrainExceptionEnums(String code, String message) {
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
