package com.jn.park.pmpaybill.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPmPayBillItem implements Serializable {
    private String id;

    private String billId;

    private String companyId;

    private String companyName;

    private String companyAddress;

    private Byte calcMode;

    private String payPeriod;

    private BigDecimal billAcount;

    private BigDecimal feeAmount;

    private String feeReason;

    private BigDecimal totalAmount;

    private Date lastPayTime;

    private Byte payStatus;

    private Byte isExpire;

    private Byte payType;

    private Byte generateStatus;

    private Byte derateState;

    private Byte sendPayBill;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public Byte getCalcMode() {
        return calcMode;
    }

    public void setCalcMode(Byte calcMode) {
        this.calcMode = calcMode;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod == null ? null : payPeriod.trim();
    }

    public BigDecimal getBillAcount() {
        return billAcount;
    }

    public void setBillAcount(BigDecimal billAcount) {
        this.billAcount = billAcount;
    }

    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeReason() {
        return feeReason;
    }

    public void setFeeReason(String feeReason) {
        this.feeReason = feeReason == null ? null : feeReason.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(Date lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public Byte getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(Byte isExpire) {
        this.isExpire = isExpire;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getGenerateStatus() {
        return generateStatus;
    }

    public void setGenerateStatus(Byte generateStatus) {
        this.generateStatus = generateStatus;
    }

    public Byte getDerateState() {
        return derateState;
    }

    public void setDerateState(Byte derateState) {
        this.derateState = derateState;
    }

    public Byte getSendPayBill() {
        return sendPayBill;
    }

    public void setSendPayBill(Byte sendPayBill) {
        this.sendPayBill = sendPayBill;
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
        TbPmPayBillItem other = (TbPmPayBillItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBillId() == null ? other.getBillId() == null : this.getBillId().equals(other.getBillId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getCalcMode() == null ? other.getCalcMode() == null : this.getCalcMode().equals(other.getCalcMode()))
            && (this.getPayPeriod() == null ? other.getPayPeriod() == null : this.getPayPeriod().equals(other.getPayPeriod()))
            && (this.getBillAcount() == null ? other.getBillAcount() == null : this.getBillAcount().equals(other.getBillAcount()))
            && (this.getFeeAmount() == null ? other.getFeeAmount() == null : this.getFeeAmount().equals(other.getFeeAmount()))
            && (this.getFeeReason() == null ? other.getFeeReason() == null : this.getFeeReason().equals(other.getFeeReason()))
            && (this.getTotalAmount() == null ? other.getTotalAmount() == null : this.getTotalAmount().equals(other.getTotalAmount()))
            && (this.getLastPayTime() == null ? other.getLastPayTime() == null : this.getLastPayTime().equals(other.getLastPayTime()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getIsExpire() == null ? other.getIsExpire() == null : this.getIsExpire().equals(other.getIsExpire()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getGenerateStatus() == null ? other.getGenerateStatus() == null : this.getGenerateStatus().equals(other.getGenerateStatus()))
            && (this.getDerateState() == null ? other.getDerateState() == null : this.getDerateState().equals(other.getDerateState()))
            && (this.getSendPayBill() == null ? other.getSendPayBill() == null : this.getSendPayBill().equals(other.getSendPayBill()))
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
        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getCalcMode() == null) ? 0 : getCalcMode().hashCode());
        result = prime * result + ((getPayPeriod() == null) ? 0 : getPayPeriod().hashCode());
        result = prime * result + ((getBillAcount() == null) ? 0 : getBillAcount().hashCode());
        result = prime * result + ((getFeeAmount() == null) ? 0 : getFeeAmount().hashCode());
        result = prime * result + ((getFeeReason() == null) ? 0 : getFeeReason().hashCode());
        result = prime * result + ((getTotalAmount() == null) ? 0 : getTotalAmount().hashCode());
        result = prime * result + ((getLastPayTime() == null) ? 0 : getLastPayTime().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getIsExpire() == null) ? 0 : getIsExpire().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getGenerateStatus() == null) ? 0 : getGenerateStatus().hashCode());
        result = prime * result + ((getDerateState() == null) ? 0 : getDerateState().hashCode());
        result = prime * result + ((getSendPayBill() == null) ? 0 : getSendPayBill().hashCode());
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
        sb.append(", billId=").append(billId);
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", calcMode=").append(calcMode);
        sb.append(", payPeriod=").append(payPeriod);
        sb.append(", billAcount=").append(billAcount);
        sb.append(", feeAmount=").append(feeAmount);
        sb.append(", feeReason=").append(feeReason);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", lastPayTime=").append(lastPayTime);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", isExpire=").append(isExpire);
        sb.append(", payType=").append(payType);
        sb.append(", generateStatus=").append(generateStatus);
        sb.append(", derateState=").append(derateState);
        sb.append(", sendPayBill=").append(sendPayBill);
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