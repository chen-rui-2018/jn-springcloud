package com.jn.park.asset.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbRoomOrders implements Serializable {
    /*@ApiModelProperty("订单编号")*/
    private String id;

    /*@ApiModelProperty("租借企业id")*/
    private String enterpriseId;

    /*@ApiModelProperty("租借企业")*/
    private String leaseEnterprise;

    /*@ApiModelProperty("开始租借时间")*/
    private Date leaseStartTime;

    /*@ApiModelProperty("租借结束时间")*/
    private Date leaseEndTime;

    /*@ApiModelProperty("企业联系人")*/
    private String contactName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactPhone;

    /*@ApiModelProperty("付款金额")*/
    private BigDecimal paySum;

    /*@ApiModelProperty("支付状态(0未付款,1已付款)(")*/
    private Byte payState;

    /*@ApiModelProperty("房间状态(0空闲,1租借申请中,2租借中,3退租申请中,4已到期)")*/
    private Byte roomStatus;

    /*@ApiModelProperty("申请时间")*/
    private Date applyTime;

    /*@ApiModelProperty("退租违约金")*/
    private BigDecimal quitPenalSum;

    /*@ApiModelProperty("说明")*/
    private String explain;

    /*@ApiModelProperty("意见")*/
    private String approvalOpinion;

    /*@ApiModelProperty("实际退租时间")*/
    private Date practicalQuitTime;

    /*@ApiModelProperty("租赁申请状态(0申请失败,1申请中,2申请成功)")*/
    private Byte leaseApplyStatus;

    /*@ApiModelProperty("退租申请状态(0申请失败,1申请中,2申请成功)")*/
    private Byte quitApplyStatus;

    /*@ApiModelProperty("是否是续租订单(0不是续租订单,1是续租订单)")*/
    private Byte isRelet;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

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

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
    }

    public String getLeaseEnterprise() {
        return leaseEnterprise;
    }

    public void setLeaseEnterprise(String leaseEnterprise) {
        this.leaseEnterprise = leaseEnterprise == null ? null : leaseEnterprise.trim();
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public Date getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(Date leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    public Byte getPayState() {
        return payState;
    }

    public void setPayState(Byte payState) {
        this.payState = payState;
    }

    public Byte getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Byte roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public BigDecimal getQuitPenalSum() {
        return quitPenalSum;
    }

    public void setQuitPenalSum(BigDecimal quitPenalSum) {
        this.quitPenalSum = quitPenalSum;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
    }

    public Date getPracticalQuitTime() {
        return practicalQuitTime;
    }

    public void setPracticalQuitTime(Date practicalQuitTime) {
        this.practicalQuitTime = practicalQuitTime;
    }

    public Byte getLeaseApplyStatus() {
        return leaseApplyStatus;
    }

    public void setLeaseApplyStatus(Byte leaseApplyStatus) {
        this.leaseApplyStatus = leaseApplyStatus;
    }

    public Byte getQuitApplyStatus() {
        return quitApplyStatus;
    }

    public void setQuitApplyStatus(Byte quitApplyStatus) {
        this.quitApplyStatus = quitApplyStatus;
    }

    public Byte getIsRelet() {
        return isRelet;
    }

    public void setIsRelet(Byte isRelet) {
        this.isRelet = isRelet;
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
        TbRoomOrders other = (TbRoomOrders) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getLeaseEnterprise() == null ? other.getLeaseEnterprise() == null : this.getLeaseEnterprise().equals(other.getLeaseEnterprise()))
            && (this.getLeaseStartTime() == null ? other.getLeaseStartTime() == null : this.getLeaseStartTime().equals(other.getLeaseStartTime()))
            && (this.getLeaseEndTime() == null ? other.getLeaseEndTime() == null : this.getLeaseEndTime().equals(other.getLeaseEndTime()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getPaySum() == null ? other.getPaySum() == null : this.getPaySum().equals(other.getPaySum()))
            && (this.getPayState() == null ? other.getPayState() == null : this.getPayState().equals(other.getPayState()))
            && (this.getRoomStatus() == null ? other.getRoomStatus() == null : this.getRoomStatus().equals(other.getRoomStatus()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getQuitPenalSum() == null ? other.getQuitPenalSum() == null : this.getQuitPenalSum().equals(other.getQuitPenalSum()))
            && (this.getExplain() == null ? other.getExplain() == null : this.getExplain().equals(other.getExplain()))
            && (this.getApprovalOpinion() == null ? other.getApprovalOpinion() == null : this.getApprovalOpinion().equals(other.getApprovalOpinion()))
            && (this.getPracticalQuitTime() == null ? other.getPracticalQuitTime() == null : this.getPracticalQuitTime().equals(other.getPracticalQuitTime()))
            && (this.getLeaseApplyStatus() == null ? other.getLeaseApplyStatus() == null : this.getLeaseApplyStatus().equals(other.getLeaseApplyStatus()))
            && (this.getQuitApplyStatus() == null ? other.getQuitApplyStatus() == null : this.getQuitApplyStatus().equals(other.getQuitApplyStatus()))
            && (this.getIsRelet() == null ? other.getIsRelet() == null : this.getIsRelet().equals(other.getIsRelet()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getLeaseEnterprise() == null) ? 0 : getLeaseEnterprise().hashCode());
        result = prime * result + ((getLeaseStartTime() == null) ? 0 : getLeaseStartTime().hashCode());
        result = prime * result + ((getLeaseEndTime() == null) ? 0 : getLeaseEndTime().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getPaySum() == null) ? 0 : getPaySum().hashCode());
        result = prime * result + ((getPayState() == null) ? 0 : getPayState().hashCode());
        result = prime * result + ((getRoomStatus() == null) ? 0 : getRoomStatus().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getQuitPenalSum() == null) ? 0 : getQuitPenalSum().hashCode());
        result = prime * result + ((getExplain() == null) ? 0 : getExplain().hashCode());
        result = prime * result + ((getApprovalOpinion() == null) ? 0 : getApprovalOpinion().hashCode());
        result = prime * result + ((getPracticalQuitTime() == null) ? 0 : getPracticalQuitTime().hashCode());
        result = prime * result + ((getLeaseApplyStatus() == null) ? 0 : getLeaseApplyStatus().hashCode());
        result = prime * result + ((getQuitApplyStatus() == null) ? 0 : getQuitApplyStatus().hashCode());
        result = prime * result + ((getIsRelet() == null) ? 0 : getIsRelet().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
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
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", leaseEnterprise=").append(leaseEnterprise);
        sb.append(", leaseStartTime=").append(leaseStartTime);
        sb.append(", leaseEndTime=").append(leaseEndTime);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", paySum=").append(paySum);
        sb.append(", payState=").append(payState);
        sb.append(", roomStatus=").append(roomStatus);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", quitPenalSum=").append(quitPenalSum);
        sb.append(", explain=").append(explain);
        sb.append(", approvalOpinion=").append(approvalOpinion);
        sb.append(", practicalQuitTime=").append(practicalQuitTime);
        sb.append(", leaseApplyStatus=").append(leaseApplyStatus);
        sb.append(", quitApplyStatus=").append(quitApplyStatus);
        sb.append(", isRelet=").append(isRelet);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}