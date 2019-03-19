package com.jn.park.approve.entity;

import java.io.Serializable;
import java.util.Date;

public class TbApproveGuideContent implements Serializable {
    /*@ApiModelProperty("内容ID")*/
    private Integer guideId;

    /*@ApiModelProperty("字数")*/
    private String wordCount;

    /*@ApiModelProperty("事项描述")*/
    private String description;

    /*@ApiModelProperty("承诺办理时限（工作日）")*/
    private Integer dealDays;

    /*@ApiModelProperty("受理地址")*/
    private String dealAddress;

    /*@ApiModelProperty("受理时间")*/
    private String dealTime;

    /*@ApiModelProperty("联系电话")*/
    private String linkPhone;

    /*@ApiModelProperty("在线办理地址")*/
    private String dealOnlineUrl;

    /*@ApiModelProperty("是否支持在线留言受理方式(0不支持，1支持)")*/
    private Byte isDealModelOfMessage;

    /*@ApiModelProperty("是否支持QQ群受理方式(0不支持，1支持)")*/
    private Byte isDealModelOfQqGroup;

    /*@ApiModelProperty("QQ群号码")*/
    private String qqGroupNumber;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("详细信息")*/
    private String detail;

    private static final long serialVersionUID = 1L;

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public String getWordCount() {
        return wordCount;
    }

    public void setWordCount(String wordCount) {
        this.wordCount = wordCount == null ? null : wordCount.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getDealDays() {
        return dealDays;
    }

    public void setDealDays(Integer dealDays) {
        this.dealDays = dealDays;
    }

    public String getDealAddress() {
        return dealAddress;
    }

    public void setDealAddress(String dealAddress) {
        this.dealAddress = dealAddress == null ? null : dealAddress.trim();
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime == null ? null : dealTime.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getDealOnlineUrl() {
        return dealOnlineUrl;
    }

    public void setDealOnlineUrl(String dealOnlineUrl) {
        this.dealOnlineUrl = dealOnlineUrl == null ? null : dealOnlineUrl.trim();
    }

    public Byte getIsDealModelOfMessage() {
        return isDealModelOfMessage;
    }

    public void setIsDealModelOfMessage(Byte isDealModelOfMessage) {
        this.isDealModelOfMessage = isDealModelOfMessage;
    }

    public Byte getIsDealModelOfQqGroup() {
        return isDealModelOfQqGroup;
    }

    public void setIsDealModelOfQqGroup(Byte isDealModelOfQqGroup) {
        this.isDealModelOfQqGroup = isDealModelOfQqGroup;
    }

    public String getQqGroupNumber() {
        return qqGroupNumber;
    }

    public void setQqGroupNumber(String qqGroupNumber) {
        this.qqGroupNumber = qqGroupNumber == null ? null : qqGroupNumber.trim();
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
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
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
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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
        TbApproveGuideContent other = (TbApproveGuideContent) that;
        return (this.getGuideId() == null ? other.getGuideId() == null : this.getGuideId().equals(other.getGuideId()))
            && (this.getWordCount() == null ? other.getWordCount() == null : this.getWordCount().equals(other.getWordCount()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getDealDays() == null ? other.getDealDays() == null : this.getDealDays().equals(other.getDealDays()))
            && (this.getDealAddress() == null ? other.getDealAddress() == null : this.getDealAddress().equals(other.getDealAddress()))
            && (this.getDealTime() == null ? other.getDealTime() == null : this.getDealTime().equals(other.getDealTime()))
            && (this.getLinkPhone() == null ? other.getLinkPhone() == null : this.getLinkPhone().equals(other.getLinkPhone()))
            && (this.getDealOnlineUrl() == null ? other.getDealOnlineUrl() == null : this.getDealOnlineUrl().equals(other.getDealOnlineUrl()))
            && (this.getIsDealModelOfMessage() == null ? other.getIsDealModelOfMessage() == null : this.getIsDealModelOfMessage().equals(other.getIsDealModelOfMessage()))
            && (this.getIsDealModelOfQqGroup() == null ? other.getIsDealModelOfQqGroup() == null : this.getIsDealModelOfQqGroup().equals(other.getIsDealModelOfQqGroup()))
            && (this.getQqGroupNumber() == null ? other.getQqGroupNumber() == null : this.getQqGroupNumber().equals(other.getQqGroupNumber()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuideId() == null) ? 0 : getGuideId().hashCode());
        result = prime * result + ((getWordCount() == null) ? 0 : getWordCount().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getDealDays() == null) ? 0 : getDealDays().hashCode());
        result = prime * result + ((getDealAddress() == null) ? 0 : getDealAddress().hashCode());
        result = prime * result + ((getDealTime() == null) ? 0 : getDealTime().hashCode());
        result = prime * result + ((getLinkPhone() == null) ? 0 : getLinkPhone().hashCode());
        result = prime * result + ((getDealOnlineUrl() == null) ? 0 : getDealOnlineUrl().hashCode());
        result = prime * result + ((getIsDealModelOfMessage() == null) ? 0 : getIsDealModelOfMessage().hashCode());
        result = prime * result + ((getIsDealModelOfQqGroup() == null) ? 0 : getIsDealModelOfQqGroup().hashCode());
        result = prime * result + ((getQqGroupNumber() == null) ? 0 : getQqGroupNumber().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guideId=").append(guideId);
        sb.append(", wordCount=").append(wordCount);
        sb.append(", description=").append(description);
        sb.append(", dealDays=").append(dealDays);
        sb.append(", dealAddress=").append(dealAddress);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", linkPhone=").append(linkPhone);
        sb.append(", dealOnlineUrl=").append(dealOnlineUrl);
        sb.append(", isDealModelOfMessage=").append(isDealModelOfMessage);
        sb.append(", isDealModelOfQqGroup=").append(isDealModelOfQqGroup);
        sb.append(", qqGroupNumber=").append(qqGroupNumber);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", detail=").append(detail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}