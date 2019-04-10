package com.jn.park.activity.model;

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
@ApiModel(value = "ActivityDetail", description = "活动详情信息")
public class ActivityDetail implements Serializable {
    @ApiModelProperty(value = "活动ID")
    private String id;
    @ApiModelProperty(value = "活动类型")
    private String actiType;
    @ApiModelProperty(value = "活动名称")
    private String actiName;
    @ApiModelProperty(value = "活动开始时间 yyyy-MM-dd HH:mm:ss")
    private String actiStartTime;
    @ApiModelProperty(value = "活动结束时间 yyyy-MM-dd HH:mm:ss")
    private String actiEndTime;
    @ApiModelProperty(value = "报名开始时间 yyyy-MM-dd HH:mm:ss")
    private String applyStartTime;
    @ApiModelProperty(value = "报名结束时间 yyyy-MM-dd HH:mm:ss")
    private String applyEndTime;
    @ApiModelProperty(value = "活动推送时间 yyyy-MM-dd HH:mm:ss")
    private String mesSendTime;
    @ApiModelProperty(value = "活动地址")
    private String actiAddress;
    @ApiModelProperty(value = "活动费用")
    private String actiCost;
    @ApiModelProperty(value = "活动主办方")
    private String actiOrganizer;
    @ApiModelProperty(value = "活动人数")
    private String actiNumber;
    @ApiModelProperty(value = "活动主海报")
    private String actiPosterUrl;
    @ApiModelProperty(value = "阅读人数")
    private String actiViews;
    @ApiModelProperty(value = "感兴趣人数")
    private String actiLike;
    @ApiModelProperty(value = "报名人数")
    private String applyNum;
    @ApiModelProperty(value = "活动参加人数")
    private String particNum;
    @ApiModelProperty(value = "活动状态（1草稿 2报名中 3活动结束4活动取消）")
    private String actiStatus;
    @ApiModelProperty(value = "创建时间 yyyy-MM-dd HH:mm:ss")
    private String createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "发布时间 yyyy-MM-dd HH:mm:ss")
    private String issueTime;
    @ApiModelProperty(value = "发布人")
    private String issueAccount;
    @ApiModelProperty(value = "修改时间 yyyy-MM-dd HH:mm:ss")
    private String modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "是否首页展示")
    private String isIndex;
    @ApiModelProperty(value = "是否可报名")
    private String isApply;
    @ApiModelProperty(value = "活动内容")
    private String actiDetail;
    @ApiModelProperty(value = "是否展示报名人(0否1是)")
    private String showApplyNum;
    @ApiModelProperty(value = "活动园区")
    private String parkId;
    @ApiModelProperty(value = "活动园区名字")
    private String parkName;
    @ApiModelProperty(value = "活动报名是否需要审核(0否1是)")
    private String applyCheck;
    @ApiModelProperty(value = "活动排序")
    private String actiOrder;
    @ApiModelProperty(value = "园区列表")
    private List<ParkCode> parkCodes;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActiType() {
        return actiType;
    }

    public void setActiType(String actiType) {
        this.actiType = actiType;
    }

    public String getActiName() {
        return actiName;
    }

    public void setActiName(String actiName) {
        this.actiName = actiName;
    }

    public String getActiStartTime() {
        return actiStartTime;
    }

    public void setActiStartTime(String actiStartTime) {
        this.actiStartTime = actiStartTime;
    }

    public String getActiEndTime() {
        return actiEndTime;
    }

    public void setActiEndTime(String actiEndTime) {
        this.actiEndTime = actiEndTime;
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

    public String getMesSendTime() {
        return mesSendTime;
    }

    public void setMesSendTime(String mesSendTime) {
        this.mesSendTime = mesSendTime;
    }

    public String getActiAddress() {
        return actiAddress;
    }

    public void setActiAddress(String actiAddress) {
        this.actiAddress = actiAddress;
    }

    public String getActiCost() {
        return actiCost;
    }

    public void setActiCost(String actiCost) {
        this.actiCost = actiCost;
    }

    public String getActiOrganizer() {
        return actiOrganizer;
    }

    public void setActiOrganizer(String actiOrganizer) {
        this.actiOrganizer = actiOrganizer;
    }

    public String getActiNumber() {
        return actiNumber;
    }

    public void setActiNumber(String actiNumber) {
        this.actiNumber = actiNumber;
    }

    public String getActiPosterUrl() {
        return actiPosterUrl;
    }

    public void setActiPosterUrl(String actiPosterUrl) {
        this.actiPosterUrl = actiPosterUrl;
    }

    public String getActiViews() {
        return actiViews;
    }

    public void setActiViews(String actiViews) {
        this.actiViews = actiViews;
    }

    public String getActiLike() {
        return actiLike;
    }

    public void setActiLike(String actiLike) {
        this.actiLike = actiLike;
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

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
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

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
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

    public String getActiDetail() {
        return actiDetail;
    }

    public void setActiDetail(String actiDetail) {
        this.actiDetail = actiDetail;
    }

    public String getShowApplyNum() {
        return showApplyNum;
    }

    public void setShowApplyNum(String showApplyNum) {
        this.showApplyNum = showApplyNum;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getApplyCheck() {
        return applyCheck;
    }

    public void setApplyCheck(String applyCheck) {
        this.applyCheck = applyCheck;
    }

    public String getActiOrder() {
        return actiOrder;
    }

    public void setActiOrder(String actiOrder) {
        this.actiOrder = actiOrder;
    }

    public List<ParkCode> getParkCodes() {
        return parkCodes;
    }

    public void setParkCodes(List<ParkCode> parkCodes) {
        this.parkCodes = parkCodes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}