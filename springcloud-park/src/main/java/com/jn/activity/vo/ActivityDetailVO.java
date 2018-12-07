package com.jn.activity.vo;


import com.jn.activity.entity.TbActivityApply;
import com.jn.activity.entity.TbActivityLike;
import com.jn.activity.entity.TbComment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel(value = "ActivityDetailVO", description = "活动详情信息")
public class ActivityDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @ApiModelProperty(value = "是否置顶")
    private String isTop;
    @ApiModelProperty(value = "置顶时间")
    private String topTime;
    @ApiModelProperty(value = "是否可报名")
    private String isApply;
    @ApiModelProperty(value = "活动内容")
    private String activityDetail;
    @ApiModelProperty(value = "活动点评信息，点评id/活动id、点评人、点评时间、点评获赞数、点评状态、点评人数")
    private List<TbComment> commentList;
    @ApiModelProperty(value = "活动点赞信息，活动id、点赞人、点赞时间、点赞状态、点赞人数")
    private List<TbActivityLike> activityLikeList;
    @ApiModelProperty(value = "活动报名信息，活动id、报名人、报名时间、报名状态、签到状态、签到时间、签到方式、报名人数")
    private List<TbActivityApply> activityApplyList;


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

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getTopTime() {
        return topTime;
    }

    public void setTopTime(String topTime) {
        this.topTime = topTime;
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

    public List<TbComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<TbComment> commentList) {
        this.commentList = commentList;
    }

    public List<TbActivityLike> getActivityLikeList() {
        return activityLikeList;
    }

    public void setActivityLikeList(List<TbActivityLike> activityLikeList) {
        this.activityLikeList = activityLikeList;
    }

    public List<TbActivityApply> getActivityApplyList() {
        return activityApplyList;
    }

    public void setActivityApplyList(List<TbActivityApply> activityApplyList) {
        this.activityApplyList = activityApplyList;
    }

    @Override
    public String toString() {
        return "ActivityDetailVO{" +
                "activityId='" + activityId + '\'' +
                ", activityType='" + activityType + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityStartTime='" + activityStartTime + '\'' +
                ", activityEndTime='" + activityEndTime + '\'' +
                ", applyStartTime='" + applyStartTime + '\'' +
                ", applyEndTime='" + applyEndTime + '\'' +
                ", mesSenTime='" + mesSenTime + '\'' +
                ", activityAdress='" + activityAdress + '\'' +
                ", actiCost='" + actiCost + '\'' +
                ", activityOrganizer='" + activityOrganizer + '\'' +
                ", activityNumber='" + activityNumber + '\'' +
                ", activityPosterUrl='" + activityPosterUrl + '\'' +
                ", activityViews='" + activityViews + '\'' +
                ", activityLike='" + activityLike + '\'' +
                ", applyNum='" + applyNum + '\'' +
                ", particNum='" + particNum + '\'' +
                ", state='" + state + '\'' +
                ", createTime='" + createTime + '\'' +
                ", createAccount='" + createAccount + '\'' +
                ", issueTime='" + issueTime + '\'' +
                ", issueAccount='" + issueAccount + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateAccount='" + updateAccount + '\'' +
                ", isTop='" + isTop + '\'' +
                ", topTime='" + topTime + '\'' +
                ", isApply='" + isApply + '\'' +
                ", activityDetail='" + activityDetail + '\'' +
                ", commentList=" + commentList +
                ", activityLikeList=" + activityLikeList +
                ", activityApplyList=" + activityApplyList +
                '}';
    }
}