package com.jn.park.asset.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbAssetArticleLease implements Serializable {
    /*@ApiModelProperty("")*/
    private String id;

    /*@ApiModelProperty("资产编号")*/
    private String assetNumber;

    /*@ApiModelProperty("物品名称(资产名称)")*/
    private String name;

    /*@ApiModelProperty("资产类型id")*/
    private String typeId;

    /*@ApiModelProperty("物品类型(资产类型)")*/
    private String assetType;

    /*@ApiModelProperty("规格")*/
    private String specification;

    /*@ApiModelProperty("二维码地址")*/
    private String qrCode;

    /*@ApiModelProperty("租借企业")*/
    private String leaseEnterprise;

    /*@ApiModelProperty("联系人")*/
    private String contactName;

    /*@ApiModelProperty("联系方式")*/
    private String contactPhone;

    /*@ApiModelProperty("租借押金")*/
    private String leaseCash;

    /*@ApiModelProperty("租借单价")*/
    private BigDecimal leasePrice;

    /*@ApiModelProperty("最低租借时间")*/
    private String leaseTime;

    /*@ApiModelProperty("图片url")*/
    private String imgUrl;

    /*@ApiModelProperty("物品介绍")*/
    private String articleIntroduction;

    /*@ApiModelProperty("租借状态(0标记为空闲,1申请中,2交付中,3租借中,4归还中,5已归还)")*/
    private Byte articleStatus;

    /*@ApiModelProperty("可租借(0不可租借,1可租借)")*/
    private Byte isLease;

    /*@ApiModelProperty("是否逾期(1是，0否)")*/
    private Integer isOverdue;

    /*@ApiModelProperty("申请时间")*/
    private Date applyTime;

    /*@ApiModelProperty("开始时间")*/
    private Date startTime;

    /*@ApiModelProperty("当前时间")*/
    private Date currentTime;

    /*@ApiModelProperty("结束时间")*/
    private Date endTime;

    /*@ApiModelProperty("缴费状态(0标记为未缴费,1标记为已缴费)")*/
    private Byte paymentStatus;

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

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber == null ? null : assetNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType == null ? null : assetType.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
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

    public String getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(String leaseCash) {
        this.leaseCash = leaseCash == null ? null : leaseCash.trim();
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(String leaseTime) {
        this.leaseTime = leaseTime == null ? null : leaseTime.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction == null ? null : articleIntroduction.trim();
    }

    public Byte getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Byte articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Byte getIsLease() {
        return isLease;
    }

    public void setIsLease(Byte isLease) {
        this.isLease = isLease;
    }

    public Integer getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Integer isOverdue) {
        this.isOverdue = isOverdue;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
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
        TbAssetArticleLease other = (TbAssetArticleLease) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAssetNumber() == null ? other.getAssetNumber() == null : this.getAssetNumber().equals(other.getAssetNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getAssetType() == null ? other.getAssetType() == null : this.getAssetType().equals(other.getAssetType()))
            && (this.getSpecification() == null ? other.getSpecification() == null : this.getSpecification().equals(other.getSpecification()))
            && (this.getQrCode() == null ? other.getQrCode() == null : this.getQrCode().equals(other.getQrCode()))
            && (this.getLeaseEnterprise() == null ? other.getLeaseEnterprise() == null : this.getLeaseEnterprise().equals(other.getLeaseEnterprise()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getLeaseCash() == null ? other.getLeaseCash() == null : this.getLeaseCash().equals(other.getLeaseCash()))
            && (this.getLeasePrice() == null ? other.getLeasePrice() == null : this.getLeasePrice().equals(other.getLeasePrice()))
            && (this.getLeaseTime() == null ? other.getLeaseTime() == null : this.getLeaseTime().equals(other.getLeaseTime()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getArticleIntroduction() == null ? other.getArticleIntroduction() == null : this.getArticleIntroduction().equals(other.getArticleIntroduction()))
            && (this.getArticleStatus() == null ? other.getArticleStatus() == null : this.getArticleStatus().equals(other.getArticleStatus()))
            && (this.getIsLease() == null ? other.getIsLease() == null : this.getIsLease().equals(other.getIsLease()))
            && (this.getIsOverdue() == null ? other.getIsOverdue() == null : this.getIsOverdue().equals(other.getIsOverdue()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getCurrentTime() == null ? other.getCurrentTime() == null : this.getCurrentTime().equals(other.getCurrentTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getPaymentStatus() == null ? other.getPaymentStatus() == null : this.getPaymentStatus().equals(other.getPaymentStatus()))
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
        result = prime * result + ((getAssetNumber() == null) ? 0 : getAssetNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getAssetType() == null) ? 0 : getAssetType().hashCode());
        result = prime * result + ((getSpecification() == null) ? 0 : getSpecification().hashCode());
        result = prime * result + ((getQrCode() == null) ? 0 : getQrCode().hashCode());
        result = prime * result + ((getLeaseEnterprise() == null) ? 0 : getLeaseEnterprise().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getLeaseCash() == null) ? 0 : getLeaseCash().hashCode());
        result = prime * result + ((getLeasePrice() == null) ? 0 : getLeasePrice().hashCode());
        result = prime * result + ((getLeaseTime() == null) ? 0 : getLeaseTime().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getArticleIntroduction() == null) ? 0 : getArticleIntroduction().hashCode());
        result = prime * result + ((getArticleStatus() == null) ? 0 : getArticleStatus().hashCode());
        result = prime * result + ((getIsLease() == null) ? 0 : getIsLease().hashCode());
        result = prime * result + ((getIsOverdue() == null) ? 0 : getIsOverdue().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getCurrentTime() == null) ? 0 : getCurrentTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getPaymentStatus() == null) ? 0 : getPaymentStatus().hashCode());
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
        sb.append(", assetNumber=").append(assetNumber);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", assetType=").append(assetType);
        sb.append(", specification=").append(specification);
        sb.append(", qrCode=").append(qrCode);
        sb.append(", leaseEnterprise=").append(leaseEnterprise);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", leaseCash=").append(leaseCash);
        sb.append(", leasePrice=").append(leasePrice);
        sb.append(", leaseTime=").append(leaseTime);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", articleIntroduction=").append(articleIntroduction);
        sb.append(", articleStatus=").append(articleStatus);
        sb.append(", isLease=").append(isLease);
        sb.append(", isOverdue=").append(isOverdue);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", currentTime=").append(currentTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", paymentStatus=").append(paymentStatus);
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