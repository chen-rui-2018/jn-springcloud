package com.jn.hr.exam.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增试题实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:21 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminabankAdd", description = "新增试题实体")
public class ExaminabankAdd implements Serializable {
	private static final long serialVersionUID = -8927916824393147994L;

	@ApiModelProperty(value = "试题编号(新增时可为空)", required = true, example = "\"Q1\"")
	private String testQuestionId;

	@ApiModelProperty(value = "试卷编号", required = true, example = "\"Q1\"")
	private String examinaId;

	@ApiModelProperty(value = "试题内容", required = true, example = "\"Q1\"")
	@NotNull(message = "试题内容不能为空")
	private String examinationQuestion;

	@ApiModelProperty(value = "试题类型（1：单选题，2：多选题，3：问答题，4：判断题）", required = true, example = "\"Q1\"")
	@NotNull(message = "试题类型不能为空")
	private String testQuestionType;

	@ApiModelProperty(value = "试题类型解析（1：单选题，2：多选题，3：问答题，4：判断题）")
	private String testQuestionTypeStr;

	@ApiModelProperty(value = "试题难度（1：不限难道，2：容易，3：中等，4：困难）", required = true, example = "\"Q1\"")
	@NotNull(message = "试题难度不能为空")
	private String examinationDifficulty;

	@ApiModelProperty(value = "试题难度（1：不限难道，2：容易，3：中等，4：困难）")
	private String examinationDifficultyStr;

	@ApiModelProperty(value = "标准答案", required = true, example = "\"Q1\"")
	private String standardAnswer;

	@ApiModelProperty(value = "分数", required = true, example = "\"Q1\"")
	@NotNull(message = "分数不能为空")
	private String fraction;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "\"Q1\"")
	private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号", required = true, example = "\"Q1\"")
	private String creatorAccount;

	@ApiModelProperty(value = "创建时间", required = true, example = "\"Q1\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty(value = "创建时间")
	private String createdTimeStr;

	@ApiModelProperty(value = "最新更新者账号", required = true, example = "\"Q1\"")
	private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间", required = true, example = "\"Q1\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	@ApiModelProperty(value = "试题分析", required = true, example = "\"Q1\"")
	private String itemAnalysis;

	// 选项信息
	@ApiModelProperty(value = "题目选项列表", required = true, example = "[{},{}]")
	private List<ExaminaOptionAdd> optionList;

	// 题目答案信息
	@ApiModelProperty(value = "编号ID(新增时可为空)", required = true, example = "\"1\"")
	private String answerId;

	@ApiModelProperty(value = "选择题答案编号", required = true, example = "\"A\"")
	private String answerNumber;

	@ApiModelProperty(value = "问答题答案", required = true, example = "\"选择A\"")
	private String answerHtml;

	public ExaminabankAdd() {
		super();
	}

	public ExaminabankAdd(String testQuestionId, String examinaId, String examinationQuestion, String testQuestionType,
			String testQuestionTypeStr, String examinationDifficulty, String examinationDifficultyStr,
			String standardAnswer, String fraction, Byte recordStatus, String creatorAccount, Date createdTime,
			String createdTimeStr, String modifierAccount, Date modifiedTime, String itemAnalysis,
			List<ExaminaOptionAdd> optionList, String answerId, String answerNumber, String answerHtml) {
		super();
		this.testQuestionId = testQuestionId;
		this.examinaId = examinaId;
		this.examinationQuestion = examinationQuestion;
		this.testQuestionType = testQuestionType;
		this.testQuestionTypeStr = testQuestionTypeStr;
		this.examinationDifficulty = examinationDifficulty;
		this.examinationDifficultyStr = examinationDifficultyStr;
		this.standardAnswer = standardAnswer;
		this.fraction = fraction;
		this.recordStatus = recordStatus;
		this.creatorAccount = creatorAccount;
		this.createdTime = createdTime;
		this.createdTimeStr = createdTimeStr;
		this.modifierAccount = modifierAccount;
		this.modifiedTime = modifiedTime;
		this.itemAnalysis = itemAnalysis;
		this.optionList = optionList;
		this.answerId = answerId;
		this.answerNumber = answerNumber;
		this.answerHtml = answerHtml;
	}

	public String getTestQuestionId() {
		return testQuestionId;
	}

	public void setTestQuestionId(String testQuestionId) {
		this.testQuestionId = testQuestionId;
	}

	public String getExaminaId() {
		return examinaId;
	}

	public void setExaminaId(String examinaId) {
		this.examinaId = examinaId;
	}

	public String getExaminationQuestion() {
		return examinationQuestion;
	}

	public void setExaminationQuestion(String examinationQuestion) {
		this.examinationQuestion = examinationQuestion;
	}

	public String getTestQuestionType() {
		return testQuestionType;
	}

	public void setTestQuestionType(String testQuestionType) {
		this.testQuestionType = testQuestionType;
	}

	public String getTestQuestionTypeStr() {
		return testQuestionTypeStr;
	}

	public void setTestQuestionTypeStr(String testQuestionTypeStr) {
		this.testQuestionTypeStr = testQuestionTypeStr;
	}

	public String getExaminationDifficulty() {
		return examinationDifficulty;
	}

	public void setExaminationDifficulty(String examinationDifficulty) {
		this.examinationDifficulty = examinationDifficulty;
	}

	public String getExaminationDifficultyStr() {
		return examinationDifficultyStr;
	}

	public void setExaminationDifficultyStr(String examinationDifficultyStr) {
		this.examinationDifficultyStr = examinationDifficultyStr;
	}

	public String getStandardAnswer() {
		return standardAnswer;
	}

	public void setStandardAnswer(String standardAnswer) {
		this.standardAnswer = standardAnswer;
	}

	public String getFraction() {
		return fraction;
	}

	public void setFraction(String fraction) {
		this.fraction = fraction;
	}

	public Byte getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Byte recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedTimeStr() {
		return createdTimeStr;
	}

	public void setCreatedTimeStr(String createdTimeStr) {
		this.createdTimeStr = createdTimeStr;
	}

	public String getModifierAccount() {
		return modifierAccount;
	}

	public void setModifierAccount(String modifierAccount) {
		this.modifierAccount = modifierAccount;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getItemAnalysis() {
		return itemAnalysis;
	}

	public void setItemAnalysis(String itemAnalysis) {
		this.itemAnalysis = itemAnalysis;
	}

	public List<ExaminaOptionAdd> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<ExaminaOptionAdd> optionList) {
		this.optionList = optionList;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswerNumber() {
		return answerNumber;
	}

	public void setAnswerNumber(String answerNumber) {
		this.answerNumber = answerNumber;
	}

	public String getAnswerHtml() {
		return answerHtml;
	}

	public void setAnswerHtml(String answerHtml) {
		this.answerHtml = answerHtml;
	}

	@Override
	public String toString() {
		return "ExaminabankAdd {testQuestionId='" + testQuestionId + "', examinaId='" + examinaId
				+ "', examinationQuestion='" + examinationQuestion + "', testQuestionType='" + testQuestionType
				+ "', testQuestionTypeStr='" + testQuestionTypeStr + "', examinationDifficulty='"
				+ examinationDifficulty + "', examinationDifficultyStr='" + examinationDifficultyStr
				+ "', standardAnswer='" + standardAnswer + "', fraction='" + fraction + "', recordStatus='"
				+ recordStatus + "', creatorAccount='" + creatorAccount + "', createdTime='" + createdTime
				+ "', createdTimeStr='" + createdTimeStr + "', modifierAccount='" + modifierAccount
				+ "', modifiedTime='" + modifiedTime + "', itemAnalysis='" + itemAnalysis + "', optionList='"
				+ optionList + "', answerId='" + answerId + "', answerNumber='" + answerNumber + "', answerHtml='"
				+ answerHtml + "'}";
	}

}
