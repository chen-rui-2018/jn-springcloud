package com.jn.park.attractinvest.entity;

import java.io.Serializable;
import java.util.Date;

public class TbBusinessAdContent implements Serializable {
    private String id;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccoun;

    private Date modifiedTime;

    private String title;

    private String adCover;

    private String adPosition;

    private Date startTime;

    private Date endTime;

    private String subTitle;

    private String adFlag;

    private String park;

    private String parkName;

    private String modAccoun;

    private String modTime;

    private String content;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getModifierAccoun() {
        return modifierAccoun;
    }

    public void setModifierAccoun(String modifierAccoun) {
        this.modifierAccoun = modifierAccoun == null ? null : modifierAccoun.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAdCover() {
        return adCover;
    }

    public void setAdCover(String adCover) {
        this.adCover = adCover == null ? null : adCover.trim();
    }

    public String getAdPosition() {
        return adPosition;
    }

    public void setAdPosition(String adPosition) {
        this.adPosition = adPosition == null ? null : adPosition.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getAdFlag() {
        return adFlag;
    }

    public void setAdFlag(String adFlag) {
        this.adFlag = adFlag == null ? null : adFlag.trim();
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park == null ? null : park.trim();
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public String getModAccoun() {
        return modAccoun;
    }

    public void setModAccoun(String modAccoun) {
        this.modAccoun = modAccoun == null ? null : modAccoun.trim();
    }

    public String getModTime() {
        return modTime;
    }

    public void setModTime(String modTime) {
        this.modTime = modTime == null ? null : modTime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        TbBusinessAdContent other = (TbBusinessAdContent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccoun() == null ? other.getModifierAccoun() == null : this.getModifierAccoun().equals(other.getModifierAccoun()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getAdCover() == null ? other.getAdCover() == null : this.getAdCover().equals(other.getAdCover()))
            && (this.getAdPosition() == null ? other.getAdPosition() == null : this.getAdPosition().equals(other.getAdPosition()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle()))
            && (this.getAdFlag() == null ? other.getAdFlag() == null : this.getAdFlag().equals(other.getAdFlag()))
            && (this.getPark() == null ? other.getPark() == null : this.getPark().equals(other.getPark()))
            && (this.getParkName() == null ? other.getParkName() == null : this.getParkName().equals(other.getParkName()))
            && (this.getModAccoun() == null ? other.getModAccoun() == null : this.getModAccoun().equals(other.getModAccoun()))
            && (this.getModTime() == null ? other.getModTime() == null : this.getModTime().equals(other.getModTime()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccoun() == null) ? 0 : getModifierAccoun().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAdCover() == null) ? 0 : getAdCover().hashCode());
        result = prime * result + ((getAdPosition() == null) ? 0 : getAdPosition().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getAdFlag() == null) ? 0 : getAdFlag().hashCode());
        result = prime * result + ((getPark() == null) ? 0 : getPark().hashCode());
        result = prime * result + ((getParkName() == null) ? 0 : getParkName().hashCode());
        result = prime * result + ((getModAccoun() == null) ? 0 : getModAccoun().hashCode());
        result = prime * result + ((getModTime() == null) ? 0 : getModTime().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccoun=").append(modifierAccoun);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", title=").append(title);
        sb.append(", adCover=").append(adCover);
        sb.append(", adPosition=").append(adPosition);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", adFlag=").append(adFlag);
        sb.append(", park=").append(park);
        sb.append(", parkName=").append(parkName);
        sb.append(", modAccoun=").append(modAccoun);
        sb.append(", modTime=").append(modTime);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}