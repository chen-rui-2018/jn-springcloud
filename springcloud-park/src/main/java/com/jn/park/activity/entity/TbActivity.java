package com.jn.park.activity.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbActivity implements Serializable {
    private String id;

    private String actiType;

    private String actiName;

    private Date actiStartTime;

    private Date actiEndTime;

    private Date applyStartTime;

    private Date applyEndTime;

    private Date mesSendTime;

    private String parkId;

    private String actiAddress;

    private BigDecimal actiCost;

    private String actiOrganizer;

    private String actiGuideOrganizer;

    private String actiUndertakeOrganizer;

    private String actiCoOrganizer;

    private Integer actiNumber;

    private String actiPosterUrl;

    private String actiStatus;

    private Date createdTime;

    private String creatorAccount;

    private Date modifiedTime;

    private String modifierAccount;

    private Integer actiViews;

    private Integer actiLike;

    private Integer applyNum;

    private Integer particNum;

    private String isIndex;

    private String isApply;

    private Integer actiOrder;

    private Date issueTime;

    private String issueAccount;

    private String showApplyNum;

    private String applyCheck;

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

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId == null ? null : parkId.trim();
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

    public String getActiGuideOrganizer() {
        return actiGuideOrganizer;
    }

    public void setActiGuideOrganizer(String actiGuideOrganizer) {
        this.actiGuideOrganizer = actiGuideOrganizer == null ? null : actiGuideOrganizer.trim();
    }

    public String getActiUndertakeOrganizer() {
        return actiUndertakeOrganizer;
    }

    public void setActiUndertakeOrganizer(String actiUndertakeOrganizer) {
        this.actiUndertakeOrganizer = actiUndertakeOrganizer == null ? null : actiUndertakeOrganizer.trim();
    }

    public String getActiCoOrganizer() {
        return actiCoOrganizer;
    }

    public void setActiCoOrganizer(String actiCoOrganizer) {
        this.actiCoOrganizer = actiCoOrganizer == null ? null : actiCoOrganizer.trim();
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

    public String getActiStatus() {
        return actiStatus;
    }

    public void setActiStatus(String actiStatus) {
        this.actiStatus = actiStatus == null ? null : actiStatus.trim();
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
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
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
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
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

    public String getIsIndex() {
        return isIndex;
    }

    public void setIsIndex(String isIndex) {
        this.isIndex = isIndex == null ? null : isIndex.trim();
    }

    public String getIsApply() {
        return isApply;
    }

    public void setIsApply(String isApply) {
        this.isApply = isApply == null ? null : isApply.trim();
    }

    public Integer getActiOrder() {
        return actiOrder;
    }

    public void setActiOrder(Integer actiOrder) {
        this.actiOrder = actiOrder;
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
        this.issueAccount = issueAccount == null ? null : issueAccount.trim();
    }

    public String getShowApplyNum() {
        return showApplyNum;
    }

    public void setShowApplyNum(String showApplyNum) {
        this.showApplyNum = showApplyNum == null ? null : showApplyNum.trim();
    }

    public String getApplyCheck() {
        return applyCheck;
    }

    public void setApplyCheck(String applyCheck) {
        this.applyCheck = applyCheck == null ? null : applyCheck.trim();
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbActivity other = (TbActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActiType() == null ? other.getActiType() == null : this.getActiType().equals(other.getActiType()))
            && (this.getActiName() == null ? other.getActiName() == null : this.getActiName().equals(other.getActiName()))
            && (this.getActiStartTime() == null ? other.getActiStartTime() == null : this.getActiStartTime().equals(other.getActiStartTime()))
            && (this.getActiEndTime() == null ? other.getActiEndTime() == null : this.getActiEndTime().equals(other.getActiEndTime()))
            && (this.getApplyStartTime() == null ? other.getApplyStartTime() == null : this.getApplyStartTime().equals(other.getApplyStartTime()))
            && (this.getApplyEndTime() == null ? other.getApplyEndTime() == null : this.getApplyEndTime().equals(other.getApplyEndTime()))
            && (this.getMesSendTime() == null ? other.getMesSendTime() == null : this.getMesSendTime().equals(other.getMesSendTime()))
            && (this.getParkId() == null ? other.getParkId() == null : this.getParkId().equals(other.getParkId()))
            && (this.getActiAddress() == null ? other.getActiAddress() == null : this.getActiAddress().equals(other.getActiAddress()))
            && (this.getActiCost() == null ? other.getActiCost() == null : this.getActiCost().equals(other.getActiCost()))
            && (this.getActiOrganizer() == null ? other.getActiOrganizer() == null : this.getActiOrganizer().equals(other.getActiOrganizer()))
            && (this.getActiGuideOrganizer() == null ? other.getActiGuideOrganizer() == null : this.getActiGuideOrganizer().equals(other.getActiGuideOrganizer()))
            && (this.getActiUndertakeOrganizer() == null ? other.getActiUndertakeOrganizer() == null : this.getActiUndertakeOrganizer().equals(other.getActiUndertakeOrganizer()))
            && (this.getActiCoOrganizer() == null ? other.getActiCoOrganizer() == null : this.getActiCoOrganizer().equals(other.getActiCoOrganizer()))
            && (this.getActiNumber() == null ? other.getActiNumber() == null : this.getActiNumber().equals(other.getActiNumber()))
            && (this.getActiPosterUrl() == null ? other.getActiPosterUrl() == null : this.getActiPosterUrl().equals(other.getActiPosterUrl()))
            && (this.getActiStatus() == null ? other.getActiStatus() == null : this.getActiStatus().equals(other.getActiStatus()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getActiViews() == null ? other.getActiViews() == null : this.getActiViews().equals(other.getActiViews()))
            && (this.getActiLike() == null ? other.getActiLike() == null : this.getActiLike().equals(other.getActiLike()))
            && (this.getApplyNum() == null ? other.getApplyNum() == null : this.getApplyNum().equals(other.getApplyNum()))
            && (this.getParticNum() == null ? other.getParticNum() == null : this.getParticNum().equals(other.getParticNum()))
            && (this.getIsIndex() == null ? other.getIsIndex() == null : this.getIsIndex().equals(other.getIsIndex()))
            && (this.getIsApply() == null ? other.getIsApply() == null : this.getIsApply().equals(other.getIsApply()))
            && (this.getActiOrder() == null ? other.getActiOrder() == null : this.getActiOrder().equals(other.getActiOrder()))
            && (this.getIssueTime() == null ? other.getIssueTime() == null : this.getIssueTime().equals(other.getIssueTime()))
            && (this.getIssueAccount() == null ? other.getIssueAccount() == null : this.getIssueAccount().equals(other.getIssueAccount()))
            && (this.getShowApplyNum() == null ? other.getShowApplyNum() == null : this.getShowApplyNum().equals(other.getShowApplyNum()))
            && (this.getApplyCheck() == null ? other.getApplyCheck() == null : this.getApplyCheck().equals(other.getApplyCheck()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActiType() == null) ? 0 : getActiType().hashCode());
        result = prime * result + ((getActiName() == null) ? 0 : getActiName().hashCode());
        result = prime * result + ((getActiStartTime() == null) ? 0 : getActiStartTime().hashCode());
        result = prime * result + ((getActiEndTime() == null) ? 0 : getActiEndTime().hashCode());
        result = prime * result + ((getApplyStartTime() == null) ? 0 : getApplyStartTime().hashCode());
        result = prime * result + ((getApplyEndTime() == null) ? 0 : getApplyEndTime().hashCode());
        result = prime * result + ((getMesSendTime() == null) ? 0 : getMesSendTime().hashCode());
        result = prime * result + ((getParkId() == null) ? 0 : getParkId().hashCode());
        result = prime * result + ((getActiAddress() == null) ? 0 : getActiAddress().hashCode());
        result = prime * result + ((getActiCost() == null) ? 0 : getActiCost().hashCode());
        result = prime * result + ((getActiOrganizer() == null) ? 0 : getActiOrganizer().hashCode());
        result = prime * result + ((getActiGuideOrganizer() == null) ? 0 : getActiGuideOrganizer().hashCode());
        result = prime * result + ((getActiUndertakeOrganizer() == null) ? 0 : getActiUndertakeOrganizer().hashCode());
        result = prime * result + ((getActiCoOrganizer() == null) ? 0 : getActiCoOrganizer().hashCode());
        result = prime * result + ((getActiNumber() == null) ? 0 : getActiNumber().hashCode());
        result = prime * result + ((getActiPosterUrl() == null) ? 0 : getActiPosterUrl().hashCode());
        result = prime * result + ((getActiStatus() == null) ? 0 : getActiStatus().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getActiViews() == null) ? 0 : getActiViews().hashCode());
        result = prime * result + ((getActiLike() == null) ? 0 : getActiLike().hashCode());
        result = prime * result + ((getApplyNum() == null) ? 0 : getApplyNum().hashCode());
        result = prime * result + ((getParticNum() == null) ? 0 : getParticNum().hashCode());
        result = prime * result + ((getIsIndex() == null) ? 0 : getIsIndex().hashCode());
        result = prime * result + ((getIsApply() == null) ? 0 : getIsApply().hashCode());
        result = prime * result + ((getActiOrder() == null) ? 0 : getActiOrder().hashCode());
        result = prime * result + ((getIssueTime() == null) ? 0 : getIssueTime().hashCode());
        result = prime * result + ((getIssueAccount() == null) ? 0 : getIssueAccount().hashCode());
        result = prime * result + ((getShowApplyNum() == null) ? 0 : getShowApplyNum().hashCode());
        result = prime * result + ((getApplyCheck() == null) ? 0 : getApplyCheck().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
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
        sb.append(", actiGuideOrganizer=").append(actiGuideOrganizer);
        sb.append(", actiUndertakeOrganizer=").append(actiUndertakeOrganizer);
        sb.append(", actiCoOrganizer=").append(actiCoOrganizer);
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