package com.jn.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * 活动详情信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityDetail", description = "活动详情信息")
public class ActivityDetail implements Serializable {
    @ApiModelProperty(value = "活动ID")
    private String activityId;
    @ApiModelProperty(value = "活动类型")
    private String activityType;
    @ApiModelProperty(value = "活动名称")
    private String activityName;
    @ApiModelProperty(value = "活动开始时间")
    private String activityStartTime;
    @ApiModelProperty(value = "活动结束时间")
    private String activityEndTime;
    @ApiModelProperty(value = "报名开始时间")
    private String applyStartTime;
    @ApiModelProperty(value = "报名结束时间")
    private String applyEndTime;
    @ApiModelProperty(value = "活动推送时间")
    private String mesSenTime;
    @ApiModelProperty(value = "活动地址")
    private String activityAdress;
    @ApiModelProperty(value = "活动费用")
    private String actiCost;
    @ApiModelProperty(value = "活动主办方")
    private String activityOrganizer;
    @ApiModelProperty(value = "活动人数")
    private String activityNumber;
    @ApiModelProperty(value = "活动主海报")
    private String activityPosterUrl;
    @ApiModelProperty(value = "阅读人数")
    private String activityViews;
    @ApiModelProperty(value = "感兴趣人数")
    private String activityLike;
    @ApiModelProperty(value = "报名人数")
    private String applyNum;
    @ApiModelProperty(value = "活动参加人数")
    private String particNum;
    @ApiModelProperty(value = "活动状态")
    private String state;
    @ApiModelProperty(value = "创建时间")
    private String createTime;
    @ApiModelProperty(value = "创建人")
    private String createAccount;
    @ApiModelProperty(value = "发布时间")
    private String issueTime;
    @ApiModelProperty(value = "发布人")
    private String issueAccount;
    @ApiModelProperty(value = "修改时间")
    private String updateTime;
    @ApiModelProperty(value = "修改人")
    private String updateAccount;
    @ApiModelProperty(value = "是否首页展示")
    private String isIndex;
    @ApiModelProperty(value = "是否可报名")
    private String isApply;
    @ApiModelProperty(value = "活动内容")
    private String activityDetail;
    @ApiModelProperty(value = "是否展示报名人(0否1是)")
    private String showApplyNum;
    @ApiModelProperty(value = "园区列表")
    private List<?> parkCodes;

    private static final long serialVersionUID = 1L;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(String applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public String getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(String applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public String getMesSenTime() {
        return mesSenTime;
    }

    public void setMesSenTime(String mesSenTime) {
        this.mesSenTime = mesSenTime;
    }

    public String getActivityAdress() {
        return activityAdress;
    }

    public void setActivityAdress(String activityAdress) {
        this.activityAdress = activityAdress;
    }

    public String getActiCost() {
        return actiCost;
    }

    public void setActiCost(String actiCost) {
        this.actiCost = actiCost;
    }

    public String getActivityOrganizer() {
        return activityOrganizer;
    }

    public void setActivityOrganizer(String activityOrganizer) {
        this.activityOrganizer = activityOrganizer;
    }

    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }

    public String getActivityPosterUrl() {
        return activityPosterUrl;
    }

    public void setActivityPosterUrl(String activityPosterUrl) {
        this.activityPosterUrl = activityPosterUrl;
    }

    public String getActivityViews() {
        return activityViews;
    }

    public void setActivityViews(String activityViews) {
        this.activityViews = activityViews;
    }

    public String getActivityLike() {
        return activityLike;
    }

    public void setActivityLike(String activityLike) {
        this.activityLike = activityLike;
    }

    public String getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(String applyNum) {
        this.applyNum = applyNum;
    }

    public String getParticNum() {
        return particNum;
    }

    public void setParticNum(String particNum) {
        this.particNum = particNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssueAccount() {
        return issueAccount;
    }

    public void setIssueAccount(String issueAccount) {
        this.issueAccount = issueAccount;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateAccount() {
        return updateAccount;
    }

    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount;
    }

    public String getIsIndex() {
        return isIndex;
    }

    public void setIsIndex(String isIndex) {
        this.isIndex = isIndex;
    }

    public String getIsApply() {
        return isApply;
    }

    public void setIsApply(String isApply) {
        this.isApply = isApply;
    }

    public String getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }

    public String getShowApplyNum() {
        return showApplyNum;
    }

    public void setShowApplyNum(String showApplyNum) {
        this.showApplyNum = showApplyNum;
    }

    public List<?> getParkCodes() {
        return parkCodes;
    }

    public void setParkCodes(List<?> parkCodes) {
        this.parkCodes = parkCodes;
    }
}