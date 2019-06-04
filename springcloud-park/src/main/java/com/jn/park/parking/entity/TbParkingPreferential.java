package com.jn.park.parking.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbParkingPreferential implements Serializable {
    /*@ApiModelProperty("优惠政策id")*/
    private String policyId;

    /*@ApiModelProperty("优惠类型 1优惠固定金额2按比例优惠3税收优惠")*/
    private String policyType;

    /*@ApiModelProperty("优惠对象类型[company:企业;user:个人]")*/
    private String policyUserType;

    /*@ApiModelProperty("政策编码")*/
    private String policyCode;

    /*@ApiModelProperty("优惠内容")*/
    private String policyComments;

    /*@ApiModelProperty("优惠金额[空/0标识不设置优惠金额]")*/
    private Double offerPrice;

    /*@ApiModelProperty("优惠折扣[抵扣百分比][如已设置优惠金额，则优惠比例不生效]")*/
    private Double offerRatio;

    /*@ApiModelProperty("0 无效  1 有效")*/
    private String policyStatus;

    /*@ApiModelProperty("租满多少天可用[空/0则不设置天数。加上之前租赁天数]")*/
    private Integer dayConditions;

    /*@ApiModelProperty("税收基数[单位:万元]")*/
    private BigDecimal taxtBasis;

    /*@ApiModelProperty("优惠车辆数")*/
    private Integer policyCarNum;

    /*@ApiModelProperty("最大优惠车辆数")*/
    private Integer policyCarMax;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType == null ? null : policyType.trim();
    }

    public String getPolicyUserType() {
        return policyUserType;
    }

    public void setPolicyUserType(String policyUserType) {
        this.policyUserType = policyUserType == null ? null : policyUserType.trim();
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode == null ? null : policyCode.trim();
    }

    public String getPolicyComments() {
        return policyComments;
    }

    public void setPolicyComments(String policyComments) {
        this.policyComments = policyComments == null ? null : policyComments.trim();
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Double getOfferRatio() {
        return offerRatio;
    }

    public void setOfferRatio(Double offerRatio) {
        this.offerRatio = offerRatio;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus == null ? null : policyStatus.trim();
    }

    public Integer getDayConditions() {
        return dayConditions;
    }

    public void setDayConditions(Integer dayConditions) {
        this.dayConditions = dayConditions;
    }

    public BigDecimal getTaxtBasis() {
        return taxtBasis;
    }

    public void setTaxtBasis(BigDecimal taxtBasis) {
        this.taxtBasis = taxtBasis;
    }

    public Integer getPolicyCarNum() {
        return policyCarNum;
    }

    public void setPolicyCarNum(Integer policyCarNum) {
        this.policyCarNum = policyCarNum;
    }

    public Integer getPolicyCarMax() {
        return policyCarMax;
    }

    public void setPolicyCarMax(Integer policyCarMax) {
        this.policyCarMax = policyCarMax;
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
        TbParkingPreferential other = (TbParkingPreferential) that;
        return (this.getPolicyId() == null ? other.getPolicyId() == null : this.getPolicyId().equals(other.getPolicyId()))
            && (this.getPolicyType() == null ? other.getPolicyType() == null : this.getPolicyType().equals(other.getPolicyType()))
            && (this.getPolicyUserType() == null ? other.getPolicyUserType() == null : this.getPolicyUserType().equals(other.getPolicyUserType()))
            && (this.getPolicyCode() == null ? other.getPolicyCode() == null : this.getPolicyCode().equals(other.getPolicyCode()))
            && (this.getPolicyComments() == null ? other.getPolicyComments() == null : this.getPolicyComments().equals(other.getPolicyComments()))
            && (this.getOfferPrice() == null ? other.getOfferPrice() == null : this.getOfferPrice().equals(other.getOfferPrice()))
            && (this.getOfferRatio() == null ? other.getOfferRatio() == null : this.getOfferRatio().equals(other.getOfferRatio()))
            && (this.getPolicyStatus() == null ? other.getPolicyStatus() == null : this.getPolicyStatus().equals(other.getPolicyStatus()))
            && (this.getDayConditions() == null ? other.getDayConditions() == null : this.getDayConditions().equals(other.getDayConditions()))
            && (this.getTaxtBasis() == null ? other.getTaxtBasis() == null : this.getTaxtBasis().equals(other.getTaxtBasis()))
            && (this.getPolicyCarNum() == null ? other.getPolicyCarNum() == null : this.getPolicyCarNum().equals(other.getPolicyCarNum()))
            && (this.getPolicyCarMax() == null ? other.getPolicyCarMax() == null : this.getPolicyCarMax().equals(other.getPolicyCarMax()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPolicyId() == null) ? 0 : getPolicyId().hashCode());
        result = prime * result + ((getPolicyType() == null) ? 0 : getPolicyType().hashCode());
        result = prime * result + ((getPolicyUserType() == null) ? 0 : getPolicyUserType().hashCode());
        result = prime * result + ((getPolicyCode() == null) ? 0 : getPolicyCode().hashCode());
        result = prime * result + ((getPolicyComments() == null) ? 0 : getPolicyComments().hashCode());
        result = prime * result + ((getOfferPrice() == null) ? 0 : getOfferPrice().hashCode());
        result = prime * result + ((getOfferRatio() == null) ? 0 : getOfferRatio().hashCode());
        result = prime * result + ((getPolicyStatus() == null) ? 0 : getPolicyStatus().hashCode());
        result = prime * result + ((getDayConditions() == null) ? 0 : getDayConditions().hashCode());
        result = prime * result + ((getTaxtBasis() == null) ? 0 : getTaxtBasis().hashCode());
        result = prime * result + ((getPolicyCarNum() == null) ? 0 : getPolicyCarNum().hashCode());
        result = prime * result + ((getPolicyCarMax() == null) ? 0 : getPolicyCarMax().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", policyId=").append(policyId);
        sb.append(", policyType=").append(policyType);
        sb.append(", policyUserType=").append(policyUserType);
        sb.append(", policyCode=").append(policyCode);
        sb.append(", policyComments=").append(policyComments);
        sb.append(", offerPrice=").append(offerPrice);
        sb.append(", offerRatio=").append(offerRatio);
        sb.append(", policyStatus=").append(policyStatus);
        sb.append(", dayConditions=").append(dayConditions);
        sb.append(", taxtBasis=").append(taxtBasis);
        sb.append(", policyCarNum=").append(policyCarNum);
        sb.append(", policyCarMax=").append(policyCarMax);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}