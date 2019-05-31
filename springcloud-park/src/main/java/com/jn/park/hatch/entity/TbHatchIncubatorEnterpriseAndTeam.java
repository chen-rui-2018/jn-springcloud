package com.jn.park.hatch.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbHatchIncubatorEnterpriseAndTeam implements Serializable {
    private String id;

    private String logoUrl;

    private String creditCode;

    private String type;

    private String name;

    private Date establishTime;

    private String enterPersonHtml;

    private Double areaCover;

    private Double regCapital;

    private String legalPerson;

    private String teamHtml;

    private String productHtml;

    private String licenseUrl;

    private String contacts;

    private String phone;

    private String enterpriseNatureId;

    private String enterpriseNatureName;

    private String enterpriseTypeId;

    private String enterpriseTypeName;

    private String enterpriseTechId;

    private String enterpriseTechName;

    private String officeLocation;

    private String enterIncId;

    private String enterIncName;

    private String dataSources;

    private Date applicationTime;

    private String status;

    private String recordStatus;

    private String creatorAccount;

    private String comAdmin;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String isTalent;

    private String isTech;

    private BigDecimal rentfreeAmount;

    private String requestIncId;

    private String requestIncName;

    private String proName;

    private String proSynopsis;

    private String isFinanc;

    private BigDecimal financNum;

    private String proIntroduc;

    private BigDecimal taxValue;

    private BigDecimal revenueValue;

    private BigDecimal financValue;

    private String policyDeclarat;

    private String enrolmentActivities;

    private String graduateStatus;

    private String graduateRequirements;

    private Date graduatieTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    public String getEnterPersonHtml() {
        return enterPersonHtml;
    }

    public void setEnterPersonHtml(String enterPersonHtml) {
        this.enterPersonHtml = enterPersonHtml == null ? null : enterPersonHtml.trim();
    }

    public Double getAreaCover() {
        return areaCover;
    }

    public void setAreaCover(Double areaCover) {
        this.areaCover = areaCover;
    }

    public Double getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Double regCapital) {
        this.regCapital = regCapital;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getTeamHtml() {
        return teamHtml;
    }

    public void setTeamHtml(String teamHtml) {
        this.teamHtml = teamHtml == null ? null : teamHtml.trim();
    }

    public String getProductHtml() {
        return productHtml;
    }

    public void setProductHtml(String productHtml) {
        this.productHtml = productHtml == null ? null : productHtml.trim();
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl == null ? null : licenseUrl.trim();
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

    public String getEnterpriseNatureId() {
        return enterpriseNatureId;
    }

    public void setEnterpriseNatureId(String enterpriseNatureId) {
        this.enterpriseNatureId = enterpriseNatureId == null ? null : enterpriseNatureId.trim();
    }

    public String getEnterpriseNatureName() {
        return enterpriseNatureName;
    }

    public void setEnterpriseNatureName(String enterpriseNatureName) {
        this.enterpriseNatureName = enterpriseNatureName == null ? null : enterpriseNatureName.trim();
    }

    public String getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    public void setEnterpriseTypeId(String enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId == null ? null : enterpriseTypeId.trim();
    }

    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }

    public void setEnterpriseTypeName(String enterpriseTypeName) {
        this.enterpriseTypeName = enterpriseTypeName == null ? null : enterpriseTypeName.trim();
    }

    public String getEnterpriseTechId() {
        return enterpriseTechId;
    }

    public void setEnterpriseTechId(String enterpriseTechId) {
        this.enterpriseTechId = enterpriseTechId == null ? null : enterpriseTechId.trim();
    }

    public String getEnterpriseTechName() {
        return enterpriseTechName;
    }

    public void setEnterpriseTechName(String enterpriseTechName) {
        this.enterpriseTechName = enterpriseTechName == null ? null : enterpriseTechName.trim();
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation == null ? null : officeLocation.trim();
    }

    public String getEnterIncId() {
        return enterIncId;
    }

    public void setEnterIncId(String enterIncId) {
        this.enterIncId = enterIncId == null ? null : enterIncId.trim();
    }

    public String getEnterIncName() {
        return enterIncName;
    }

    public void setEnterIncName(String enterIncName) {
        this.enterIncName = enterIncName == null ? null : enterIncName.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin == null ? null : comAdmin.trim();
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

    public String getIsTalent() {
        return isTalent;
    }

    public void setIsTalent(String isTalent) {
        this.isTalent = isTalent == null ? null : isTalent.trim();
    }

    public String getIsTech() {
        return isTech;
    }

    public void setIsTech(String isTech) {
        this.isTech = isTech == null ? null : isTech.trim();
    }

    public BigDecimal getRentfreeAmount() {
        return rentfreeAmount;
    }

    public void setRentfreeAmount(BigDecimal rentfreeAmount) {
        this.rentfreeAmount = rentfreeAmount;
    }

    public String getRequestIncId() {
        return requestIncId;
    }

    public void setRequestIncId(String requestIncId) {
        this.requestIncId = requestIncId == null ? null : requestIncId.trim();
    }

    public String getRequestIncName() {
        return requestIncName;
    }

    public void setRequestIncName(String requestIncName) {
        this.requestIncName = requestIncName == null ? null : requestIncName.trim();
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

    public String getProIntroduc() {
        return proIntroduc;
    }

    public void setProIntroduc(String proIntroduc) {
        this.proIntroduc = proIntroduc == null ? null : proIntroduc.trim();
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public BigDecimal getRevenueValue() {
        return revenueValue;
    }

    public void setRevenueValue(BigDecimal revenueValue) {
        this.revenueValue = revenueValue;
    }

    public BigDecimal getFinancValue() {
        return financValue;
    }

    public void setFinancValue(BigDecimal financValue) {
        this.financValue = financValue;
    }

    public String getPolicyDeclarat() {
        return policyDeclarat;
    }

    public void setPolicyDeclarat(String policyDeclarat) {
        this.policyDeclarat = policyDeclarat == null ? null : policyDeclarat.trim();
    }

    public String getEnrolmentActivities() {
        return enrolmentActivities;
    }

    public void setEnrolmentActivities(String enrolmentActivities) {
        this.enrolmentActivities = enrolmentActivities == null ? null : enrolmentActivities.trim();
    }

    public String getGraduateStatus() {
        return graduateStatus;
    }

    public void setGraduateStatus(String graduateStatus) {
        this.graduateStatus = graduateStatus == null ? null : graduateStatus.trim();
    }

    public String getGraduateRequirements() {
        return graduateRequirements;
    }

    public void setGraduateRequirements(String graduateRequirements) {
        this.graduateRequirements = graduateRequirements == null ? null : graduateRequirements.trim();
    }

    public Date getGraduatieTime() {
        return graduatieTime;
    }

    public void setGraduatieTime(Date graduatieTime) {
        this.graduatieTime = graduatieTime;
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
        TbHatchIncubatorEnterpriseAndTeam other = (TbHatchIncubatorEnterpriseAndTeam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLogoUrl() == null ? other.getLogoUrl() == null : this.getLogoUrl().equals(other.getLogoUrl()))
            && (this.getCreditCode() == null ? other.getCreditCode() == null : this.getCreditCode().equals(other.getCreditCode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEstablishTime() == null ? other.getEstablishTime() == null : this.getEstablishTime().equals(other.getEstablishTime()))
            && (this.getEnterPersonHtml() == null ? other.getEnterPersonHtml() == null : this.getEnterPersonHtml().equals(other.getEnterPersonHtml()))
            && (this.getAreaCover() == null ? other.getAreaCover() == null : this.getAreaCover().equals(other.getAreaCover()))
            && (this.getRegCapital() == null ? other.getRegCapital() == null : this.getRegCapital().equals(other.getRegCapital()))
            && (this.getLegalPerson() == null ? other.getLegalPerson() == null : this.getLegalPerson().equals(other.getLegalPerson()))
            && (this.getTeamHtml() == null ? other.getTeamHtml() == null : this.getTeamHtml().equals(other.getTeamHtml()))
            && (this.getProductHtml() == null ? other.getProductHtml() == null : this.getProductHtml().equals(other.getProductHtml()))
            && (this.getLicenseUrl() == null ? other.getLicenseUrl() == null : this.getLicenseUrl().equals(other.getLicenseUrl()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEnterpriseNatureId() == null ? other.getEnterpriseNatureId() == null : this.getEnterpriseNatureId().equals(other.getEnterpriseNatureId()))
            && (this.getEnterpriseNatureName() == null ? other.getEnterpriseNatureName() == null : this.getEnterpriseNatureName().equals(other.getEnterpriseNatureName()))
            && (this.getEnterpriseTypeId() == null ? other.getEnterpriseTypeId() == null : this.getEnterpriseTypeId().equals(other.getEnterpriseTypeId()))
            && (this.getEnterpriseTypeName() == null ? other.getEnterpriseTypeName() == null : this.getEnterpriseTypeName().equals(other.getEnterpriseTypeName()))
            && (this.getEnterpriseTechId() == null ? other.getEnterpriseTechId() == null : this.getEnterpriseTechId().equals(other.getEnterpriseTechId()))
            && (this.getEnterpriseTechName() == null ? other.getEnterpriseTechName() == null : this.getEnterpriseTechName().equals(other.getEnterpriseTechName()))
            && (this.getOfficeLocation() == null ? other.getOfficeLocation() == null : this.getOfficeLocation().equals(other.getOfficeLocation()))
            && (this.getEnterIncId() == null ? other.getEnterIncId() == null : this.getEnterIncId().equals(other.getEnterIncId()))
            && (this.getEnterIncName() == null ? other.getEnterIncName() == null : this.getEnterIncName().equals(other.getEnterIncName()))
            && (this.getDataSources() == null ? other.getDataSources() == null : this.getDataSources().equals(other.getDataSources()))
            && (this.getApplicationTime() == null ? other.getApplicationTime() == null : this.getApplicationTime().equals(other.getApplicationTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getComAdmin() == null ? other.getComAdmin() == null : this.getComAdmin().equals(other.getComAdmin()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getIsTalent() == null ? other.getIsTalent() == null : this.getIsTalent().equals(other.getIsTalent()))
            && (this.getIsTech() == null ? other.getIsTech() == null : this.getIsTech().equals(other.getIsTech()))
            && (this.getRentfreeAmount() == null ? other.getRentfreeAmount() == null : this.getRentfreeAmount().equals(other.getRentfreeAmount()))
            && (this.getRequestIncId() == null ? other.getRequestIncId() == null : this.getRequestIncId().equals(other.getRequestIncId()))
            && (this.getRequestIncName() == null ? other.getRequestIncName() == null : this.getRequestIncName().equals(other.getRequestIncName()))
            && (this.getProName() == null ? other.getProName() == null : this.getProName().equals(other.getProName()))
            && (this.getProSynopsis() == null ? other.getProSynopsis() == null : this.getProSynopsis().equals(other.getProSynopsis()))
            && (this.getIsFinanc() == null ? other.getIsFinanc() == null : this.getIsFinanc().equals(other.getIsFinanc()))
            && (this.getFinancNum() == null ? other.getFinancNum() == null : this.getFinancNum().equals(other.getFinancNum()))
            && (this.getProIntroduc() == null ? other.getProIntroduc() == null : this.getProIntroduc().equals(other.getProIntroduc()))
            && (this.getTaxValue() == null ? other.getTaxValue() == null : this.getTaxValue().equals(other.getTaxValue()))
            && (this.getRevenueValue() == null ? other.getRevenueValue() == null : this.getRevenueValue().equals(other.getRevenueValue()))
            && (this.getFinancValue() == null ? other.getFinancValue() == null : this.getFinancValue().equals(other.getFinancValue()))
            && (this.getPolicyDeclarat() == null ? other.getPolicyDeclarat() == null : this.getPolicyDeclarat().equals(other.getPolicyDeclarat()))
            && (this.getEnrolmentActivities() == null ? other.getEnrolmentActivities() == null : this.getEnrolmentActivities().equals(other.getEnrolmentActivities()))
            && (this.getGraduateStatus() == null ? other.getGraduateStatus() == null : this.getGraduateStatus().equals(other.getGraduateStatus()))
            && (this.getGraduateRequirements() == null ? other.getGraduateRequirements() == null : this.getGraduateRequirements().equals(other.getGraduateRequirements()))
            && (this.getGraduatieTime() == null ? other.getGraduatieTime() == null : this.getGraduatieTime().equals(other.getGraduatieTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLogoUrl() == null) ? 0 : getLogoUrl().hashCode());
        result = prime * result + ((getCreditCode() == null) ? 0 : getCreditCode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEstablishTime() == null) ? 0 : getEstablishTime().hashCode());
        result = prime * result + ((getEnterPersonHtml() == null) ? 0 : getEnterPersonHtml().hashCode());
        result = prime * result + ((getAreaCover() == null) ? 0 : getAreaCover().hashCode());
        result = prime * result + ((getRegCapital() == null) ? 0 : getRegCapital().hashCode());
        result = prime * result + ((getLegalPerson() == null) ? 0 : getLegalPerson().hashCode());
        result = prime * result + ((getTeamHtml() == null) ? 0 : getTeamHtml().hashCode());
        result = prime * result + ((getProductHtml() == null) ? 0 : getProductHtml().hashCode());
        result = prime * result + ((getLicenseUrl() == null) ? 0 : getLicenseUrl().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEnterpriseNatureId() == null) ? 0 : getEnterpriseNatureId().hashCode());
        result = prime * result + ((getEnterpriseNatureName() == null) ? 0 : getEnterpriseNatureName().hashCode());
        result = prime * result + ((getEnterpriseTypeId() == null) ? 0 : getEnterpriseTypeId().hashCode());
        result = prime * result + ((getEnterpriseTypeName() == null) ? 0 : getEnterpriseTypeName().hashCode());
        result = prime * result + ((getEnterpriseTechId() == null) ? 0 : getEnterpriseTechId().hashCode());
        result = prime * result + ((getEnterpriseTechName() == null) ? 0 : getEnterpriseTechName().hashCode());
        result = prime * result + ((getOfficeLocation() == null) ? 0 : getOfficeLocation().hashCode());
        result = prime * result + ((getEnterIncId() == null) ? 0 : getEnterIncId().hashCode());
        result = prime * result + ((getEnterIncName() == null) ? 0 : getEnterIncName().hashCode());
        result = prime * result + ((getDataSources() == null) ? 0 : getDataSources().hashCode());
        result = prime * result + ((getApplicationTime() == null) ? 0 : getApplicationTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getComAdmin() == null) ? 0 : getComAdmin().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getIsTalent() == null) ? 0 : getIsTalent().hashCode());
        result = prime * result + ((getIsTech() == null) ? 0 : getIsTech().hashCode());
        result = prime * result + ((getRentfreeAmount() == null) ? 0 : getRentfreeAmount().hashCode());
        result = prime * result + ((getRequestIncId() == null) ? 0 : getRequestIncId().hashCode());
        result = prime * result + ((getRequestIncName() == null) ? 0 : getRequestIncName().hashCode());
        result = prime * result + ((getProName() == null) ? 0 : getProName().hashCode());
        result = prime * result + ((getProSynopsis() == null) ? 0 : getProSynopsis().hashCode());
        result = prime * result + ((getIsFinanc() == null) ? 0 : getIsFinanc().hashCode());
        result = prime * result + ((getFinancNum() == null) ? 0 : getFinancNum().hashCode());
        result = prime * result + ((getProIntroduc() == null) ? 0 : getProIntroduc().hashCode());
        result = prime * result + ((getTaxValue() == null) ? 0 : getTaxValue().hashCode());
        result = prime * result + ((getRevenueValue() == null) ? 0 : getRevenueValue().hashCode());
        result = prime * result + ((getFinancValue() == null) ? 0 : getFinancValue().hashCode());
        result = prime * result + ((getPolicyDeclarat() == null) ? 0 : getPolicyDeclarat().hashCode());
        result = prime * result + ((getEnrolmentActivities() == null) ? 0 : getEnrolmentActivities().hashCode());
        result = prime * result + ((getGraduateStatus() == null) ? 0 : getGraduateStatus().hashCode());
        result = prime * result + ((getGraduateRequirements() == null) ? 0 : getGraduateRequirements().hashCode());
        result = prime * result + ((getGraduatieTime() == null) ? 0 : getGraduatieTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logoUrl=").append(logoUrl);
        sb.append(", creditCode=").append(creditCode);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", establishTime=").append(establishTime);
        sb.append(", enterPersonHtml=").append(enterPersonHtml);
        sb.append(", areaCover=").append(areaCover);
        sb.append(", regCapital=").append(regCapital);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", teamHtml=").append(teamHtml);
        sb.append(", productHtml=").append(productHtml);
        sb.append(", licenseUrl=").append(licenseUrl);
        sb.append(", contacts=").append(contacts);
        sb.append(", phone=").append(phone);
        sb.append(", enterpriseNatureId=").append(enterpriseNatureId);
        sb.append(", enterpriseNatureName=").append(enterpriseNatureName);
        sb.append(", enterpriseTypeId=").append(enterpriseTypeId);
        sb.append(", enterpriseTypeName=").append(enterpriseTypeName);
        sb.append(", enterpriseTechId=").append(enterpriseTechId);
        sb.append(", enterpriseTechName=").append(enterpriseTechName);
        sb.append(", officeLocation=").append(officeLocation);
        sb.append(", enterIncId=").append(enterIncId);
        sb.append(", enterIncName=").append(enterIncName);
        sb.append(", dataSources=").append(dataSources);
        sb.append(", applicationTime=").append(applicationTime);
        sb.append(", status=").append(status);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", comAdmin=").append(comAdmin);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", isTalent=").append(isTalent);
        sb.append(", isTech=").append(isTech);
        sb.append(", rentfreeAmount=").append(rentfreeAmount);
        sb.append(", requestIncId=").append(requestIncId);
        sb.append(", requestIncName=").append(requestIncName);
        sb.append(", proName=").append(proName);
        sb.append(", proSynopsis=").append(proSynopsis);
        sb.append(", isFinanc=").append(isFinanc);
        sb.append(", financNum=").append(financNum);
        sb.append(", proIntroduc=").append(proIntroduc);
        sb.append(", taxValue=").append(taxValue);
        sb.append(", revenueValue=").append(revenueValue);
        sb.append(", financValue=").append(financValue);
        sb.append(", policyDeclarat=").append(policyDeclarat);
        sb.append(", enrolmentActivities=").append(enrolmentActivities);
        sb.append(", graduateStatus=").append(graduateStatus);
        sb.append(", graduateRequirements=").append(graduateRequirements);
        sb.append(", graduatieTime=").append(graduatieTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}