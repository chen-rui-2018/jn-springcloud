package com.jn.enterprise.pd.enterprise.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbPdEnterpriseSelfEvalua implements Serializable {
    /*@ApiModelProperty("唯一标识符")*/
    private Integer id;

    /*@ApiModelProperty("企业名称")*/
    private String enterpriseName;

    /*@ApiModelProperty("统一社会信用代码")*/
    private String unifiedSocialCredit;

    /*@ApiModelProperty("联系人姓名")*/
    private String contactsName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactsPhone;

    /*@ApiModelProperty("联系人邮箱")*/
    private String contactsEmail;

    /*@ApiModelProperty("企业注册时间")*/
    private Date enterpriseRegistrationTime;

    /*@ApiModelProperty("注册地址是否在中国境内（不含港，澳，台）(1:是，2:否)")*/
    private Byte isChinaTerritory;

    /*@ApiModelProperty("详细地址")*/
    private String detailedAddress;

    /*@ApiModelProperty("是否拥有对主要产品（服务）在技术上发挥核心支持作用的知识产权的所有权(1:是，2：否)")*/
    private Byte isCoreTechnology;

    /*@ApiModelProperty("所属技术邻域")*/
    private String technicalNeighborhood;

    /*@ApiModelProperty("职工总数")*/
    private Integer workersTatal;

    /*@ApiModelProperty("其中科技人员")*/
    private Integer technicalPersonnel;

    /*@ApiModelProperty("是否有违法行为（1：是，2：否）")*/
    private Byte isIllegalActivities;

    /*@ApiModelProperty("去年企业总收入")*/
    private BigDecimal corporateIncome1;

    /*@ApiModelProperty("前年总收入")*/
    private BigDecimal corporateIncome2;

    /*@ApiModelProperty("前两年总收入")*/
    private BigDecimal corporateIncome3;

    /*@ApiModelProperty("去年企业销售收入总额")*/
    private BigDecimal totalSalesRevenue1;

    /*@ApiModelProperty("前年企业销售收入总额")*/
    private BigDecimal totalSalesRevenue2;

    /*@ApiModelProperty("前两年企业销售收入总额")*/
    private BigDecimal totalSalesRevenue3;

    /*@ApiModelProperty("高新技术产品收入总额(去年)")*/
    private BigDecimal totalRevenueProducts1;

    /*@ApiModelProperty("高新技术产品收入总额(前年)")*/
    private BigDecimal totalRevenueProducts2;

    /*@ApiModelProperty("高新技术产品收入总额(前2年)")*/
    private BigDecimal totalRevenueProducts3;

    /*@ApiModelProperty("研究开发费用总金额(去年)")*/
    private BigDecimal totalAmountResearch1;

    /*@ApiModelProperty("研究开发费用总金额(前年)")*/
    private BigDecimal totalAmountResearch2;

    /*@ApiModelProperty("研究开发费用总金额(前两年)")*/
    private BigDecimal totalAmountResearch3;

    /*@ApiModelProperty("中国境内研究开发费用(去年)")*/
    private BigDecimal researchChina1;

    /*@ApiModelProperty("中国境内研究开发费用(前年)")*/
    private BigDecimal researchChina2;

    /*@ApiModelProperty("中国境内研究开发费用(前两年)")*/
    private BigDecimal researchChina3;

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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getUnifiedSocialCredit() {
        return unifiedSocialCredit;
    }

    public void setUnifiedSocialCredit(String unifiedSocialCredit) {
        this.unifiedSocialCredit = unifiedSocialCredit == null ? null : unifiedSocialCredit.trim();
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName == null ? null : contactsName.trim();
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone == null ? null : contactsPhone.trim();
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail == null ? null : contactsEmail.trim();
    }

    public Date getEnterpriseRegistrationTime() {
        return enterpriseRegistrationTime;
    }

    public void setEnterpriseRegistrationTime(Date enterpriseRegistrationTime) {
        this.enterpriseRegistrationTime = enterpriseRegistrationTime;
    }

    public Byte getIsChinaTerritory() {
        return isChinaTerritory;
    }

    public void setIsChinaTerritory(Byte isChinaTerritory) {
        this.isChinaTerritory = isChinaTerritory;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    public Byte getIsCoreTechnology() {
        return isCoreTechnology;
    }

    public void setIsCoreTechnology(Byte isCoreTechnology) {
        this.isCoreTechnology = isCoreTechnology;
    }

    public String getTechnicalNeighborhood() {
        return technicalNeighborhood;
    }

    public void setTechnicalNeighborhood(String technicalNeighborhood) {
        this.technicalNeighborhood = technicalNeighborhood == null ? null : technicalNeighborhood.trim();
    }

    public Integer getWorkersTatal() {
        return workersTatal;
    }

    public void setWorkersTatal(Integer workersTatal) {
        this.workersTatal = workersTatal;
    }

    public Integer getTechnicalPersonnel() {
        return technicalPersonnel;
    }

    public void setTechnicalPersonnel(Integer technicalPersonnel) {
        this.technicalPersonnel = technicalPersonnel;
    }

    public Byte getIsIllegalActivities() {
        return isIllegalActivities;
    }

    public void setIsIllegalActivities(Byte isIllegalActivities) {
        this.isIllegalActivities = isIllegalActivities;
    }

    public BigDecimal getCorporateIncome1() {
        return corporateIncome1;
    }

    public void setCorporateIncome1(BigDecimal corporateIncome1) {
        this.corporateIncome1 = corporateIncome1;
    }

    public BigDecimal getCorporateIncome2() {
        return corporateIncome2;
    }

    public void setCorporateIncome2(BigDecimal corporateIncome2) {
        this.corporateIncome2 = corporateIncome2;
    }

    public BigDecimal getCorporateIncome3() {
        return corporateIncome3;
    }

    public void setCorporateIncome3(BigDecimal corporateIncome3) {
        this.corporateIncome3 = corporateIncome3;
    }

    public BigDecimal getTotalSalesRevenue1() {
        return totalSalesRevenue1;
    }

    public void setTotalSalesRevenue1(BigDecimal totalSalesRevenue1) {
        this.totalSalesRevenue1 = totalSalesRevenue1;
    }

    public BigDecimal getTotalSalesRevenue2() {
        return totalSalesRevenue2;
    }

    public void setTotalSalesRevenue2(BigDecimal totalSalesRevenue2) {
        this.totalSalesRevenue2 = totalSalesRevenue2;
    }

    public BigDecimal getTotalSalesRevenue3() {
        return totalSalesRevenue3;
    }

    public void setTotalSalesRevenue3(BigDecimal totalSalesRevenue3) {
        this.totalSalesRevenue3 = totalSalesRevenue3;
    }

    public BigDecimal getTotalRevenueProducts1() {
        return totalRevenueProducts1;
    }

    public void setTotalRevenueProducts1(BigDecimal totalRevenueProducts1) {
        this.totalRevenueProducts1 = totalRevenueProducts1;
    }

    public BigDecimal getTotalRevenueProducts2() {
        return totalRevenueProducts2;
    }

    public void setTotalRevenueProducts2(BigDecimal totalRevenueProducts2) {
        this.totalRevenueProducts2 = totalRevenueProducts2;
    }

    public BigDecimal getTotalRevenueProducts3() {
        return totalRevenueProducts3;
    }

    public void setTotalRevenueProducts3(BigDecimal totalRevenueProducts3) {
        this.totalRevenueProducts3 = totalRevenueProducts3;
    }

    public BigDecimal getTotalAmountResearch1() {
        return totalAmountResearch1;
    }

    public void setTotalAmountResearch1(BigDecimal totalAmountResearch1) {
        this.totalAmountResearch1 = totalAmountResearch1;
    }

    public BigDecimal getTotalAmountResearch2() {
        return totalAmountResearch2;
    }

    public void setTotalAmountResearch2(BigDecimal totalAmountResearch2) {
        this.totalAmountResearch2 = totalAmountResearch2;
    }

    public BigDecimal getTotalAmountResearch3() {
        return totalAmountResearch3;
    }

    public void setTotalAmountResearch3(BigDecimal totalAmountResearch3) {
        this.totalAmountResearch3 = totalAmountResearch3;
    }

    public BigDecimal getResearchChina1() {
        return researchChina1;
    }

    public void setResearchChina1(BigDecimal researchChina1) {
        this.researchChina1 = researchChina1;
    }

    public BigDecimal getResearchChina2() {
        return researchChina2;
    }

    public void setResearchChina2(BigDecimal researchChina2) {
        this.researchChina2 = researchChina2;
    }

    public BigDecimal getResearchChina3() {
        return researchChina3;
    }

    public void setResearchChina3(BigDecimal researchChina3) {
        this.researchChina3 = researchChina3;
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
        TbPdEnterpriseSelfEvalua other = (TbPdEnterpriseSelfEvalua) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEnterpriseName() == null ? other.getEnterpriseName() == null : this.getEnterpriseName().equals(other.getEnterpriseName()))
            && (this.getUnifiedSocialCredit() == null ? other.getUnifiedSocialCredit() == null : this.getUnifiedSocialCredit().equals(other.getUnifiedSocialCredit()))
            && (this.getContactsName() == null ? other.getContactsName() == null : this.getContactsName().equals(other.getContactsName()))
            && (this.getContactsPhone() == null ? other.getContactsPhone() == null : this.getContactsPhone().equals(other.getContactsPhone()))
            && (this.getContactsEmail() == null ? other.getContactsEmail() == null : this.getContactsEmail().equals(other.getContactsEmail()))
            && (this.getEnterpriseRegistrationTime() == null ? other.getEnterpriseRegistrationTime() == null : this.getEnterpriseRegistrationTime().equals(other.getEnterpriseRegistrationTime()))
            && (this.getIsChinaTerritory() == null ? other.getIsChinaTerritory() == null : this.getIsChinaTerritory().equals(other.getIsChinaTerritory()))
            && (this.getDetailedAddress() == null ? other.getDetailedAddress() == null : this.getDetailedAddress().equals(other.getDetailedAddress()))
            && (this.getIsCoreTechnology() == null ? other.getIsCoreTechnology() == null : this.getIsCoreTechnology().equals(other.getIsCoreTechnology()))
            && (this.getTechnicalNeighborhood() == null ? other.getTechnicalNeighborhood() == null : this.getTechnicalNeighborhood().equals(other.getTechnicalNeighborhood()))
            && (this.getWorkersTatal() == null ? other.getWorkersTatal() == null : this.getWorkersTatal().equals(other.getWorkersTatal()))
            && (this.getTechnicalPersonnel() == null ? other.getTechnicalPersonnel() == null : this.getTechnicalPersonnel().equals(other.getTechnicalPersonnel()))
            && (this.getIsIllegalActivities() == null ? other.getIsIllegalActivities() == null : this.getIsIllegalActivities().equals(other.getIsIllegalActivities()))
            && (this.getCorporateIncome1() == null ? other.getCorporateIncome1() == null : this.getCorporateIncome1().equals(other.getCorporateIncome1()))
            && (this.getCorporateIncome2() == null ? other.getCorporateIncome2() == null : this.getCorporateIncome2().equals(other.getCorporateIncome2()))
            && (this.getCorporateIncome3() == null ? other.getCorporateIncome3() == null : this.getCorporateIncome3().equals(other.getCorporateIncome3()))
            && (this.getTotalSalesRevenue1() == null ? other.getTotalSalesRevenue1() == null : this.getTotalSalesRevenue1().equals(other.getTotalSalesRevenue1()))
            && (this.getTotalSalesRevenue2() == null ? other.getTotalSalesRevenue2() == null : this.getTotalSalesRevenue2().equals(other.getTotalSalesRevenue2()))
            && (this.getTotalSalesRevenue3() == null ? other.getTotalSalesRevenue3() == null : this.getTotalSalesRevenue3().equals(other.getTotalSalesRevenue3()))
            && (this.getTotalRevenueProducts1() == null ? other.getTotalRevenueProducts1() == null : this.getTotalRevenueProducts1().equals(other.getTotalRevenueProducts1()))
            && (this.getTotalRevenueProducts2() == null ? other.getTotalRevenueProducts2() == null : this.getTotalRevenueProducts2().equals(other.getTotalRevenueProducts2()))
            && (this.getTotalRevenueProducts3() == null ? other.getTotalRevenueProducts3() == null : this.getTotalRevenueProducts3().equals(other.getTotalRevenueProducts3()))
            && (this.getTotalAmountResearch1() == null ? other.getTotalAmountResearch1() == null : this.getTotalAmountResearch1().equals(other.getTotalAmountResearch1()))
            && (this.getTotalAmountResearch2() == null ? other.getTotalAmountResearch2() == null : this.getTotalAmountResearch2().equals(other.getTotalAmountResearch2()))
            && (this.getTotalAmountResearch3() == null ? other.getTotalAmountResearch3() == null : this.getTotalAmountResearch3().equals(other.getTotalAmountResearch3()))
            && (this.getResearchChina1() == null ? other.getResearchChina1() == null : this.getResearchChina1().equals(other.getResearchChina1()))
            && (this.getResearchChina2() == null ? other.getResearchChina2() == null : this.getResearchChina2().equals(other.getResearchChina2()))
            && (this.getResearchChina3() == null ? other.getResearchChina3() == null : this.getResearchChina3().equals(other.getResearchChina3()))
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
        result = prime * result + ((getEnterpriseName() == null) ? 0 : getEnterpriseName().hashCode());
        result = prime * result + ((getUnifiedSocialCredit() == null) ? 0 : getUnifiedSocialCredit().hashCode());
        result = prime * result + ((getContactsName() == null) ? 0 : getContactsName().hashCode());
        result = prime * result + ((getContactsPhone() == null) ? 0 : getContactsPhone().hashCode());
        result = prime * result + ((getContactsEmail() == null) ? 0 : getContactsEmail().hashCode());
        result = prime * result + ((getEnterpriseRegistrationTime() == null) ? 0 : getEnterpriseRegistrationTime().hashCode());
        result = prime * result + ((getIsChinaTerritory() == null) ? 0 : getIsChinaTerritory().hashCode());
        result = prime * result + ((getDetailedAddress() == null) ? 0 : getDetailedAddress().hashCode());
        result = prime * result + ((getIsCoreTechnology() == null) ? 0 : getIsCoreTechnology().hashCode());
        result = prime * result + ((getTechnicalNeighborhood() == null) ? 0 : getTechnicalNeighborhood().hashCode());
        result = prime * result + ((getWorkersTatal() == null) ? 0 : getWorkersTatal().hashCode());
        result = prime * result + ((getTechnicalPersonnel() == null) ? 0 : getTechnicalPersonnel().hashCode());
        result = prime * result + ((getIsIllegalActivities() == null) ? 0 : getIsIllegalActivities().hashCode());
        result = prime * result + ((getCorporateIncome1() == null) ? 0 : getCorporateIncome1().hashCode());
        result = prime * result + ((getCorporateIncome2() == null) ? 0 : getCorporateIncome2().hashCode());
        result = prime * result + ((getCorporateIncome3() == null) ? 0 : getCorporateIncome3().hashCode());
        result = prime * result + ((getTotalSalesRevenue1() == null) ? 0 : getTotalSalesRevenue1().hashCode());
        result = prime * result + ((getTotalSalesRevenue2() == null) ? 0 : getTotalSalesRevenue2().hashCode());
        result = prime * result + ((getTotalSalesRevenue3() == null) ? 0 : getTotalSalesRevenue3().hashCode());
        result = prime * result + ((getTotalRevenueProducts1() == null) ? 0 : getTotalRevenueProducts1().hashCode());
        result = prime * result + ((getTotalRevenueProducts2() == null) ? 0 : getTotalRevenueProducts2().hashCode());
        result = prime * result + ((getTotalRevenueProducts3() == null) ? 0 : getTotalRevenueProducts3().hashCode());
        result = prime * result + ((getTotalAmountResearch1() == null) ? 0 : getTotalAmountResearch1().hashCode());
        result = prime * result + ((getTotalAmountResearch2() == null) ? 0 : getTotalAmountResearch2().hashCode());
        result = prime * result + ((getTotalAmountResearch3() == null) ? 0 : getTotalAmountResearch3().hashCode());
        result = prime * result + ((getResearchChina1() == null) ? 0 : getResearchChina1().hashCode());
        result = prime * result + ((getResearchChina2() == null) ? 0 : getResearchChina2().hashCode());
        result = prime * result + ((getResearchChina3() == null) ? 0 : getResearchChina3().hashCode());
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
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", unifiedSocialCredit=").append(unifiedSocialCredit);
        sb.append(", contactsName=").append(contactsName);
        sb.append(", contactsPhone=").append(contactsPhone);
        sb.append(", contactsEmail=").append(contactsEmail);
        sb.append(", enterpriseRegistrationTime=").append(enterpriseRegistrationTime);
        sb.append(", isChinaTerritory=").append(isChinaTerritory);
        sb.append(", detailedAddress=").append(detailedAddress);
        sb.append(", isCoreTechnology=").append(isCoreTechnology);
        sb.append(", technicalNeighborhood=").append(technicalNeighborhood);
        sb.append(", workersTatal=").append(workersTatal);
        sb.append(", technicalPersonnel=").append(technicalPersonnel);
        sb.append(", isIllegalActivities=").append(isIllegalActivities);
        sb.append(", corporateIncome1=").append(corporateIncome1);
        sb.append(", corporateIncome2=").append(corporateIncome2);
        sb.append(", corporateIncome3=").append(corporateIncome3);
        sb.append(", totalSalesRevenue1=").append(totalSalesRevenue1);
        sb.append(", totalSalesRevenue2=").append(totalSalesRevenue2);
        sb.append(", totalSalesRevenue3=").append(totalSalesRevenue3);
        sb.append(", totalRevenueProducts1=").append(totalRevenueProducts1);
        sb.append(", totalRevenueProducts2=").append(totalRevenueProducts2);
        sb.append(", totalRevenueProducts3=").append(totalRevenueProducts3);
        sb.append(", totalAmountResearch1=").append(totalAmountResearch1);
        sb.append(", totalAmountResearch2=").append(totalAmountResearch2);
        sb.append(", totalAmountResearch3=").append(totalAmountResearch3);
        sb.append(", researchChina1=").append(researchChina1);
        sb.append(", researchChina2=").append(researchChina2);
        sb.append(", researchChina3=").append(researchChina3);
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