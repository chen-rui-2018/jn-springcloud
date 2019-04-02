package com.jn.enterprise.pd.declaration.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class TbPdDeclarationNoticeManage implements Serializable {
    /*@ApiModelProperty("唯一标识符（公告ID）")*/
    private String id;

    /*@ApiModelProperty("标题名称")*/
    private String titleName;

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

    /*@ApiModelProperty("联系电话配置")*/
    private String contactPhoneConfiguration;

    /*@ApiModelProperty("浏览次数")*/
    private Integer browseTimes;

    /*@ApiModelProperty("状态（1：草稿，2：已发布，3：已下架）")*/
    private Byte status;

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

    /*@ApiModelProperty("公告内容")*/
    private byte[] announcementContent;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
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

    public String getContactPhoneConfiguration() {
        return contactPhoneConfiguration;
    }

    public void setContactPhoneConfiguration(String contactPhoneConfiguration) {
        this.contactPhoneConfiguration = contactPhoneConfiguration == null ? null : contactPhoneConfiguration.trim();
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

    public byte[] getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(byte[] announcementContent) {
        this.announcementContent = announcementContent;
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
        TbPdDeclarationNoticeManage other = (TbPdDeclarationNoticeManage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitleName() == null ? other.getTitleName() == null : this.getTitleName().equals(other.getTitleName()))
            && (this.getRangeId() == null ? other.getRangeId() == null : this.getRangeId().equals(other.getRangeId()))
            && (this.getRangeName() == null ? other.getRangeName() == null : this.getRangeName().equals(other.getRangeName()))
            && (this.getSubordinatePlatformId() == null ? other.getSubordinatePlatformId() == null : this.getSubordinatePlatformId().equals(other.getSubordinatePlatformId()))
            && (this.getSubordinatePlatformName() == null ? other.getSubordinatePlatformName() == null : this.getSubordinatePlatformName().equals(other.getSubordinatePlatformName()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getTimeNode() == null ? other.getTimeNode() == null : this.getTimeNode().equals(other.getTimeNode()))
            && (this.getIsRoofPlacement() == null ? other.getIsRoofPlacement() == null : this.getIsRoofPlacement().equals(other.getIsRoofPlacement()))
            && (this.getContactPhoneConfiguration() == null ? other.getContactPhoneConfiguration() == null : this.getContactPhoneConfiguration().equals(other.getContactPhoneConfiguration()))
            && (this.getBrowseTimes() == null ? other.getBrowseTimes() == null : this.getBrowseTimes().equals(other.getBrowseTimes()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (Arrays.equals(this.getAnnouncementContent(), other.getAnnouncementContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitleName() == null) ? 0 : getTitleName().hashCode());
        result = prime * result + ((getRangeId() == null) ? 0 : getRangeId().hashCode());
        result = prime * result + ((getRangeName() == null) ? 0 : getRangeName().hashCode());
        result = prime * result + ((getSubordinatePlatformId() == null) ? 0 : getSubordinatePlatformId().hashCode());
        result = prime * result + ((getSubordinatePlatformName() == null) ? 0 : getSubordinatePlatformName().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getTimeNode() == null) ? 0 : getTimeNode().hashCode());
        result = prime * result + ((getIsRoofPlacement() == null) ? 0 : getIsRoofPlacement().hashCode());
        result = prime * result + ((getContactPhoneConfiguration() == null) ? 0 : getContactPhoneConfiguration().hashCode());
        result = prime * result + ((getBrowseTimes() == null) ? 0 : getBrowseTimes().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + (Arrays.hashCode(getAnnouncementContent()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", titleName=").append(titleName);
        sb.append(", rangeId=").append(rangeId);
        sb.append(", rangeName=").append(rangeName);
        sb.append(", subordinatePlatformId=").append(subordinatePlatformId);
        sb.append(", subordinatePlatformName=").append(subordinatePlatformName);
        sb.append(", deadline=").append(deadline);
        sb.append(", timeNode=").append(timeNode);
        sb.append(", isRoofPlacement=").append(isRoofPlacement);
        sb.append(", contactPhoneConfiguration=").append(contactPhoneConfiguration);
        sb.append(", browseTimes=").append(browseTimes);
        sb.append(", status=").append(status);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", announcementContent=").append(announcementContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}