package com.jn.park.asset.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbRoomOrdersBill implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("订单id")*/
    private String orderId;

    /*@ApiModelProperty("缴费企业")*/
    private String leaseEnterprise;

    /*@ApiModelProperty("企业联系人")*/
    private String contactName;

    /*@ApiModelProperty("企业联系人号码")*/
    private String contactPhone;

    /*@ApiModelProperty("账单生成时间")*/
    private Date billCreateTime;

    /*@ApiModelProperty("房间")*/
    private String rooms;

    /*@ApiModelProperty("账单初始金额")*/
    private BigDecimal billInitSum;

    /*@ApiModelProperty("缴费单生成状态(0未生成,1已生成)")*/
    private Byte billStatus;

    /*@ApiModelProperty("缴费单金额")*/
    private BigDecimal billSum;

    /*@ApiModelProperty("账单确认生成时间")*/
    private Date billConfirmTime;

    /*@ApiModelProperty("确认生成人")*/
    private String billConfirmName;

    /*@ApiModelProperty("开始时间")*/
    private Date startTime;

    /*@ApiModelProperty("结束时间")*/
    private Date endTime;

    /*@ApiModelProperty("账单周期")*/
    private String billCycle;

    /*@ApiModelProperty("缴费状态(0未缴费,1已缴费)")*/
    private Byte paySum;

    /*@ApiModelProperty("缴费时间")*/
    private Date payTime;

    /*@ApiModelProperty("说明")*/
    private String explain;

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getLeaseEnterprise() {
        return leaseEnterprise;
    }

    public void setLeaseEnterprise(String leaseEnterprise) {
        this.leaseEnterprise = leaseEnterprise == null ? null : leaseEnterprise.trim();
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

    public Date getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(Date billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms == null ? null : rooms.trim();
    }

    public BigDecimal getBillInitSum() {
        return billInitSum;
    }

    public void setBillInitSum(BigDecimal billInitSum) {
        this.billInitSum = billInitSum;
    }

    public Byte getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Byte billStatus) {
        this.billStatus = billStatus;
    }

    public BigDecimal getBillSum() {
        return billSum;
    }

    public void setBillSum(BigDecimal billSum) {
        this.billSum = billSum;
    }

    public Date getBillConfirmTime() {
        return billConfirmTime;
    }

    public void setBillConfirmTime(Date billConfirmTime) {
        this.billConfirmTime = billConfirmTime;
    }

    public String getBillConfirmName() {
        return billConfirmName;
    }

    public void setBillConfirmName(String billConfirmName) {
        this.billConfirmName = billConfirmName == null ? null : billConfirmName.trim();
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

    public String getBillCycle() {
        return billCycle;
    }

    public void setBillCycle(String billCycle) {
        this.billCycle = billCycle == null ? null : billCycle.trim();
    }

    public Byte getPaySum() {
        return paySum;
    }

    public void setPaySum(Byte paySum) {
        this.paySum = paySum;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
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
        TbRoomOrdersBill other = (TbRoomOrdersBill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getLeaseEnterprise() == null ? other.getLeaseEnterprise() == null : this.getLeaseEnterprise().equals(other.getLeaseEnterprise()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getBillCreateTime() == null ? other.getBillCreateTime() == null : this.getBillCreateTime().equals(other.getBillCreateTime()))
            && (this.getRooms() == null ? other.getRooms() == null : this.getRooms().equals(other.getRooms()))
            && (this.getBillInitSum() == null ? other.getBillInitSum() == null : this.getBillInitSum().equals(other.getBillInitSum()))
            && (this.getBillStatus() == null ? other.getBillStatus() == null : this.getBillStatus().equals(other.getBillStatus()))
            && (this.getBillSum() == null ? other.getBillSum() == null : this.getBillSum().equals(other.getBillSum()))
            && (this.getBillConfirmTime() == null ? other.getBillConfirmTime() == null : this.getBillConfirmTime().equals(other.getBillConfirmTime()))
            && (this.getBillConfirmName() == null ? other.getBillConfirmName() == null : this.getBillConfirmName().equals(other.getBillConfirmName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getBillCycle() == null ? other.getBillCycle() == null : this.getBillCycle().equals(other.getBillCycle()))
            && (this.getPaySum() == null ? other.getPaySum() == null : this.getPaySum().equals(other.getPaySum()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getExplain() == null ? other.getExplain() == null : this.getExplain().equals(other.getExplain()))
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
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getLeaseEnterprise() == null) ? 0 : getLeaseEnterprise().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getBillCreateTime() == null) ? 0 : getBillCreateTime().hashCode());
        result = prime * result + ((getRooms() == null) ? 0 : getRooms().hashCode());
        result = prime * result + ((getBillInitSum() == null) ? 0 : getBillInitSum().hashCode());
        result = prime * result + ((getBillStatus() == null) ? 0 : getBillStatus().hashCode());
        result = prime * result + ((getBillSum() == null) ? 0 : getBillSum().hashCode());
        result = prime * result + ((getBillConfirmTime() == null) ? 0 : getBillConfirmTime().hashCode());
        result = prime * result + ((getBillConfirmName() == null) ? 0 : getBillConfirmName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getBillCycle() == null) ? 0 : getBillCycle().hashCode());
        result = prime * result + ((getPaySum() == null) ? 0 : getPaySum().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getExplain() == null) ? 0 : getExplain().hashCode());
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
        sb.append(", orderId=").append(orderId);
        sb.append(", leaseEnterprise=").append(leaseEnterprise);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", billCreateTime=").append(billCreateTime);
        sb.append(", rooms=").append(rooms);
        sb.append(", billInitSum=").append(billInitSum);
        sb.append(", billStatus=").append(billStatus);
        sb.append(", billSum=").append(billSum);
        sb.append(", billConfirmTime=").append(billConfirmTime);
        sb.append(", billConfirmName=").append(billConfirmName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", billCycle=").append(billCycle);
        sb.append(", paySum=").append(paySum);
        sb.append(", payTime=").append(payTime);
        sb.append(", explain=").append(explain);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}