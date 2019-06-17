package com.jn.park.hatch.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbHatchIncubatorTeam implements Serializable {
    private String id;

    private String name;

    private String proName;

    private String proSynopsis;

    private String isFinanc;

    private BigDecimal financNum;

    private String residentInc;

    private String contacts;

    private String phone;

    private String email;

    private String proIntroduc;

    private String dataSources;

    private Date applicationTime;

    private String auditStatus;

    private String recordStatus;

    private String creatorAccount;

    private String createdTime;

    private String modifierAccount;

    private String modifiedTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProSynopsis() {
        return proSynopsis;
    }

    public void setProSynopsis(String proSynopsis) {
        this.proSynopsis = proSynopsis == null ? null : proSynopsis.trim();
    }

    public String getIsFinanc() {
        return isFinanc;
    }

    public void setIsFinanc(String isFinanc) {
        this.isFinanc = isFinanc == null ? null : isFinanc.trim();
    }

    public BigDecimal getFinancNum() {
        return financNum;
    }

    public void setFinancNum(BigDecimal financNum) {
        this.financNum = financNum;
    }

    public String getResidentInc() {
        return residentInc;
    }

    public void setResidentInc(String residentInc) {
        this.residentInc = residentInc == null ? null : residentInc.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getProIntroduc() {
        return proIntroduc;
    }

    public void setProIntroduc(String proIntroduc) {
        this.proIntroduc = proIntroduc == null ? null : proIntroduc.trim();
    }

    public String getDataSources() {
        return dataSources;
    }

    public void setDataSources(String dataSources) {
        this.dataSources = dataSources == null ? null : dataSources.trim();
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime == null ? null : createdTime.trim();
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime == null ? null : modifiedTime.trim();
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
        TbHatchIncubatorTeam other = (TbHatchIncubatorTeam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProName() == null ? other.getProName() == null : this.getProName().equals(other.getProName()))
            && (this.getProSynopsis() == null ? other.getProSynopsis() == null : this.getProSynopsis().equals(other.getProSynopsis()))
            && (this.getIsFinanc() == null ? other.getIsFinanc() == null : this.getIsFinanc().equals(other.getIsFinanc()))
            && (this.getFinancNum() == null ? other.getFinancNum() == null : this.getFinancNum().equals(other.getFinancNum()))
            && (this.getResidentInc() == null ? other.getResidentInc() == null : this.getResidentInc().equals(other.getResidentInc()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getProIntroduc() == null ? other.getProIntroduc() == null : this.getProIntroduc().equals(other.getProIntroduc()))
            && (this.getDataSources() == null ? other.getDataSources() == null : this.getDataSources().equals(other.getDataSources()))
            && (this.getApplicationTime() == null ? other.getApplicationTime() == null : this.getApplicationTime().equals(other.getApplicationTime()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
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
        result = prime * result + ((getProName() == null) ? 0 : getProName().hashCode());
        result = prime * result + ((getProSynopsis() == null) ? 0 : getProSynopsis().hashCode());
        result = prime * result + ((getIsFinanc() == null) ? 0 : getIsFinanc().hashCode());
        result = prime * result + ((getFinancNum() == null) ? 0 : getFinancNum().hashCode());
        result = prime * result + ((getResidentInc() == null) ? 0 : getResidentInc().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getProIntroduc() == null) ? 0 : getProIntroduc().hashCode());
        result = prime * result + ((getDataSources() == null) ? 0 : getDataSources().hashCode());
        result = prime * result + ((getApplicationTime() == null) ? 0 : getApplicationTime().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
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
        sb.append(", proName=").append(proName);
        sb.append(", proSynopsis=").append(proSynopsis);
        sb.append(", isFinanc=").append(isFinanc);
        sb.append(", financNum=").append(financNum);
        sb.append(", residentInc=").append(residentInc);
        sb.append(", contacts=").append(contacts);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", proIntroduc=").append(proIntroduc);
        sb.append(", dataSources=").append(dataSources);
        sb.append(", applicationTime=").append(applicationTime);
        sb.append(", auditStatus=").append(auditStatus);
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