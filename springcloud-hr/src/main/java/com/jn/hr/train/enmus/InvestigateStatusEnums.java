package com.jn.hr.train.enmus;

import com.jn.common.api.CodeAndMsg;

/**
 * 调研状态枚举
 *
 * @author： wangtt
 * @date：Created on  2019/04/15 06:24 
 * @version： v1.0
 * @modified By:
 **/
public enum InvestigateStatusEnums implements CodeAndMsg {
	// 考试发送状态
	IS_SEND("1", "已发送"), UN_SEND("2", "未发送"),
	// 调研/问卷状态
	DRAFT("0", "草稿"), UNDER_WAY("1", "进行中"), HAS_END("2", "已结束"),
	// 调研方式（1：匿名调研，2：实名调研）
	HIDE_NAME("1", "匿名调研"), REAL_NAME("2", "实名调研"),
	// 次数限制
	LIMITY_ONE("1", "每个学员只能问卷一次"),
	// 题目类型
	SINGLE_QUEST("1", "单选题"), MULTIPLE_QUEST("2", "多选题"),
	// 字段显示标识
	DISPLAY("1", "显示"),;
	private String code;

	private String message;

	InvestigateStatusEnums(String key, String message) {
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
