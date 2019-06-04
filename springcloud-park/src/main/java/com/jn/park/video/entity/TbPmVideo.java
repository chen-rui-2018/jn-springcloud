package com.jn.park.video.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPmVideo implements Serializable {
    /*@ApiModelProperty("主键")*/
    private String id;

    /*@ApiModelProperty("申请企业ID")*/
    private String enterpriseId;

    /*@ApiModelProperty("申请企业名称")*/
    private String enterpriseName;

    /*@ApiModelProperty("联系人")*/
    private String contactMan;

    /*@ApiModelProperty("联系电话")*/
    private String contactPhone;

    /*@ApiModelProperty("申请地址")*/
    private String address;

    /*@ApiModelProperty("工作流-工单编号")*/
    private String flowNo;

    /*@ApiModelProperty("工作流-工单名称")*/
    private String flowTitle;

    /*@ApiModelProperty("工作流-工单状态（0未赋权，1已赋权，2审批不通过）")*/
    private Byte flowStatus;

    /*@ApiModelProperty("录像播放")*/
    private String videoPlay;

    /*@ApiModelProperty("工作流-工单开始时间")*/
    private Date flowStartTime;

    /*@ApiModelProperty("工作流-工单完成时间")*/
    private Date flowCompleteTime;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("申请说明")*/
    private String remarks;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan == null ? null : contactMan.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    public String getFlowTitle() {
        return flowTitle;
    }

    public void setFlowTitle(String flowTitle) {
        this.flowTitle = flowTitle == null ? null : flowTitle.trim();
    }

    public Byte getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(Byte flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getVideoPlay() {
        return videoPlay;
    }

    public void setVideoPlay(String videoPlay) {
        this.videoPlay = videoPlay == null ? null : videoPlay.trim();
    }

    public Date getFlowStartTime() {
        return flowStartTime;
    }

    public void setFlowStartTime(Date flowStartTime) {
        this.flowStartTime = flowStartTime;
    }

    public Date getFlowCompleteTime() {
        return flowCompleteTime;
    }

    public void setFlowCompleteTime(Date flowCompleteTime) {
        this.flowCompleteTime = flowCompleteTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
        TbPmVideo other = (TbPmVideo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getEnterpriseName() == null ? other.getEnterpriseName() == null : this.getEnterpriseName().equals(other.getEnterpriseName()))
            && (this.getContactMan() == null ? other.getContactMan() == null : this.getContactMan().equals(other.getContactMan()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getFlowNo() == null ? other.getFlowNo() == null : this.getFlowNo().equals(other.getFlowNo()))
            && (this.getFlowTitle() == null ? other.getFlowTitle() == null : this.getFlowTitle().equals(other.getFlowTitle()))
            && (this.getFlowStatus() == null ? other.getFlowStatus() == null : this.getFlowStatus().equals(other.getFlowStatus()))
            && (this.getVideoPlay() == null ? other.getVideoPlay() == null : this.getVideoPlay().equals(other.getVideoPlay()))
            && (this.getFlowStartTime() == null ? other.getFlowStartTime() == null : this.getFlowStartTime().equals(other.getFlowStartTime()))
            && (this.getFlowCompleteTime() == null ? other.getFlowCompleteTime() == null : this.getFlowCompleteTime().equals(other.getFlowCompleteTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getEnterpriseName() == null) ? 0 : getEnterpriseName().hashCode());
        result = prime * result + ((getContactMan() == null) ? 0 : getContactMan().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getFlowNo() == null) ? 0 : getFlowNo().hashCode());
        result = prime * result + ((getFlowTitle() == null) ? 0 : getFlowTitle().hashCode());
        result = prime * result + ((getFlowStatus() == null) ? 0 : getFlowStatus().hashCode());
        result = prime * result + ((getVideoPlay() == null) ? 0 : getVideoPlay().hashCode());
        result = prime * result + ((getFlowStartTime() == null) ? 0 : getFlowStartTime().hashCode());
        result = prime * result + ((getFlowCompleteTime() == null) ? 0 : getFlowCompleteTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", contactMan=").append(contactMan);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", address=").append(address);
        sb.append(", flowNo=").append(flowNo);
        sb.append(", flowTitle=").append(flowTitle);
        sb.append(", flowStatus=").append(flowStatus);
        sb.append(", videoPlay=").append(videoPlay);
        sb.append(", flowStartTime=").append(flowStartTime);
        sb.append(", flowCompleteTime=").append(flowCompleteTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}