package com.jn.park.parking.entity;

import java.io.Serializable;
import java.util.Date;

public class TbParkingSpaceRental implements Serializable {
    /*@ApiModelProperty("出租记录id")*/
    private String rentId;

    /*@ApiModelProperty("车位编号")*/
    private String spaceSerial;

    /*@ApiModelProperty("车主账号")*/
    private String account;

    /*@ApiModelProperty("车主姓名")*/
    private String name;

    /*@ApiModelProperty("联系电话")*/
    private String phone;

    /*@ApiModelProperty("价格(单位元/年)")*/
    private String rentPrice;

    /*@ApiModelProperty("开始日期")*/
    private Date startTime;

    /*@ApiModelProperty("结束日期")*/
    private Date endTime;

    /*@ApiModelProperty("应缴金额")*/
    private Double dueMoney;

    /*@ApiModelProperty("减免金额")*/
    private Double deductionMoney;

    /*@ApiModelProperty("实缴金额")*/
    private Double actualMoney;

    /*@ApiModelProperty("缴费单号")*/
    private String orderBillNum;

    /*@ApiModelProperty("审批人账号")*/
    private String approvalAccount;

    /*@ApiModelProperty("审批人姓名")*/
    private String approvalName;

    /*@ApiModelProperty("审批意见")*/
    private String approvalComments;

    /*@ApiModelProperty("0-待审核,1审核通过(待缴费),2,审批不通过")*/
    private String approvalStatus;

    /*@ApiModelProperty("合同下载路径")*/
    private String contractAttachment;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId == null ? null : rentId.trim();
    }

    public String getSpaceSerial() {
        return spaceSerial;
    }

    public void setSpaceSerial(String spaceSerial) {
        this.spaceSerial = spaceSerial == null ? null : spaceSerial.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(String rentPrice) {
        this.rentPrice = rentPrice == null ? null : rentPrice.trim();
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

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Double getDeductionMoney() {
        return deductionMoney;
    }

    public void setDeductionMoney(Double deductionMoney) {
        this.deductionMoney = deductionMoney;
    }

    public Double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Double actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getOrderBillNum() {
        return orderBillNum;
    }

    public void setOrderBillNum(String orderBillNum) {
        this.orderBillNum = orderBillNum == null ? null : orderBillNum.trim();
    }

    public String getApprovalAccount() {
        return approvalAccount;
    }

    public void setApprovalAccount(String approvalAccount) {
        this.approvalAccount = approvalAccount == null ? null : approvalAccount.trim();
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName == null ? null : approvalName.trim();
    }

    public String getApprovalComments() {
        return approvalComments;
    }

    public void setApprovalComments(String approvalComments) {
        this.approvalComments = approvalComments == null ? null : approvalComments.trim();
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
    }

    public String getContractAttachment() {
        return contractAttachment;
    }

    public void setContractAttachment(String contractAttachment) {
        this.contractAttachment = contractAttachment == null ? null : contractAttachment.trim();
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
        TbParkingSpaceRental other = (TbParkingSpaceRental) that;
        return (this.getRentId() == null ? other.getRentId() == null : this.getRentId().equals(other.getRentId()))
            && (this.getSpaceSerial() == null ? other.getSpaceSerial() == null : this.getSpaceSerial().equals(other.getSpaceSerial()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getRentPrice() == null ? other.getRentPrice() == null : this.getRentPrice().equals(other.getRentPrice()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getDueMoney() == null ? other.getDueMoney() == null : this.getDueMoney().equals(other.getDueMoney()))
            && (this.getDeductionMoney() == null ? other.getDeductionMoney() == null : this.getDeductionMoney().equals(other.getDeductionMoney()))
            && (this.getActualMoney() == null ? other.getActualMoney() == null : this.getActualMoney().equals(other.getActualMoney()))
            && (this.getOrderBillNum() == null ? other.getOrderBillNum() == null : this.getOrderBillNum().equals(other.getOrderBillNum()))
            && (this.getApprovalAccount() == null ? other.getApprovalAccount() == null : this.getApprovalAccount().equals(other.getApprovalAccount()))
            && (this.getApprovalName() == null ? other.getApprovalName() == null : this.getApprovalName().equals(other.getApprovalName()))
            && (this.getApprovalComments() == null ? other.getApprovalComments() == null : this.getApprovalComments().equals(other.getApprovalComments()))
            && (this.getApprovalStatus() == null ? other.getApprovalStatus() == null : this.getApprovalStatus().equals(other.getApprovalStatus()))
            && (this.getContractAttachment() == null ? other.getContractAttachment() == null : this.getContractAttachment().equals(other.getContractAttachment()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRentId() == null) ? 0 : getRentId().hashCode());
        result = prime * result + ((getSpaceSerial() == null) ? 0 : getSpaceSerial().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getRentPrice() == null) ? 0 : getRentPrice().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getDueMoney() == null) ? 0 : getDueMoney().hashCode());
        result = prime * result + ((getDeductionMoney() == null) ? 0 : getDeductionMoney().hashCode());
        result = prime * result + ((getActualMoney() == null) ? 0 : getActualMoney().hashCode());
        result = prime * result + ((getOrderBillNum() == null) ? 0 : getOrderBillNum().hashCode());
        result = prime * result + ((getApprovalAccount() == null) ? 0 : getApprovalAccount().hashCode());
        result = prime * result + ((getApprovalName() == null) ? 0 : getApprovalName().hashCode());
        result = prime * result + ((getApprovalComments() == null) ? 0 : getApprovalComments().hashCode());
        result = prime * result + ((getApprovalStatus() == null) ? 0 : getApprovalStatus().hashCode());
        result = prime * result + ((getContractAttachment() == null) ? 0 : getContractAttachment().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rentId=").append(rentId);
        sb.append(", spaceSerial=").append(spaceSerial);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", rentPrice=").append(rentPrice);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", dueMoney=").append(dueMoney);
        sb.append(", deductionMoney=").append(deductionMoney);
        sb.append(", actualMoney=").append(actualMoney);
        sb.append(", orderBillNum=").append(orderBillNum);
        sb.append(", approvalAccount=").append(approvalAccount);
        sb.append(", approvalName=").append(approvalName);
        sb.append(", approvalComments=").append(approvalComments);
        sb.append(", approvalStatus=").append(approvalStatus);
        sb.append(", contractAttachment=").append(contractAttachment);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}