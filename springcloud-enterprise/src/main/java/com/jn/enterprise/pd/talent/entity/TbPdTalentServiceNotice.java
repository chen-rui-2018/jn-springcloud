package com.jn.enterprise.pd.talent.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdTalentServiceNotice implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private String id;

    /*@ApiModelProperty("公告标题")*/
    private String noticeTitle;

    /*@ApiModelProperty("所属类型ID")*/
    private String rangeId;

    /*@ApiModelProperty("所属类型名称")*/
    private String rangeName;

    /*@ApiModelProperty("所属平台ID")*/
    private String subordinatePlatformId;

    /*@ApiModelProperty("所属平台名称")*/
    private String subordinatePlatformName;

    /*@ApiModelProperty("截止时间")*/
    private Date deadline;

    /*@ApiModelProperty("截止描述")*/
    private String timeNode;

    /*@ApiModelProperty("是否置顶（1：置顶，2：不置顶）")*/
    private Byte isRoofPlacement;

    /*@ApiModelProperty("公告简介")*/
    private String briefIntroduct;

    /*@ApiModelProperty("公告内容")*/
    private String announcementContent;

    /*@ApiModelProperty("浏览次数")*/
    private Integer browseTimes;

    /*@ApiModelProperty("状态（1;草稿，2：已发布，3：已下架）")*/
    private Byte status;

    /*@ApiModelProperty("附件地址")*/
    private String fileUrl;

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

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getRangeId() {
        return rangeId;
    }

    public void setRangeId(String rangeId) {
        this.rangeId = rangeId == null ? null : rangeId.trim();
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName == null ? null : rangeName.trim();
    }

    public String getSubordinatePlatformId() {
        return subordinatePlatformId;
    }

    public void setSubordinatePlatformId(String subordinatePlatformId) {
        this.subordinatePlatformId = subordinatePlatformId == null ? null : subordinatePlatformId.trim();
    }

    public String getSubordinatePlatformName() {
        return subordinatePlatformName;
    }

    public void setSubordinatePlatformName(String subordinatePlatformName) {
        this.subordinatePlatformName = subordinatePlatformName == null ? null : subordinatePlatformName.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getTimeNode() {
        return timeNode;
    }

    public void setTimeNode(String timeNode) {
        this.timeNode = timeNode == null ? null : timeNode.trim();
    }

    public Byte getIsRoofPlacement() {
        return isRoofPlacement;
    }

    public void setIsRoofPlacement(Byte isRoofPlacement) {
        this.isRoofPlacement = isRoofPlacement;
    }

    public String getBriefIntroduct() {
        return briefIntroduct;
    }

    public void setBriefIntroduct(String briefIntroduct) {
        this.briefIntroduct = briefIntroduct == null ? null : briefIntroduct.trim();
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent == null ? null : announcementContent.trim();
    }

    public Integer getBrowseTimes() {
        return browseTimes;
    }

    public void setBrowseTimes(Integer browseTimes) {
        this.browseTimes = browseTimes;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
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
        TbPdTalentServiceNotice other = (TbPdTalentServiceNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNoticeTitle() == null ? other.getNoticeTitle() == null : this.getNoticeTitle().equals(other.getNoticeTitle()))
            && (this.getRangeId() == null ? other.getRangeId() == null : this.getRangeId().equals(other.getRangeId()))
            && (this.getRangeName() == null ? other.getRangeName() == null : this.getRangeName().equals(other.getRangeName()))
            && (this.getSubordinatePlatformId() == null ? other.getSubordinatePlatformId() == null : this.getSubordinatePlatformId().equals(other.getSubordinatePlatformId()))
            && (this.getSubordinatePlatformName() == null ? other.getSubordinatePlatformName() == null : this.getSubordinatePlatformName().equals(other.getSubordinatePlatformName()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getTimeNode() == null ? other.getTimeNode() == null : this.getTimeNode().equals(other.getTimeNode()))
            && (this.getIsRoofPlacement() == null ? other.getIsRoofPlacement() == null : this.getIsRoofPlacement().equals(other.getIsRoofPlacement()))
            && (this.getBriefIntroduct() == null ? other.getBriefIntroduct() == null : this.getBriefIntroduct().equals(other.getBriefIntroduct()))
            && (this.getAnnouncementContent() == null ? other.getAnnouncementContent() == null : this.getAnnouncementContent().equals(other.getAnnouncementContent()))
            && (this.getBrowseTimes() == null ? other.getBrowseTimes() == null : this.getBrowseTimes().equals(other.getBrowseTimes()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getFileUrl() == null ? other.getFileUrl() == null : this.getFileUrl().equals(other.getFileUrl()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNoticeTitle() == null) ? 0 : getNoticeTitle().hashCode());
        result = prime * result + ((getRangeId() == null) ? 0 : getRangeId().hashCode());
        result = prime * result + ((getRangeName() == null) ? 0 : getRangeName().hashCode());
        result = prime * result + ((getSubordinatePlatformId() == null) ? 0 : getSubordinatePlatformId().hashCode());
        result = prime * result + ((getSubordinatePlatformName() == null) ? 0 : getSubordinatePlatformName().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getTimeNode() == null) ? 0 : getTimeNode().hashCode());
        result = prime * result + ((getIsRoofPlacement() == null) ? 0 : getIsRoofPlacement().hashCode());
        result = prime * result + ((getBriefIntroduct() == null) ? 0 : getBriefIntroduct().hashCode());
        result = prime * result + ((getAnnouncementContent() == null) ? 0 : getAnnouncementContent().hashCode());
        result = prime * result + ((getBrowseTimes() == null) ? 0 : getBrowseTimes().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getFileUrl() == null) ? 0 : getFileUrl().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", rangeId=").append(rangeId);
        sb.append(", rangeName=").append(rangeName);
        sb.append(", subordinatePlatformId=").append(subordinatePlatformId);
        sb.append(", subordinatePlatformName=").append(subordinatePlatformName);
        sb.append(", deadline=").append(deadline);
        sb.append(", timeNode=").append(timeNode);
        sb.append(", isRoofPlacement=").append(isRoofPlacement);
        sb.append(", briefIntroduct=").append(briefIntroduct);
        sb.append(", announcementContent=").append(announcementContent);
        sb.append(", browseTimes=").append(browseTimes);
        sb.append(", status=").append(status);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}