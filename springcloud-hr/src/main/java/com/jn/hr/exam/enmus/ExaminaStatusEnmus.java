package com.jn.hr.exam.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 考试发送状态
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 06:24 
 * @version： v1.0
 * @modified By:
 **/
public enum ExaminaStatusEnmus implements CodeAndMsg {
	// 考试发送状态
	IS_SEND("1", "已发布"), UN_SEND("2", "未发布"),
	// 考试状态
	NOT_START("0", "未开始"), UNDER_WAY("1", "进行中"), HAS_END("2", "已结束"),
	// 题目类型（1：单选题，2：多选题，3：问答题，4：判断题）
	TYPE_ONE("1", "单选题"), TYPE_TWO("2", "多选题"), TYPE_THREE("3", "问答题"), TYPE_FOUR("4", "判断题"),
	// 是否通过
	IS_ADOPT("1", "通过"), UN_ADOPT("2", "未通过"),
	// 答案类型
	TYPE_TRUE("1", "正确"), TYPE_FALSE("2", "错误"),
	// 排名
	INIO_RANK("0", "初始排名"),;
	private String code;

	private String message;

	ExaminaStatusEnmus(String key, String message) {
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
