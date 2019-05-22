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
 * 试题实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:21 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "Examinabank", description = "试题实体")
public class Examinabank implements Serializable {

	private static final long serialVersionUID = 5023132054186368184L;

	@ApiModelProperty(value = "试题编号", required = true, example = "\"111111111\"")
	@NotNull(message = "试题编号不能为空")
	private String testQuestionId;

	@ApiModelProperty(value = "试卷编号", required = true, example = "\"111111111\"")
	private String examinaId;

	@ApiModelProperty(value = "试题内容", required = true, example = "\"提问吗？\"")
	private String examinationQuestion;

	@ApiModelProperty(value = "试题类型（1：单选题，2：多选题，3：问答题，4：判断题）", required = true, example = "\"1\"")
	private String testQuestionType;

	@ApiModelProperty(value = "试题难度（1：不限难道，2：容易，3：中等，4：困难）", required = true, example = "\"1\"")
	private String examinationDifficulty;

	@ApiModelProperty(value = "标准答案", required = true, example = "\"B\"")
	private String standardAnswer;

	@ApiModelProperty(value = "分数", required = true, example = "\"50\"")
	private String fraction;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "\"1\"")
	private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号", required = true, example = "\"wangsong\"")
	private String creatorAccount;

	@ApiModelProperty(value = "创建时间", required = true, example = "\"2019-01-10 11:11:11\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号", required = true, example = "\"wangsong\"")
	private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间", required = true, example = "\"2019-01-10 11:11:11\"")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	@ApiModelProperty(value = "试题分析", required = true, example = "\"分析分析分析\"")
	private String itemAnalysis;

	// 答题人提交信息
	@ApiModelProperty(value = "答题卡id", required = true, example = "121212")
	private String cardId;

	@ApiModelProperty(value = "答案", required = true, example = "B")
	private String answer;

	@ApiModelProperty(value = "答题人工号", required = true, example = "N12345")
	private String jobNumber;

	@ApiModelProperty(value = "试卷编号", required = true, example = "1221212")
	private String testPaperId;

	@ApiModelProperty(value = "试题编号", required = true, example = "1221212")
	private String testQuestId;

	@ApiModelProperty(value = "错误标识", required = true, example = "true")
	private boolean errorFlag;

	@ApiModelProperty(value = "更新标识", required = true, example = "true")
	private boolean updateFlag;

	// 选项信息
	@ApiModelProperty(value = "试题选项列表", required = true, example = "[{\"id\":1}]")
	private List<ExaminaOption> optionList;

	@ApiModelProperty(value = "试题选项删除列表", required = true, example = "[{\"id\":1}]")
	private List<ExaminaOption> delOptionList;

	// 题目答案信息
	@ApiModelProperty(value = "编号ID(新增时可为空)", required = true, example = "\"1\"")
	private String answerId;

	@ApiModelProperty(value = "选择题答案编号", required = true, example = "\"A\"")
	private String answerNumber;

	@ApiModelProperty(value = "问答题答案", required = true, example = "\"选择A\"")
	private String answerHtml;

	@ApiModelProperty(value = "考试题目关联表id", required = true, example = "\"选择A\"")
	private String examQuestionId;

	public Examinabank() {
		super();
	}

	public Examinabank(String testQuestionId, String examinaId, String examinationQuestion, String testQuestionType,
			String examinationDifficulty, String standardAnswer, String fraction, Byte recordStatus,
			String creatorAccount, Date createdTime, String modifierAccount, Date modifiedTime, String itemAnalysis,
			String cardId, String answer, String jobNumber, String testPaperId, String testQuestId, boolean errorFlag,
			boolean updateFlag, List<ExaminaOption> optionList, List<ExaminaOption> delOptionList, String answerId,
			String answerNumber, String answerHtml, String examQuestionId) {
		super();
		this.testQuestionId = testQuestionId;
		this.examinaId = examinaId;
		this.examinationQuestion = examinationQuestion;
		this.testQuestionType = testQuestionType;
		this.examinationDifficulty = examinationDifficulty;
		this.standardAnswer = standardAnswer;
		this.fraction = fraction;
		this.recordStatus = recordStatus;
		this.creatorAccount = creatorAccount;
		this.createdTime = createdTime;
		this.modifierAccount = modifierAccount;
		this.modifiedTime = modifiedTime;
		this.itemAnalysis = itemAnalysis;
		this.cardId = cardId;
		this.answer = answer;
		this.jobNumber = jobNumber;
		this.testPaperId = testPaperId;
		this.testQuestId = testQuestId;
		this.errorFlag = errorFlag;
		this.updateFlag = updateFlag;
		this.optionList = optionList;
		this.delOptionList = delOptionList;
		this.answerId = answerId;
		this.answerNumber = answerNumber;
		this.answerHtml = answerHtml;
		this.examQuestionId = examQuestionId;
	}

	public boolean isErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getTestQuestionId() {
		return testQuestionId;
	}

	public void setTestQuestionId(String testQuestionId) {
		this.testQuestionId = testQuestionId;
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

	public String getExaminationDifficulty() {
		return examinationDifficulty;
	}

	public void setExaminationDifficulty(String examinationDifficulty) {
		this.examinationDifficulty = examinationDifficulty;
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

	public List<ExaminaOption> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<ExaminaOption> optionList) {
		this.optionList = optionList;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<ExaminaOption> getDelOptionList() {
		return delOptionList;
	}

	public void setDelOptionList(List<ExaminaOption> delOptionList) {
		this.delOptionList = delOptionList;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getTestPaperId() {
		return testPaperId;
	}

	public void setTestPaperId(String testPaperId) {
		this.testPaperId = testPaperId;
	}

	public String getTestQuestId() {
		return testQuestId;
	}

	public void setTestQuestId(String testQuestId) {
		this.testQuestId = testQuestId;
	}

	public boolean isUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
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

	public String getExamQuestionId() {
		return examQuestionId;
	}

	public void setExamQuestionId(String examQuestionId) {
		this.examQuestionId = examQuestionId;
	}

	public String getExaminaId() {
		return examinaId;
	}

	public void setExaminaId(String examinaId) {
		this.examinaId = examinaId;
	}

	@Override
	public String toString() {
		return "Examinabank {testQuestionId='" + testQuestionId + "', examinaId='" + examinaId
				+ "', examinationQuestion='" + examinationQuestion + "', testQuestionType='" + testQuestionType
				+ "', examinationDifficulty='" + examinationDifficulty + "', standardAnswer='" + standardAnswer
				+ "', fraction='" + fraction + "', recordStatus='" + recordStatus + "', creatorAccount='"
				+ creatorAccount + "', createdTime='" + createdTime + "', modifierAccount='" + modifierAccount
				+ "', modifiedTime='" + modifiedTime + "', itemAnalysis='" + itemAnalysis + "', cardId='" + cardId
				+ "', answer='" + answer + "', jobNumber='" + jobNumber + "', testPaperId='" + testPaperId
				+ "', testQuestId='" + testQuestId + "', errorFlag='" + errorFlag + "', updateFlag='" + updateFlag
				+ "', optionList='" + optionList + "', delOptionList='" + delOptionList + "', answerId='" + answerId
				+ "', answerNumber='" + answerNumber + "', answerHtml='" + answerHtml + "', examQuestionId='"
				+ examQuestionId + "'}";
	}

}
