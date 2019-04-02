package com.jn.enterprise.pd.personnel.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPdPersonnelProjectBank implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("企业（团队）名称")*/
    private String name;

    /*@ApiModelProperty("统一社会信用代码")*/
    private String unifiedSocialCredit;

    /*@ApiModelProperty("类型（1：企业，2：团队）")*/
    private Byte type;

    /*@ApiModelProperty("产业领域ID")*/
    private Integer industrialFId;

    /*@ApiModelProperty("产业领域名称")*/
    private String industrialFieldName;

    /*@ApiModelProperty("企业法人")*/
    private String enterpriseLegalPerson;

    /*@ApiModelProperty("公司地址")*/
    private String companyAddress;

    /*@ApiModelProperty("企业logo")*/
    private String companyLogo;

    /*@ApiModelProperty("企业简介")*/
    private String companyProfile;

    /*@ApiModelProperty("项目名称（团队）")*/
    private String projectName;

    /*@ApiModelProperty("项目简介（团队）")*/
    private String projectProfile;

    /*@ApiModelProperty("团队ID")*/
    private String teamId;

    /*@ApiModelProperty("联系人姓名")*/
    private String contactName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactTelephone;

    /*@ApiModelProperty("联系人电子邮箱")*/
    private String contactEmail;

    /*@ApiModelProperty("项目介绍书附件地址")*/
    private String projectIntroductionFile;

    /*@ApiModelProperty("政策通知（获取扶持政策环节使用）")*/
    private String policyNotice;

    /*@ApiModelProperty("是否已发送（1：已发送，2：未发送）-获取扶持政策环节使用")*/
    private Byte policyIsSendOut;

    /*@ApiModelProperty("标签名称（人才管理企业打标用）")*/
    private String labelName;

    /*@ApiModelProperty("标签ID（人才管理企业打标用）")*/
    private String labelId;

    /*@ApiModelProperty("是否完成核名（1：是，2：否）")*/
    private Byte settleIsCompleteNuclearName;

    /*@ApiModelProperty("是否已领取执照(1:是，2：否)")*/
    private Byte settleIsLicenseCollect;

    /*@ApiModelProperty("是否已完成盖章（1：是，2：否）")*/
    private Byte settleIsCompletionSeal;

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

    public String getUnifiedSocialCredit() {
        return unifiedSocialCredit;
    }

    public void setUnifiedSocialCredit(String unifiedSocialCredit) {
        this.unifiedSocialCredit = unifiedSocialCredit == null ? null : unifiedSocialCredit.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getIndustrialFId() {
        return industrialFId;
    }

    public void setIndustrialFId(Integer industrialFId) {
        this.industrialFId = industrialFId;
    }

    public String getIndustrialFieldName() {
        return industrialFieldName;
    }

    public void setIndustrialFieldName(String industrialFieldName) {
        this.industrialFieldName = industrialFieldName == null ? null : industrialFieldName.trim();
    }

    public String getEnterpriseLegalPerson() {
        return enterpriseLegalPerson;
    }

    public void setEnterpriseLegalPerson(String enterpriseLegalPerson) {
        this.enterpriseLegalPerson = enterpriseLegalPerson == null ? null : enterpriseLegalPerson.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.trim();
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile == null ? null : companyProfile.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectProfile() {
        return projectProfile;
    }

    public void setProjectProfile(String projectProfile) {
        this.projectProfile = projectProfile == null ? null : projectProfile.trim();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone == null ? null : contactTelephone.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getProjectIntroductionFile() {
        return projectIntroductionFile;
    }

    public void setProjectIntroductionFile(String projectIntroductionFile) {
        this.projectIntroductionFile = projectIntroductionFile == null ? null : projectIntroductionFile.trim();
    }

    public String getPolicyNotice() {
        return policyNotice;
    }

    public void setPolicyNotice(String policyNotice) {
        this.policyNotice = policyNotice == null ? null : policyNotice.trim();
    }

    public Byte getPolicyIsSendOut() {
        return policyIsSendOut;
    }

    public void setPolicyIsSendOut(Byte policyIsSendOut) {
        this.policyIsSendOut = policyIsSendOut;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId == null ? null : labelId.trim();
    }

    public Byte getSettleIsCompleteNuclearName() {
        return settleIsCompleteNuclearName;
    }

    public void setSettleIsCompleteNuclearName(Byte settleIsCompleteNuclearName) {
        this.settleIsCompleteNuclearName = settleIsCompleteNuclearName;
    }

    public Byte getSettleIsLicenseCollect() {
        return settleIsLicenseCollect;
    }

    public void setSettleIsLicenseCollect(Byte settleIsLicenseCollect) {
        this.settleIsLicenseCollect = settleIsLicenseCollect;
    }

    public Byte getSettleIsCompletionSeal() {
        return settleIsCompletionSeal;
    }

    public void setSettleIsCompletionSeal(Byte settleIsCompletionSeal) {
        this.settleIsCompletionSeal = settleIsCompletionSeal;
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
        TbPdPersonnelProjectBank other = (TbPdPersonnelProjectBank) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUnifiedSocialCredit() == null ? other.getUnifiedSocialCredit() == null : this.getUnifiedSocialCredit().equals(other.getUnifiedSocialCredit()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIndustrialFId() == null ? other.getIndustrialFId() == null : this.getIndustrialFId().equals(other.getIndustrialFId()))
            && (this.getIndustrialFieldName() == null ? other.getIndustrialFieldName() == null : this.getIndustrialFieldName().equals(other.getIndustrialFieldName()))
            && (this.getEnterpriseLegalPerson() == null ? other.getEnterpriseLegalPerson() == null : this.getEnterpriseLegalPerson().equals(other.getEnterpriseLegalPerson()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getCompanyLogo() == null ? other.getCompanyLogo() == null : this.getCompanyLogo().equals(other.getCompanyLogo()))
            && (this.getCompanyProfile() == null ? other.getCompanyProfile() == null : this.getCompanyProfile().equals(other.getCompanyProfile()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectProfile() == null ? other.getProjectProfile() == null : this.getProjectProfile().equals(other.getProjectProfile()))
            && (this.getTeamId() == null ? other.getTeamId() == null : this.getTeamId().equals(other.getTeamId()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactTelephone() == null ? other.getContactTelephone() == null : this.getContactTelephone().equals(other.getContactTelephone()))
            && (this.getContactEmail() == null ? other.getContactEmail() == null : this.getContactEmail().equals(other.getContactEmail()))
            && (this.getProjectIntroductionFile() == null ? other.getProjectIntroductionFile() == null : this.getProjectIntroductionFile().equals(other.getProjectIntroductionFile()))
            && (this.getPolicyNotice() == null ? other.getPolicyNotice() == null : this.getPolicyNotice().equals(other.getPolicyNotice()))
            && (this.getPolicyIsSendOut() == null ? other.getPolicyIsSendOut() == null : this.getPolicyIsSendOut().equals(other.getPolicyIsSendOut()))
            && (this.getLabelName() == null ? other.getLabelName() == null : this.getLabelName().equals(other.getLabelName()))
            && (this.getLabelId() == null ? other.getLabelId() == null : this.getLabelId().equals(other.getLabelId()))
            && (this.getSettleIsCompleteNuclearName() == null ? other.getSettleIsCompleteNuclearName() == null : this.getSettleIsCompleteNuclearName().equals(other.getSettleIsCompleteNuclearName()))
            && (this.getSettleIsLicenseCollect() == null ? other.getSettleIsLicenseCollect() == null : this.getSettleIsLicenseCollect().equals(other.getSettleIsLicenseCollect()))
            && (this.getSettleIsCompletionSeal() == null ? other.getSettleIsCompletionSeal() == null : this.getSettleIsCompletionSeal().equals(other.getSettleIsCompletionSeal()))
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
        result = prime * result + ((getUnifiedSocialCredit() == null) ? 0 : getUnifiedSocialCredit().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIndustrialFId() == null) ? 0 : getIndustrialFId().hashCode());
        result = prime * result + ((getIndustrialFieldName() == null) ? 0 : getIndustrialFieldName().hashCode());
        result = prime * result + ((getEnterpriseLegalPerson() == null) ? 0 : getEnterpriseLegalPerson().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getCompanyLogo() == null) ? 0 : getCompanyLogo().hashCode());
        result = prime * result + ((getCompanyProfile() == null) ? 0 : getCompanyProfile().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectProfile() == null) ? 0 : getProjectProfile().hashCode());
        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactTelephone() == null) ? 0 : getContactTelephone().hashCode());
        result = prime * result + ((getContactEmail() == null) ? 0 : getContactEmail().hashCode());
        result = prime * result + ((getProjectIntroductionFile() == null) ? 0 : getProjectIntroductionFile().hashCode());
        result = prime * result + ((getPolicyNotice() == null) ? 0 : getPolicyNotice().hashCode());
        result = prime * result + ((getPolicyIsSendOut() == null) ? 0 : getPolicyIsSendOut().hashCode());
        result = prime * result + ((getLabelName() == null) ? 0 : getLabelName().hashCode());
        result = prime * result + ((getLabelId() == null) ? 0 : getLabelId().hashCode());
        result = prime * result + ((getSettleIsCompleteNuclearName() == null) ? 0 : getSettleIsCompleteNuclearName().hashCode());
        result = prime * result + ((getSettleIsLicenseCollect() == null) ? 0 : getSettleIsLicenseCollect().hashCode());
        result = prime * result + ((getSettleIsCompletionSeal() == null) ? 0 : getSettleIsCompletionSeal().hashCode());
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
        sb.append(", unifiedSocialCredit=").append(unifiedSocialCredit);
        sb.append(", type=").append(type);
        sb.append(", industrialFId=").append(industrialFId);
        sb.append(", industrialFieldName=").append(industrialFieldName);
        sb.append(", enterpriseLegalPerson=").append(enterpriseLegalPerson);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", companyLogo=").append(companyLogo);
        sb.append(", companyProfile=").append(companyProfile);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectProfile=").append(projectProfile);
        sb.append(", teamId=").append(teamId);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactTelephone=").append(contactTelephone);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", projectIntroductionFile=").append(projectIntroductionFile);
        sb.append(", policyNotice=").append(policyNotice);
        sb.append(", policyIsSendOut=").append(policyIsSendOut);
        sb.append(", labelName=").append(labelName);
        sb.append(", labelId=").append(labelId);
        sb.append(", settleIsCompleteNuclearName=").append(settleIsCompleteNuclearName);
        sb.append(", settleIsLicenseCollect=").append(settleIsLicenseCollect);
        sb.append(", settleIsCompletionSeal=").append(settleIsCompletionSeal);
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