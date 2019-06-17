package com.jn.park.park.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPark implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("")*/
    private String parentId;

    /*@ApiModelProperty("园区名称")*/
    private String parkName;

    /*@ApiModelProperty("园区宣传图片（主要 一张）")*/
    private String mainPicture;

    /*@ApiModelProperty("园区宣传图片（次要 最多五张）")*/
    private String minorPicture;

    /*@ApiModelProperty("园区的发布状态（0代表未发布，1发布，2失效)")*/
    private String parkState;

    /*@ApiModelProperty("园区企业入驻情况（0没有，1有，2正在走流程）")*/
    private String isEnter;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private String recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("园区介绍")*/
    private String parkIntroduce;

    /*@ApiModelProperty("园区简短介绍（列表页显示）")*/
    private String shortIntroduce;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture == null ? null : mainPicture.trim();
    }

    public String getMinorPicture() {
        return minorPicture;
    }

    public void setMinorPicture(String minorPicture) {
        this.minorPicture = minorPicture == null ? null : minorPicture.trim();
    }

    public String getParkState() {
        return parkState;
    }

    public void setParkState(String parkState) {
        this.parkState = parkState == null ? null : parkState.trim();
    }

    public String getIsEnter() {
        return isEnter;
    }

    public void setIsEnter(String isEnter) {
        this.isEnter = isEnter == null ? null : isEnter.trim();
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public String getShortIntroduce() {
        return shortIntroduce;
    }

    public void setShortIntroduce(String shortIntroduce) {
        this.shortIntroduce = shortIntroduce;
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

    public String getParkIntroduce() {
        return parkIntroduce;
    }

    public void setParkIntroduce(String parkIntroduce) {
        this.parkIntroduce = parkIntroduce == null ? null : parkIntroduce.trim();
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
        TbPark other = (TbPark) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getParkName() == null ? other.getParkName() == null : this.getParkName().equals(other.getParkName()))
            && (this.getMainPicture() == null ? other.getMainPicture() == null : this.getMainPicture().equals(other.getMainPicture()))
            && (this.getMinorPicture() == null ? other.getMinorPicture() == null : this.getMinorPicture().equals(other.getMinorPicture()))
            && (this.getParkState() == null ? other.getParkState() == null : this.getParkState().equals(other.getParkState()))
            && (this.getIsEnter() == null ? other.getIsEnter() == null : this.getIsEnter().equals(other.getIsEnter()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getParkIntroduce() == null ? other.getParkIntroduce() == null : this.getParkIntroduce().equals(other.getParkIntroduce()))
            && (this.getShortIntroduce() == null ? other.getShortIntroduce() == null : this.getShortIntroduce().equals(other.getShortIntroduce()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParkName() == null) ? 0 : getParkName().hashCode());
        result = prime * result + ((getMainPicture() == null) ? 0 : getMainPicture().hashCode());
        result = prime * result + ((getMinorPicture() == null) ? 0 : getMinorPicture().hashCode());
        result = prime * result + ((getParkState() == null) ? 0 : getParkState().hashCode());
        result = prime * result + ((getIsEnter() == null) ? 0 : getIsEnter().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getParkIntroduce() == null) ? 0 : getParkIntroduce().hashCode());
        result = prime * result + ((getShortIntroduce() == null) ? 0 : getShortIntroduce().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", parkName=").append(parkName);
        sb.append(", mainPicture=").append(mainPicture);
        sb.append(", minorPicture=").append(minorPicture);
        sb.append(", parkState=").append(parkState);
        sb.append(", isEnter=").append(isEnter);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", parkIntroduce=").append(parkIntroduce);
        sb.append(", shortIntroduce=").append(shortIntroduce);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}