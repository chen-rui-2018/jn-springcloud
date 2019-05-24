package com.jn.hr.employee.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerEmployeeBasicInfo implements Serializable {
    private String id;

    private String employeePortrait;

    private String name;

    private String sex;

    private String phone;

    private String mailbox;

    private String departmentId;

    private String departmentName;

    private String jobId;

    private String jobName;

    private String certificateId;

    private String certificateType;

    private String certificateNumber;

    private String postId;

    private String postName;

    private String jobNumber;

    private String contractId;

    private String contractName;

    private String employeeType;

    private Date entryDate;

    private Date birthDate;

    private String nationalityId;

    private String nationalityName;

    private String workAddress;

    private String contactAddress;

    private String certificateName;

    private String nation;

    private String registeredType;

    private String registeredResidence;

    private String nativePlace;

    private String residentialAddress;

    private String highestAcademic;

    private String politicalOutlook;

    private String maritalStatus;

    private String emergencyContactName;

    private String emergencyContactPhone;

    private String qq;

    private String wechat;

    private Date startCurrent;

    private Date endCurrent;

    private String workMailbox;

    private String workPhone;

    private Date expirationDate;

    private String probationPeriod;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private Byte employStatus;

    private String userId;

    private String userAccount;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmployeePortrait() {
        return employeePortrait;
    }

    public void setEmployeePortrait(String employeePortrait) {
        this.employeePortrait = employeePortrait == null ? null : employeePortrait.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId == null ? null : certificateId.trim();
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType == null ? null : employeeType.trim();
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId == null ? null : nationalityId.trim();
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName == null ? null : nationalityName.trim();
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName == null ? null : certificateName.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getRegisteredType() {
        return registeredType;
    }

    public void setRegisteredType(String registeredType) {
        this.registeredType = registeredType == null ? null : registeredType.trim();
    }

    public String getRegisteredResidence() {
        return registeredResidence;
    }

    public void setRegisteredResidence(String registeredResidence) {
        this.registeredResidence = registeredResidence == null ? null : registeredResidence.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress == null ? null : residentialAddress.trim();
    }

    public String getHighestAcademic() {
        return highestAcademic;
    }

    public void setHighestAcademic(String highestAcademic) {
        this.highestAcademic = highestAcademic == null ? null : highestAcademic.trim();
    }

    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook == null ? null : politicalOutlook.trim();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName == null ? null : emergencyContactName.trim();
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone == null ? null : emergencyContactPhone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Date getStartCurrent() {
        return startCurrent;
    }

    public void setStartCurrent(Date startCurrent) {
        this.startCurrent = startCurrent;
    }

    public Date getEndCurrent() {
        return endCurrent;
    }

    public void setEndCurrent(Date endCurrent) {
        this.endCurrent = endCurrent;
    }

    public String getWorkMailbox() {
        return workMailbox;
    }

    public void setWorkMailbox(String workMailbox) {
        this.workMailbox = workMailbox == null ? null : workMailbox.trim();
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone == null ? null : workPhone.trim();
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(String probationPeriod) {
        this.probationPeriod = probationPeriod == null ? null : probationPeriod.trim();
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

    public Byte getEmployStatus() {
        return employStatus;
    }

    public void setEmployStatus(Byte employStatus) {
        this.employStatus = employStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
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
        TbManpowerEmployeeBasicInfo other = (TbManpowerEmployeeBasicInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmployeePortrait() == null ? other.getEmployeePortrait() == null : this.getEmployeePortrait().equals(other.getEmployeePortrait()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getMailbox() == null ? other.getMailbox() == null : this.getMailbox().equals(other.getMailbox()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getCertificateId() == null ? other.getCertificateId() == null : this.getCertificateId().equals(other.getCertificateId()))
            && (this.getCertificateType() == null ? other.getCertificateType() == null : this.getCertificateType().equals(other.getCertificateType()))
            && (this.getCertificateNumber() == null ? other.getCertificateNumber() == null : this.getCertificateNumber().equals(other.getCertificateNumber()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPostName() == null ? other.getPostName() == null : this.getPostName().equals(other.getPostName()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getContractName() == null ? other.getContractName() == null : this.getContractName().equals(other.getContractName()))
            && (this.getEmployeeType() == null ? other.getEmployeeType() == null : this.getEmployeeType().equals(other.getEmployeeType()))
            && (this.getEntryDate() == null ? other.getEntryDate() == null : this.getEntryDate().equals(other.getEntryDate()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getNationalityId() == null ? other.getNationalityId() == null : this.getNationalityId().equals(other.getNationalityId()))
            && (this.getNationalityName() == null ? other.getNationalityName() == null : this.getNationalityName().equals(other.getNationalityName()))
            && (this.getWorkAddress() == null ? other.getWorkAddress() == null : this.getWorkAddress().equals(other.getWorkAddress()))
            && (this.getContactAddress() == null ? other.getContactAddress() == null : this.getContactAddress().equals(other.getContactAddress()))
            && (this.getCertificateName() == null ? other.getCertificateName() == null : this.getCertificateName().equals(other.getCertificateName()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getRegisteredType() == null ? other.getRegisteredType() == null : this.getRegisteredType().equals(other.getRegisteredType()))
            && (this.getRegisteredResidence() == null ? other.getRegisteredResidence() == null : this.getRegisteredResidence().equals(other.getRegisteredResidence()))
            && (this.getNativePlace() == null ? other.getNativePlace() == null : this.getNativePlace().equals(other.getNativePlace()))
            && (this.getResidentialAddress() == null ? other.getResidentialAddress() == null : this.getResidentialAddress().equals(other.getResidentialAddress()))
            && (this.getHighestAcademic() == null ? other.getHighestAcademic() == null : this.getHighestAcademic().equals(other.getHighestAcademic()))
            && (this.getPoliticalOutlook() == null ? other.getPoliticalOutlook() == null : this.getPoliticalOutlook().equals(other.getPoliticalOutlook()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()))
            && (this.getEmergencyContactName() == null ? other.getEmergencyContactName() == null : this.getEmergencyContactName().equals(other.getEmergencyContactName()))
            && (this.getEmergencyContactPhone() == null ? other.getEmergencyContactPhone() == null : this.getEmergencyContactPhone().equals(other.getEmergencyContactPhone()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWechat() == null ? other.getWechat() == null : this.getWechat().equals(other.getWechat()))
            && (this.getStartCurrent() == null ? other.getStartCurrent() == null : this.getStartCurrent().equals(other.getStartCurrent()))
            && (this.getEndCurrent() == null ? other.getEndCurrent() == null : this.getEndCurrent().equals(other.getEndCurrent()))
            && (this.getWorkMailbox() == null ? other.getWorkMailbox() == null : this.getWorkMailbox().equals(other.getWorkMailbox()))
            && (this.getWorkPhone() == null ? other.getWorkPhone() == null : this.getWorkPhone().equals(other.getWorkPhone()))
            && (this.getExpirationDate() == null ? other.getExpirationDate() == null : this.getExpirationDate().equals(other.getExpirationDate()))
            && (this.getProbationPeriod() == null ? other.getProbationPeriod() == null : this.getProbationPeriod().equals(other.getProbationPeriod()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getEmployStatus() == null ? other.getEmployStatus() == null : this.getEmployStatus().equals(other.getEmployStatus()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmployeePortrait() == null) ? 0 : getEmployeePortrait().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getMailbox() == null) ? 0 : getMailbox().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getCertificateId() == null) ? 0 : getCertificateId().hashCode());
        result = prime * result + ((getCertificateType() == null) ? 0 : getCertificateType().hashCode());
        result = prime * result + ((getCertificateNumber() == null) ? 0 : getCertificateNumber().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getPostName() == null) ? 0 : getPostName().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getContractName() == null) ? 0 : getContractName().hashCode());
        result = prime * result + ((getEmployeeType() == null) ? 0 : getEmployeeType().hashCode());
        result = prime * result + ((getEntryDate() == null) ? 0 : getEntryDate().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getNationalityId() == null) ? 0 : getNationalityId().hashCode());
        result = prime * result + ((getNationalityName() == null) ? 0 : getNationalityName().hashCode());
        result = prime * result + ((getWorkAddress() == null) ? 0 : getWorkAddress().hashCode());
        result = prime * result + ((getContactAddress() == null) ? 0 : getContactAddress().hashCode());
        result = prime * result + ((getCertificateName() == null) ? 0 : getCertificateName().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getRegisteredType() == null) ? 0 : getRegisteredType().hashCode());
        result = prime * result + ((getRegisteredResidence() == null) ? 0 : getRegisteredResidence().hashCode());
        result = prime * result + ((getNativePlace() == null) ? 0 : getNativePlace().hashCode());
        result = prime * result + ((getResidentialAddress() == null) ? 0 : getResidentialAddress().hashCode());
        result = prime * result + ((getHighestAcademic() == null) ? 0 : getHighestAcademic().hashCode());
        result = prime * result + ((getPoliticalOutlook() == null) ? 0 : getPoliticalOutlook().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
        result = prime * result + ((getEmergencyContactName() == null) ? 0 : getEmergencyContactName().hashCode());
        result = prime * result + ((getEmergencyContactPhone() == null) ? 0 : getEmergencyContactPhone().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWechat() == null) ? 0 : getWechat().hashCode());
        result = prime * result + ((getStartCurrent() == null) ? 0 : getStartCurrent().hashCode());
        result = prime * result + ((getEndCurrent() == null) ? 0 : getEndCurrent().hashCode());
        result = prime * result + ((getWorkMailbox() == null) ? 0 : getWorkMailbox().hashCode());
        result = prime * result + ((getWorkPhone() == null) ? 0 : getWorkPhone().hashCode());
        result = prime * result + ((getExpirationDate() == null) ? 0 : getExpirationDate().hashCode());
        result = prime * result + ((getProbationPeriod() == null) ? 0 : getProbationPeriod().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getEmployStatus() == null) ? 0 : getEmployStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", employeePortrait=").append(employeePortrait);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", mailbox=").append(mailbox);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", jobId=").append(jobId);
        sb.append(", jobName=").append(jobName);
        sb.append(", certificateId=").append(certificateId);
        sb.append(", certificateType=").append(certificateType);
        sb.append(", certificateNumber=").append(certificateNumber);
        sb.append(", postId=").append(postId);
        sb.append(", postName=").append(postName);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", contractId=").append(contractId);
        sb.append(", contractName=").append(contractName);
        sb.append(", employeeType=").append(employeeType);
        sb.append(", entryDate=").append(entryDate);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", nationalityId=").append(nationalityId);
        sb.append(", nationalityName=").append(nationalityName);
        sb.append(", workAddress=").append(workAddress);
        sb.append(", contactAddress=").append(contactAddress);
        sb.append(", certificateName=").append(certificateName);
        sb.append(", nation=").append(nation);
        sb.append(", registeredType=").append(registeredType);
        sb.append(", registeredResidence=").append(registeredResidence);
        sb.append(", nativePlace=").append(nativePlace);
        sb.append(", residentialAddress=").append(residentialAddress);
        sb.append(", highestAcademic=").append(highestAcademic);
        sb.append(", politicalOutlook=").append(politicalOutlook);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", emergencyContactName=").append(emergencyContactName);
        sb.append(", emergencyContactPhone=").append(emergencyContactPhone);
        sb.append(", qq=").append(qq);
        sb.append(", wechat=").append(wechat);
        sb.append(", startCurrent=").append(startCurrent);
        sb.append(", endCurrent=").append(endCurrent);
        sb.append(", workMailbox=").append(workMailbox);
        sb.append(", workPhone=").append(workPhone);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", probationPeriod=").append(probationPeriod);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", employStatus=").append(employStatus);
        sb.append(", userId=").append(userId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}