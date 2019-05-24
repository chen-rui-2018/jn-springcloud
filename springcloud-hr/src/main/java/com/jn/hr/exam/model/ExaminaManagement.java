package com.jn.hr.exam.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 考试信息实体
 *
 * @author： wangtt
 * @date：Created on  2019/04/20 04:21 
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "ExaminaManagement", description = "考试信息实体")
public class ExaminaManagement implements Serializable {
	private static final long serialVersionUID = 6540687067101549696L;

	@ApiModelProperty(value = "考试编号ID", required = true, example = "\"Q1\"")
	private String id;

	@ApiModelProperty(value = "考试名称", required = true, example = "\"Q1\"")
	private String examinaName;

	@ApiModelProperty(value = "有效时间起(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeStart;

	@ApiModelProperty(value = "有效时间止(时间统一格式为yyyy-MM-dd HH:mm:ss)", required = true, example = "2019-12-13 12:12:12")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTimeEnd;

	@ApiModelProperty(value = "考试须知", required = true, example = "\"....\"")
	private String examinaNotes;

	@ApiModelProperty(value = "总分", required = true, example = "\"100\"")
	private Integer totalScore;

	@ApiModelProperty(value = "及格分数", required = true, example = "\"60\"")
	private Integer passScore;

	@ApiModelProperty(value = "总分/及格分数", required = true, example = "\"100/60\"")
	private String totalAndPassScore;

	@ApiModelProperty(value = "答题时间（分钟）", required = true, example = "\"60\"")
	private Integer answerTime;

	@ApiModelProperty(value = "考试二维码图片", required = true, example = "\"aa.jpg\"")
	private String examinaDimensional;

	@ApiModelProperty(value = "考试链接", required = true, example = "\"http://bbb.com\"")
	private String examinaUrl;

	@ApiModelProperty(value = "状态（1：进行中，2：已结束）", required = true, example = "1")
	private Byte status;

	@ApiModelProperty(value = "是否发布（1：已发布，2：未发布）", required = true, example = "1")
	private Byte isRelease;

	@ApiModelProperty(value = "是否删除（0标记删除，1正常）", required = true, example = "1")
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

	// 邮件信息
	@ApiModelProperty(value = "邮件主题", required = true, example = "\"在职考试\"")
	private String emailSubject;

	@ApiModelProperty(value = "邮件内容", required = true, example = "\"邮件详细内容\"")
	private String emailContent;

	@ApiModelProperty(value = "用户邮件列表", required = true, example = "\"12121@qq.com,122121@qq.com\"")
	private String emailList;

	// 答题人信息
	@ApiModelProperty(value = "成绩明细表的Id", required = true, example = "[{\"id\":1}]")
	private String resultId;

	@ApiModelProperty(value = "答题人名称", required = true, example = "[{\"id\":1}]")
	private String name;

	@ApiModelProperty(value = "答题工号", required = true, example = "[{\"id\":1}]")
	private String jobNumber;

	@ApiModelProperty(value = "成绩(查看答案页面需传入)", required = true, example = "[{\"id\":1}]")
	private Integer achievement;

	@ApiModelProperty(value = "答题耗时", required = true, example = "50")
	private Integer useTime;

	@ApiModelProperty(value = "是否通过（1：通过，2：否）", required = true, example = "1")
	private Byte isAdopt;

	@ApiModelProperty(value = "是否通过（1：通过，2：否）", required = true, example = "是")
	private String isAdoptStr;

	@ApiModelProperty(value = "考试方式（1：电脑，2：手机）", required = true, example = "1")
	private Byte examinaMethod;

	@ApiModelProperty(value = "考试方式（1：电脑，2：手机）", required = true, example = "电脑")
	private String examinaMethodStr;

	@ApiModelProperty(value = "排名", required = true, example = "50")
	private Integer rank;

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

	@ApiModelProperty(value = "考试开始和结束时间", required = true, example = "2019-12-13 12:12:12~2019-12-13 10:12:12")
	private String examinaStartEndTimeStr;

	@ApiModelProperty(value = "当前考试参加总人数", required = true, example = "10")
	private String countStr;

	@ApiModelProperty(value = "当前考试通过总人数", required = true, example = "9")
	private String yesAdoptCountStr;

	@ApiModelProperty(value = "当前考试通过率", required = true, example = "90%")
	private String yesAdoptRateStr;

	@ApiModelProperty(value = "当前考试未通过总人数", required = true, example = "1")
	private String notAdoptCountStr;

	@ApiModelProperty(value = "当前考试最低分", required = true, example = "100")
	private String minStr;

	@ApiModelProperty(value = "当前考试最高分", required = true, example = "80")
	private String maxStr;

	@ApiModelProperty(value = "当前考试平均分", required = true, example = "90")
	private String avgStr;

	@ApiModelProperty(value = "题目列表", required = true, example = "[]")
	private List<Examinabank> examinabanksList;

	public ExaminaManagement() {
		super();
	}

	public ExaminaManagement(String id, String examinaName, Date effectiveTimeStart, Date effectiveTimeEnd,
			String examinaNotes, Integer totalScore, Integer passScore, String totalAndPassScore, Integer answerTime,
			String examinaDimensional, String examinaUrl, Byte status, Byte isRelease, Byte recordStatus,
			String creatorAccount, Date createdTime, String modifierAccount, Date modifiedTime, Integer statusCount,
			Integer notStartStatusCount, Integer underWayStatusCount, Integer hasEndStatusCount, String emailSubject,
			String emailContent, String emailList, String resultId, String name, String jobNumber, Integer achievement,
			Integer useTime, Byte isAdopt, String isAdoptStr, Byte examinaMethod, String examinaMethodStr, Integer rank,
			Date examinaStartTime, String examinaStartTimeStr, Date examinaEndTime, String examinaEndTimeStr,
			String examinaStartEndTimeStr, String countStr, String yesAdoptCountStr, String yesAdoptRateStr,
			String notAdoptCountStr, String minStr, String maxStr, String avgStr, List<Examinabank> examinabanksList) {
		super();
		this.id = id;
		this.examinaName = examinaName;
		this.effectiveTimeStart = effectiveTimeStart;
		this.effectiveTimeEnd = effectiveTimeEnd;
		this.examinaNotes = examinaNotes;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.totalAndPassScore = totalAndPassScore;
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
		this.emailSubject = emailSubject;
		this.emailContent = emailContent;
		this.emailList = emailList;
		this.resultId = resultId;
		this.name = name;
		this.jobNumber = jobNumber;
		this.achievement = achievement;
		this.useTime = useTime;
		this.isAdopt = isAdopt;
		this.isAdoptStr = isAdoptStr;
		this.examinaMethod = examinaMethod;
		this.examinaMethodStr = examinaMethodStr;
		this.rank = rank;
		this.examinaStartTime = examinaStartTime;
		this.examinaStartTimeStr = examinaStartTimeStr;
		this.examinaEndTime = examinaEndTime;
		this.examinaEndTimeStr = examinaEndTimeStr;
		this.examinaStartEndTimeStr = examinaStartEndTimeStr;
		this.countStr = countStr;
		this.yesAdoptCountStr = yesAdoptCountStr;
		this.yesAdoptRateStr = yesAdoptRateStr;
		this.notAdoptCountStr = notAdoptCountStr;
		this.minStr = minStr;
		this.maxStr = maxStr;
		this.avgStr = avgStr;
		this.examinabanksList = examinabanksList;
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

	public String getEmailList() {
		return emailList;
	}

	public void setEmailList(String emailList) {
		this.emailList = emailList;
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

	public Byte getExaminaMethod() {
		return examinaMethod;
	}

	public void setExaminaMethod(Byte examinaMethod) {
		this.examinaMethod = examinaMethod;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Date getExaminaStartTime() {
		return examinaStartTime;
	}

	public void setExaminaStartTime(Date examinaStartTime) {
		this.examinaStartTime = examinaStartTime;
	}

	public Date getExaminaEndTime() {
		return examinaEndTime;
	}

	public void setExaminaEndTime(Date examinaEndTime) {
		this.examinaEndTime = examinaEndTime;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getIsAdoptStr() {
		return isAdoptStr;
	}

	public void setIsAdoptStr(String isAdoptStr) {
		this.isAdoptStr = isAdoptStr;
	}

	public String getExaminaMethodStr() {
		return examinaMethodStr;
	}

	public void setExaminaMethodStr(String examinaMethodStr) {
		this.examinaMethodStr = examinaMethodStr;
	}

	public String getExaminaStartTimeStr() {
		return examinaStartTimeStr;
	}

	public void setExaminaStartTimeStr(String examinaStartTimeStr) {
		this.examinaStartTimeStr = examinaStartTimeStr;
	}

	public String getExaminaEndTimeStr() {
		return examinaEndTimeStr;
	}

	public void setExaminaEndTimeStr(String examinaEndTimeStr) {
		this.examinaEndTimeStr = examinaEndTimeStr;
	}

	public String getTotalAndPassScore() {
		return totalAndPassScore;
	}

	public void setTotalAndPassScore(String totalAndPassScore) {
		this.totalAndPassScore = totalAndPassScore;
	}

	public String getExaminaStartEndTimeStr() {
		return examinaStartEndTimeStr;
	}

	public void setExaminaStartEndTimeStr(String examinaStartEndTimeStr) {
		this.examinaStartEndTimeStr = examinaStartEndTimeStr;
	}

	public String getCountStr() {
		return countStr;
	}

	public void setCountStr(String countStr) {
		this.countStr = countStr;
	}

	public String getYesAdoptCountStr() {
		return yesAdoptCountStr;
	}

	public void setYesAdoptCountStr(String yesAdoptCountStr) {
		this.yesAdoptCountStr = yesAdoptCountStr;
	}

	public String getYesAdoptRateStr() {
		return yesAdoptRateStr;
	}

	public void setYesAdoptRateStr(String yesAdoptRateStr) {
		this.yesAdoptRateStr = yesAdoptRateStr;
	}

	public String getNotAdoptCountStr() {
		return notAdoptCountStr;
	}

	public void setNotAdoptCountStr(String notAdoptCountStr) {
		this.notAdoptCountStr = notAdoptCountStr;
	}

	public String getMinStr() {
		return minStr;
	}

	public void setMinStr(String minStr) {
		this.minStr = minStr;
	}

	public String getMaxStr() {
		return maxStr;
	}

	public void setMaxStr(String maxStr) {
		this.maxStr = maxStr;
	}

	public String getAvgStr() {
		return avgStr;
	}

	public void setAvgStr(String avgStr) {
		this.avgStr = avgStr;
	}

	@Override
	public String toString() {
		return "ExaminaManagement {id='" + id + "', examinaName='" + examinaName + "', effectiveTimeStart='"
				+ effectiveTimeStart + "', effectiveTimeEnd='" + effectiveTimeEnd + "', examinaNotes='" + examinaNotes
				+ "', totalScore='" + totalScore + "', passScore='" + passScore + "', totalAndPassScore='"
				+ totalAndPassScore + "', answerTime='" + answerTime + "', examinaDimensional='" + examinaDimensional
				+ "', examinaUrl='" + examinaUrl + "', status='" + status + "', isRelease='" + isRelease
				+ "', recordStatus='" + recordStatus + "', creatorAccount='" + creatorAccount + "', createdTime='"
				+ createdTime + "', modifierAccount='" + modifierAccount + "', modifiedTime='" + modifiedTime
				+ "', statusCount='" + statusCount + "', notStartStatusCount='" + notStartStatusCount
				+ "', underWayStatusCount='" + underWayStatusCount + "', hasEndStatusCount='" + hasEndStatusCount
				+ "', emailSubject='" + emailSubject + "', emailContent='" + emailContent + "', emailList='" + emailList
				+ "', resultId='" + resultId + "', name='" + name + "', jobNumber='" + jobNumber + "', achievement='"
				+ achievement + "', useTime='" + useTime + "', isAdopt='" + isAdopt + "', isAdoptStr='" + isAdoptStr
				+ "', examinaMethod='" + examinaMethod + "', examinaMethodStr='" + examinaMethodStr + "', rank='" + rank
				+ "', examinaStartTime='" + examinaStartTime + "', examinaStartTimeStr='" + examinaStartTimeStr
				+ "', examinaEndTime='" + examinaEndTime + "', examinaEndTimeStr='" + examinaEndTimeStr
				+ "', examinaStartEndTimeStr='" + examinaStartEndTimeStr + "', countStr='" + countStr
				+ "', yesAdoptCountStr='" + yesAdoptCountStr + "', yesAdoptRateStr='" + yesAdoptRateStr
				+ "', notAdoptCountStr='" + notAdoptCountStr + "', minStr='" + minStr + "', maxStr='" + maxStr
				+ "', avgStr='" + avgStr + "', examinabanksList='" + examinabanksList + "'}";
	}

}
