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
 * 新建考试信息实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:21 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminaManagementAdd", description = "新建考试信息实体")
public class ExaminaManagementAdd implements Serializable {
	private static final long serialVersionUID = 6540687067101549696L;

	@ApiModelProperty(value = "考试编号ID", required = true, example = "\"121212121212121212\"")
	private String id;

	@ApiModelProperty(value = "考试名称", required = true, example = "\"测试考试\"")
	@NotNull(message = "考试名称不能为空")
	private String examinaName;

	@ApiModelProperty(value = "有效时间起(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "有效时间起不能为空")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间起", required = true, example = "2019-12-13 12:12:12")
	private String effectiveTimeStartStr;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "有效时间止不能为空")
	private Date effectiveTimeEnd;

	@ApiModelProperty(value = "有效时间止", required = true, example = "2019-12-13 12:12:12")
	private String effectiveTimeEndStr;

	@ApiModelProperty(value = "考试须知", required = true, example = "\".......\"")
	private String examinaNotes;

	@ApiModelProperty(value = "总分", required = true, example = "100")
	@NotNull(message = "总分不能为空")
	private Integer totalScore;

	@ApiModelProperty(value = "及格分数", required = true, example = "60")
	@NotNull(message = "及格分数不能为空")
	private Integer passScore;

	@ApiModelProperty(value = "答题时间（分钟）", required = true, example = "60")
	@NotNull(message = "答题时间（分钟）不能为空")
	private Integer answerTime;

	@ApiModelProperty(value = "考试二维码图片", required = true, example = "\"aaa.jpg\"")
	private String examinaDimensional;

	@ApiModelProperty(value = "考试链接", required = true, example = "\"http:....com\"")
	private String examinaUrl;

	@ApiModelProperty(value = "状态（1：进行中，2：已结束）", required = true, example = "\"1\"")
	private Byte status;

	@ApiModelProperty(value = "是否发布（1：已发布，2：未发布）", required = true, example = "\"1\"")
	private Byte isRelease;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "\"1\"")
	private Byte recordStatus;

	@ApiModelProperty(value = "创建者账号", required = true, example = "\"wangsong\"")
	private String creatorAccount;

	@ApiModelProperty(value = "创建时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	@ApiModelProperty(value = "最新更新者账号", required = true, example = "\"wangsong\"")
	private String modifierAccount;

	@ApiModelProperty(value = "最新更新时间(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	// 试题页
	@ApiModelProperty(value = "所有数据个数", required = true, example = "5")
	private Integer statusCount;

	@ApiModelProperty(value = "状态为未开始0的数据个数", required = true, example = "3")
	private Integer notStartStatusCount;

	@ApiModelProperty(value = "状态为进行中1的数据个数", required = true, example = "3")
	private Integer underWayStatusCount;

	@ApiModelProperty(value = "状态为已结束2的数据个数", required = true, example = "2")
	private Integer hasEndStatusCount;

	@ApiModelProperty(value = "答题人个数", required = true, example = "\"0\"")
	private String resultCount;

	// 答题结果信息
	@ApiModelProperty(value = "成绩明细表的Id", required = true, example = "[{\"id\":1}]")
	private String resultId;

	@ApiModelProperty(value = "答题人名称", required = true, example = "[{\"id\":1}]")
	private String name;

	@ApiModelProperty(value = "答题工号", required = true, example = "[{\"id\":1}]")
	private String jobNumber;

	@ApiModelProperty(value = "最终成绩", required = true, example = "[{\"id\":1}]")
	private Integer achievement;

	@ApiModelProperty(value = "答题耗时", required = true, example = "50")
	private Integer useTime;

	@ApiModelProperty(value = "考试开始时间", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date examinaStartTime;

	@ApiModelProperty(value = "考试开始时间", required = true, example = "2019-12-13 12:12:12")
	private String examinaStartTimeStr;

	@ApiModelProperty(value = "考试结束时间", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date examinaEndTime;

	@ApiModelProperty(value = "考试结束时间", required = true, example = "2019-12-13 12:12:12")
	private String examinaEndTimeStr;

	@ApiModelProperty(value = "考试方式（1：电脑，2：手机）", required = true, example = "1")
	private Byte examinaMethod;

	@ApiModelProperty(value = "是否通过（1：通过，2：否）", required = true, example = "1")
	private Byte isAdopt;

	@ApiModelProperty(value = "答题总个数", required = true, example = "10")
	private Integer examinabankSize;

	@ApiModelProperty(value = "正确个数", required = true, example = "2")
	private double yesExaminaBankSize;

	@ApiModelProperty(value = "得分率", required = true, example = "20%")
	private String scoreRate;

	@ApiModelProperty(value = "正确率", required = true, example = "20%")
	private String accuracyRate;

	@ApiModelProperty(value = "题目列表", required = true, example = "\"[{\"testQuestionId\":\"1\"}]\"")
	private List<Examinabank> examinabanksList;

	@ApiModelProperty(value = "删除题目列表", required = true, example = "\"[{\"testQuestionId\":\"1\"}]\"")
	private List<Examinabank> deleteExaminabanksList;

	public ExaminaManagementAdd() {
		super();
	}

	public ExaminaManagementAdd(String id, String examinaName, Date effectiveTimeStart, String effectiveTimeStartStr,
			Date effectiveTimeEnd, String effectiveTimeEndStr, String examinaNotes, Integer totalScore,
			Integer passScore, Integer answerTime, String examinaDimensional, String examinaUrl, Byte status,
			Byte isRelease, Byte recordStatus, String creatorAccount, Date createdTime, String modifierAccount,
			Date modifiedTime, Integer statusCount, Integer notStartStatusCount, Integer underWayStatusCount,
			Integer hasEndStatusCount, String resultCount, String resultId, String name, String jobNumber,
			Integer achievement, Integer useTime, Date examinaStartTime, String examinaStartTimeStr,
			Date examinaEndTime, String examinaEndTimeStr, Byte examinaMethod, Byte isAdopt, Integer examinabankSize,
			double yesExaminaBankSize, String scoreRate, String accuracyRate, List<Examinabank> examinabanksList,
			List<Examinabank> deleteExaminabanksList) {
		super();
		this.id = id;
		this.examinaName = examinaName;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeStartStr = effectiveTimeStartStr;
		this.effectiveTimeEnd = effectiveTimeEnd;
		this.effectiveTimeEndStr = effectiveTimeEndStr;
		this.examinaNotes = examinaNotes;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.answerTime = answerTime;
		this.examinaDimensional = examinaDimensional;
		this.examinaUrl = examinaUrl;
		this.status = status;
		this.isRelease = isRelease;
		this.recordStatus = recordStatus;
		this.creatorAccount = creatorAccount;
		this.createdTime = createdTime;
		this.modifierAccount = modifierAccount;
		this.modifiedTime = modifiedTime;
		this.statusCount = statusCount;
		this.notStartStatusCount = notStartStatusCount;
		this.underWayStatusCount = underWayStatusCount;
		this.hasEndStatusCount = hasEndStatusCount;
		this.resultCount = resultCount;
		this.resultId = resultId;
		this.name = name;
		this.jobNumber = jobNumber;
		this.achievement = achievement;
		this.useTime = useTime;
		this.examinaStartTime = examinaStartTime;
		this.examinaStartTimeStr = examinaStartTimeStr;
		this.examinaEndTime = examinaEndTime;
		this.examinaEndTimeStr = examinaEndTimeStr;
		this.examinaMethod = examinaMethod;
		this.isAdopt = isAdopt;
		this.examinabankSize = examinabankSize;
		this.yesExaminaBankSize = yesExaminaBankSize;
		this.scoreRate = scoreRate;
		this.accuracyRate = accuracyRate;
		this.examinabanksList = examinabanksList;
		this.deleteExaminabanksList = deleteExaminabanksList;
	}

	public Integer getNotStartStatusCount() {
		return notStartStatusCount;
	}

	public void setNotStartStatusCount(Integer notStartStatusCount) {
		this.notStartStatusCount = notStartStatusCount;
	}

	public Integer getStatusCount() {
		return statusCount;
	}

	public void setStatusCount(Integer statusCount) {
		this.statusCount = statusCount;
	}

	public Integer getUnderWayStatusCount() {
		return underWayStatusCount;
	}

	public void setUnderWayStatusCount(Integer underWayStatusCount) {
		this.underWayStatusCount = underWayStatusCount;
	}

	public Integer getHasEndStatusCount() {
		return hasEndStatusCount;
	}

	public void setHasEndStatusCount(Integer hasEndStatusCount) {
		this.hasEndStatusCount = hasEndStatusCount;
	}

	public List<Examinabank> getDeleteExaminabanksList() {
		return deleteExaminabanksList;
	}

	public void setDeleteExaminabanksList(List<Examinabank> deleteExaminabanksList) {
		this.deleteExaminabanksList = deleteExaminabanksList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExaminaName() {
		return examinaName;
	}

	public void setExaminaName(String examinaName) {
		this.examinaName = examinaName;
	}

	public Date getEffectiveTimeStart() {
		return effectiveTimeStart;
	}

	public void setEffectiveTimeStart(Date effectiveTimeStart) {
		this.effectiveTimeStart = effectiveTimeStart;
	}

	public Date getEffectiveTimeEnd() {
		return effectiveTimeEnd;
	}

	public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
		this.effectiveTimeEnd = effectiveTimeEnd;
	}

	public String getExaminaNotes() {
		return examinaNotes;
	}

	public void setExaminaNotes(String examinaNotes) {
		this.examinaNotes = examinaNotes;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getPassScore() {
		return passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	public Integer getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Integer answerTime) {
		this.answerTime = answerTime;
	}

	public String getExaminaDimensional() {
		return examinaDimensional;
	}

	public void setExaminaDimensional(String examinaDimensional) {
		this.examinaDimensional = examinaDimensional;
	}

	public String getExaminaUrl() {
		return examinaUrl;
	}

	public void setExaminaUrl(String examinaUrl) {
		this.examinaUrl = examinaUrl;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Byte getIsRelease() {
		return isRelease;
	}

	public void setIsRelease(Byte isRelease) {
		this.isRelease = isRelease;
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

	public List<Examinabank> getExaminabanksList() {
		return examinabanksList;
	}

	public void setExaminabanksList(List<Examinabank> examinabanksList) {
		this.examinabanksList = examinabanksList;
	}

	public String getResultCount() {
		return resultCount;
	}

	public void setResultCount(String resultCount) {
		this.resultCount = resultCount;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Integer getAchievement() {
		return achievement;
	}

	public void setAchievement(Integer achievement) {
		this.achievement = achievement;
	}

	public Integer getUseTime() {
		return useTime;
	}

	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
	}

	public Byte getIsAdopt() {
		return isAdopt;
	}

	public void setIsAdopt(Byte isAdopt) {
		this.isAdopt = isAdopt;
	}

	public Integer getExaminabankSize() {
		return examinabankSize;
	}

	public void setExaminabankSize(Integer examinabankSize) {
		this.examinabankSize = examinabankSize;
	}

	public double getYesExaminaBankSize() {
		return yesExaminaBankSize;
	}

	public void setYesExaminaBankSize(double yesExaminaBankSize) {
		this.yesExaminaBankSize = yesExaminaBankSize;
	}

	public String getScoreRate() {
		return scoreRate;
	}

	public void setScoreRate(String scoreRate) {
		this.scoreRate = scoreRate;
	}

	public String getAccuracyRate() {
		return accuracyRate;
	}

	public void setAccuracyRate(String accuracyRate) {
		this.accuracyRate = accuracyRate;
	}

	public String getEffectiveTimeStartStr() {
		return effectiveTimeStartStr;
	}

	public void setEffectiveTimeStartStr(String effectiveTimeStartStr) {
		this.effectiveTimeStartStr = effectiveTimeStartStr;
	}

	public String getEffectiveTimeEndStr() {
		return effectiveTimeEndStr;
	}

	public void setEffectiveTimeEndStr(String effectiveTimeEndStr) {
		this.effectiveTimeEndStr = effectiveTimeEndStr;
	}

	public Date getExaminaStartTime() {
		return examinaStartTime;
	}

	public void setExaminaStartTime(Date examinaStartTime) {
		this.examinaStartTime = examinaStartTime;
	}

	public String getExaminaStartTimeStr() {
		return examinaStartTimeStr;
	}

	public void setExaminaStartTimeStr(String examinaStartTimeStr) {
		this.examinaStartTimeStr = examinaStartTimeStr;
	}

	public Date getExaminaEndTime() {
		return examinaEndTime;
	}

	public void setExaminaEndTime(Date examinaEndTime) {
		this.examinaEndTime = examinaEndTime;
	}

	public String getExaminaEndTimeStr() {
		return examinaEndTimeStr;
	}

	public void setExaminaEndTimeStr(String examinaEndTimeStr) {
		this.examinaEndTimeStr = examinaEndTimeStr;
	}

	public Byte getExaminaMethod() {
		return examinaMethod;
	}

	public void setExaminaMethod(Byte examinaMethod) {
		this.examinaMethod = examinaMethod;
	}

	@Override
	public String toString() {
		return "ExaminaManagementAdd {id='" + id + "', examinaName='" + examinaName + "', effectiveTimeStart='"
				+ effectiveTimeStart + "', effectiveTimeStartStr='" + effectiveTimeStartStr + "', effectiveTimeEnd='"
				+ effectiveTimeEnd + "', effectiveTimeEndStr='" + effectiveTimeEndStr + "', examinaNotes='"
				+ examinaNotes + "', totalScore='" + totalScore + "', passScore='" + passScore + "', answerTime='"
				+ answerTime + "', examinaDimensional='" + examinaDimensional + "', examinaUrl='" + examinaUrl
				+ "', status='" + status + "', isRelease='" + isRelease + "', recordStatus='" + recordStatus
				+ "', creatorAccount='" + creatorAccount + "', createdTime='" + createdTime + "', modifierAccount='"
				+ modifierAccount + "', modifiedTime='" + modifiedTime + "', statusCount='" + statusCount
				+ "', notStartStatusCount='" + notStartStatusCount + "', underWayStatusCount='" + underWayStatusCount
				+ "', hasEndStatusCount='" + hasEndStatusCount + "', resultCount='" + resultCount + "', resultId='"
				+ resultId + "', name='" + name + "', jobNumber='" + jobNumber + "', achievement='" + achievement
				+ "', useTime='" + useTime + "', examinaStartTime='" + examinaStartTime + "', examinaStartTimeStr='"
				+ examinaStartTimeStr + "', examinaEndTime='" + examinaEndTime + "', examinaEndTimeStr='"
				+ examinaEndTimeStr + "', examinaMethod='" + examinaMethod + "', isAdopt='" + isAdopt
				+ "', examinabankSize='" + examinabankSize + "', yesExaminaBankSize='" + yesExaminaBankSize
				+ "', scoreRate='" + scoreRate + "', accuracyRate='" + accuracyRate + "', examinabanksList='"
				+ examinabanksList + "', deleteExaminabanksList='" + deleteExaminabanksList + "'}";
	}

}
