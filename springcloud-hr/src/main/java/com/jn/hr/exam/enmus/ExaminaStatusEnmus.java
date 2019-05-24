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
	// 是否通过
	IS_ADOPT("1", "通过"), UN_ADOPT("2", "未通过"),
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
