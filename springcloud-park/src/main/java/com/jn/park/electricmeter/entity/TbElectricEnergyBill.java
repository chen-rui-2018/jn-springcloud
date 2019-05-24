package com.jn.park.electricmeter.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbElectricEnergyBill implements Serializable {
    /*@ApiModelProperty("记录Id")*/
    private String id;

    /*@ApiModelProperty("账单名称")*/
    private String billName;

    /*@ApiModelProperty("账单来源")*/
    private String billSource;

    /*@ApiModelProperty("对象id")*/
    private String objId;

    /*@ApiModelProperty("对象名称")*/
    private String objName;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("")*/
    private BigDecimal billExpense;

    /*@ApiModelProperty("对象类型")*/
    private String objType;

    /*@ApiModelProperty("账本类型")*/
    private String acBookType;

    /*@ApiModelProperty("回调接口id")*/
    private String callBackId;

    /*@ApiModelProperty("回调方法")*/
    private String callBackUrl;

    /*@ApiModelProperty("最迟缴费时间")*/
    private Date latePayment;

    /*@ApiModelProperty("催缴次数")*/
    private Integer callTimes;

    /*@ApiModelProperty("1:已缴费，2未缴费")*/
    private Byte payStatus;

    /*@ApiModelProperty("缴费时间")*/
    private Date payTime;

    /*@ApiModelProperty("缴费账号")*/
    private String paier;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName == null ? null : billName.trim();
    }

    public String getBillSource() {
        return billSource;
    }

    public void setBillSource(String billSource) {
        this.billSource = billSource == null ? null : billSource.trim();
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId == null ? null : objId.trim();
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName == null ? null : objName.trim();
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

    public BigDecimal getBillExpense() {
        return billExpense;
    }

    public void setBillExpense(BigDecimal billExpense) {
        this.billExpense = billExpense;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType == null ? null : objType.trim();
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType == null ? null : acBookType.trim();
    }

    public String getCallBackId() {
        return callBackId;
    }

    public void setCallBackId(String callBackId) {
        this.callBackId = callBackId == null ? null : callBackId.trim();
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl == null ? null : callBackUrl.trim();
    }

    public Date getLatePayment() {
        return latePayment;
    }

    public void setLatePayment(Date latePayment) {
        this.latePayment = latePayment;
    }

    public Integer getCallTimes() {
        return callTimes;
    }

    public void setCallTimes(Integer callTimes) {
        this.callTimes = callTimes;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPaier() {
        return paier;
    }

    public void setPaier(String paier) {
        this.paier = paier == null ? null : paier.trim();
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
        TbElectricEnergyBill other = (TbElectricEnergyBill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBillName() == null ? other.getBillName() == null : this.getBillName().equals(other.getBillName()))
            && (this.getBillSource() == null ? other.getBillSource() == null : this.getBillSource().equals(other.getBillSource()))
            && (this.getObjId() == null ? other.getObjId() == null : this.getObjId().equals(other.getObjId()))
            && (this.getObjName() == null ? other.getObjName() == null : this.getObjName().equals(other.getObjName()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getBillExpense() == null ? other.getBillExpense() == null : this.getBillExpense().equals(other.getBillExpense()))
            && (this.getObjType() == null ? other.getObjType() == null : this.getObjType().equals(other.getObjType()))
            && (this.getAcBookType() == null ? other.getAcBookType() == null : this.getAcBookType().equals(other.getAcBookType()))
            && (this.getCallBackId() == null ? other.getCallBackId() == null : this.getCallBackId().equals(other.getCallBackId()))
            && (this.getCallBackUrl() == null ? other.getCallBackUrl() == null : this.getCallBackUrl().equals(other.getCallBackUrl()))
            && (this.getLatePayment() == null ? other.getLatePayment() == null : this.getLatePayment().equals(other.getLatePayment()))
            && (this.getCallTimes() == null ? other.getCallTimes() == null : this.getCallTimes().equals(other.getCallTimes()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getPaier() == null ? other.getPaier() == null : this.getPaier().equals(other.getPaier()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBillName() == null) ? 0 : getBillName().hashCode());
        result = prime * result + ((getBillSource() == null) ? 0 : getBillSource().hashCode());
        result = prime * result + ((getObjId() == null) ? 0 : getObjId().hashCode());
        result = prime * result + ((getObjName() == null) ? 0 : getObjName().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getBillExpense() == null) ? 0 : getBillExpense().hashCode());
        result = prime * result + ((getObjType() == null) ? 0 : getObjType().hashCode());
        result = prime * result + ((getAcBookType() == null) ? 0 : getAcBookType().hashCode());
        result = prime * result + ((getCallBackId() == null) ? 0 : getCallBackId().hashCode());
        result = prime * result + ((getCallBackUrl() == null) ? 0 : getCallBackUrl().hashCode());
        result = prime * result + ((getLatePayment() == null) ? 0 : getLatePayment().hashCode());
        result = prime * result + ((getCallTimes() == null) ? 0 : getCallTimes().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getPaier() == null) ? 0 : getPaier().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", billName=").append(billName);
        sb.append(", billSource=").append(billSource);
        sb.append(", objId=").append(objId);
        sb.append(", objName=").append(objName);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", billExpense=").append(billExpense);
        sb.append(", objType=").append(objType);
        sb.append(", acBookType=").append(acBookType);
        sb.append(", callBackId=").append(callBackId);
        sb.append(", callBackUrl=").append(callBackUrl);
        sb.append(", latePayment=").append(latePayment);
        sb.append(", callTimes=").append(callTimes);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", payTime=").append(payTime);
        sb.append(", paier=").append(paier);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}