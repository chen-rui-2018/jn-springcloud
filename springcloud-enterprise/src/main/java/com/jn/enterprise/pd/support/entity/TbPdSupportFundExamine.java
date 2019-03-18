package com.jn.enterprise.pd.support.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPdSupportFundExamine implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("企业（团队）名称")*/
    private String name;

    /*@ApiModelProperty("人才姓名")*/
    private String personnelName;

    /*@ApiModelProperty("申请金额")*/
    private BigDecimal applicationAmount;

    /*@ApiModelProperty("合作方名称")*/
    private String partnerName;

    /*@ApiModelProperty("资金使用用途")*/
    private String useFund;

    /*@ApiModelProperty("联系人")*/
    private String contact;

    /*@ApiModelProperty("联系电话")*/
    private String contactNumber;

    /*@ApiModelProperty("电子邮箱")*/
    private String email;

    /*@ApiModelProperty("申请材料")*/
    private String applicationMaterials;

    /*@ApiModelProperty("状态（1：未审核，2：审核中，3：通过，4：不通过）")*/
    private Byte status;

    /*@ApiModelProperty("是否删除（0标记删除，1正常）")*/
    private Byte recordStatus;

    /*@ApiModelProperty("创建者账号")*/
    private String creatorAccount;

    /*@ApiModelProperty("创建时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName == null ? null : personnelName.trim();
    }

    public BigDecimal getApplicationAmount() {
        return applicationAmount;
    }

    public void setApplicationAmount(BigDecimal applicationAmount) {
        this.applicationAmount = applicationAmount;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    public String getUseFund() {
        return useFund;
    }

    public void setUseFund(String useFund) {
        this.useFund = useFund == null ? null : useFund.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getApplicationMaterials() {
        return applicationMaterials;
    }

    public void setApplicationMaterials(String applicationMaterials) {
        this.applicationMaterials = applicationMaterials == null ? null : applicationMaterials.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        TbPdSupportFundExamine other = (TbPdSupportFundExamine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPersonnelName() == null ? other.getPersonnelName() == null : this.getPersonnelName().equals(other.getPersonnelName()))
            && (this.getApplicationAmount() == null ? other.getApplicationAmount() == null : this.getApplicationAmount().equals(other.getApplicationAmount()))
            && (this.getPartnerName() == null ? other.getPartnerName() == null : this.getPartnerName().equals(other.getPartnerName()))
            && (this.getUseFund() == null ? other.getUseFund() == null : this.getUseFund().equals(other.getUseFund()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getContactNumber() == null ? other.getContactNumber() == null : this.getContactNumber().equals(other.getContactNumber()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getApplicationMaterials() == null ? other.getApplicationMaterials() == null : this.getApplicationMaterials().equals(other.getApplicationMaterials()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPersonnelName() == null) ? 0 : getPersonnelName().hashCode());
        result = prime * result + ((getApplicationAmount() == null) ? 0 : getApplicationAmount().hashCode());
        result = prime * result + ((getPartnerName() == null) ? 0 : getPartnerName().hashCode());
        result = prime * result + ((getUseFund() == null) ? 0 : getUseFund().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getContactNumber() == null) ? 0 : getContactNumber().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getApplicationMaterials() == null) ? 0 : getApplicationMaterials().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", personnelName=").append(personnelName);
        sb.append(", applicationAmount=").append(applicationAmount);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", useFund=").append(useFund);
        sb.append(", contact=").append(contact);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", email=").append(email);
        sb.append(", applicationMaterials=").append(applicationMaterials);
        sb.append(", status=").append(status);
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