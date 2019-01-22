package com.jn.park.activity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 活动信息
 *
 * @Author: jiangyl
 * @Date: 2018/12/5 11:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ActivityVO", description = "活动信息")
public class ActivityVO implements Serializable {
    @ApiModelProperty(value = "活动ID")
    private String id;
    @ApiModelProperty(value = "活动类型")
    private String actiType;
    @ApiModelProperty(value = "活动名称")
    private String actiName;
    @ApiModelProperty(value = "活动开始时间")
    private Date actiStartTime;
    @ApiModelProperty(value = "活动结束时间")
    private Date actiEndTime;
    @ApiModelProperty(value = "活动报名开始时间")
    private Date applyStartTime;
    @ApiModelProperty(value = "活动报名结束时间")
    private Date applyEndTime;
    @ApiModelProperty(value = "活动消息发送时间")
    private Date mesSendTime;
    @ApiModelProperty(value = "活动园区标识")
    private String parkId;
    @ApiModelProperty(value = "活动地址")
    private String actiAddress;
    @ApiModelProperty(value = "活动费用")
    private BigDecimal actiCost;
    @ApiModelProperty(value = "活动主办方")
    private String actiOrganizer;
    @ApiModelProperty(value = "活动人数")
    private Integer actiNumber;
    @ApiModelProperty(value = "活动海报路径")
    private String actiPosterUrl;
    @ApiModelProperty(value = "活动状态")
    private String actiStatus;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;
    @ApiModelProperty(value = "最新更新时间")
    private Date modifiedTime;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;
    @ApiModelProperty(value = "阅读人数")
    private Integer actiViews;
    @ApiModelProperty(value = "点赞人数")
    private Integer actiLike;
    @ApiModelProperty(value = "报名人数")
    private Integer applyNum;
    @ApiModelProperty(value = "实际参加人数")
    private Integer particNum;
    @ApiModelProperty(value = "是否置顶")
    private String isTop;
    @ApiModelProperty(value = "置顶时间")
    private Date topTime;
    @ApiModelProperty(value = "是否首页展示")
    private String isIndex;
    @ApiModelProperty(value = "是否可报名")
    private String isApply;
    @ApiModelProperty(value = "排序")
    private Integer actiOrder;
    @ApiModelProperty(value = "发布时间")
    private Date issueTime;
    @ApiModelProperty(value = "发布人")
    private String issueAccount;
    @ApiModelProperty(value = "展示报名人数")
    private String showApplyNum;
    @ApiModelProperty(value = "报名是否需审核")
    private String applyCheck;
    @ApiModelProperty(value = "删除标识（0标记删除，1正常）")
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getActiType() {
        return actiType;
    }

    public void setActiType(String actiType) {
        this.actiType = actiType == null ? null : actiType.trim();
    }

    public String getActiName() {
        return actiName;
    }

    public void setActiName(String actiName) {
        this.actiName = actiName == null ? null : actiName.trim();
    }

    public Date getActiStartTime() {
        return actiStartTime;
    }

    public void setActiStartTime(Date actiStartTime) {
        this.actiStartTime = actiStartTime;
    }

    public Date getActiEndTime() {
        return actiEndTime;
    }

    public void setActiEndTime(Date actiEndTime) {
        this.actiEndTime = actiEndTime;
    }

    public Date getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public Date getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public Date getMesSendTime() {
        return mesSendTime;
    }

    public void setMesSendTime(Date mesSendTime) {
        this.mesSendTime = mesSendTime;
    }

    public String getActiAddress() {
        return actiAddress;
    }

    public void setActiAddress(String actiAddress) {
        this.actiAddress = actiAddress == null ? null : actiAddress.trim();
    }

    public BigDecimal getActiCost() {
        return actiCost;
    }

    public void setActiCost(BigDecimal actiCost) {
        this.actiCost = actiCost;
    }

    public String getActiOrganizer() {
        return actiOrganizer;
    }

    public void setActiOrganizer(String actiOrganizer) {
        this.actiOrganizer = actiOrganizer == null ? null : actiOrganizer.trim();
    }

    public Integer getActiNumber() {
        return actiNumber;
    }

    public void setActiNumber(Integer actiNumber) {
        this.actiNumber = actiNumber;
    }

    public String getActiPosterUrl() {
        return actiPosterUrl;
    }

    public void setActiPosterUrl(String actiPosterUrl) {
        this.actiPosterUrl = actiPosterUrl == null ? null : actiPosterUrl.trim();
    }


    public Integer getActiViews() {
        return actiViews;
    }

    public void setActiViews(Integer actiViews) {
        this.actiViews = actiViews;
    }

    public Integer getActiLike() {
        return actiLike;
    }

    public void setActiLike(Integer actiLike) {
        this.actiLike = actiLike;
    }

    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    public Integer getParticNum() {
        return particNum;
    }

    public void setParticNum(Integer particNum) {
        this.particNum = particNum;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public Date getTopTime() {
        return topTime;
    }

    public void setTopTime(Date topTime) {
        this.topTime = topTime;
    }

    public String getIsApply() {
        return isApply;
    }

    public void setIsApply(String isApply) {
        this.isApply = isApply;
    }

    public Integer getActiOrder() {
        return actiOrder;
    }

    public void setActiOrder(Integer actiOrder) {
        this.actiOrder = actiOrder;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
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

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssueAccount() {
        return issueAccount;
    }

    public void setIssueAccount(String issueAccount) {
        this.issueAccount = issueAccount;
    }

    public String getShowApplyNum() {
        return showApplyNum;
    }

    public void setShowApplyNum(String showApplyNum) {
        this.showApplyNum = showApplyNum;
    }

    public String getApplyCheck() {
        return applyCheck;
    }

    public void setApplyCheck(String applyCheck) {
        this.applyCheck = applyCheck;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actiType=").append(actiType);
        sb.append(", actiName=").append(actiName);
        sb.append(", actiStartTime=").append(actiStartTime);
        sb.append(", actiEndTime=").append(actiEndTime);
        sb.append(", applyStartTime=").append(applyStartTime);
        sb.append(", applyEndTime=").append(applyEndTime);
        sb.append(", mesSendTime=").append(mesSendTime);
        sb.append(", parkId=").append(parkId);
        sb.append(", actiAddress=").append(actiAddress);
        sb.append(", actiCost=").append(actiCost);
        sb.append(", actiOrganizer=").append(actiOrganizer);
        sb.append(", actiNumber=").append(actiNumber);
        sb.append(", actiPosterUrl=").append(actiPosterUrl);
        sb.append(", actiStatus=").append(actiStatus);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", actiViews=").append(actiViews);
        sb.append(", actiLike=").append(actiLike);
        sb.append(", applyNum=").append(applyNum);
        sb.append(", particNum=").append(particNum);
        sb.append(", isIndex=").append(isIndex);
        sb.append(", isApply=").append(isApply);
        sb.append(", actiOrder=").append(actiOrder);
        sb.append(", issueTime=").append(issueTime);
        sb.append(", issueAccount=").append(issueAccount);
        sb.append(", showApplyNum=").append(showApplyNum);
        sb.append(", applyCheck=").append(applyCheck);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}