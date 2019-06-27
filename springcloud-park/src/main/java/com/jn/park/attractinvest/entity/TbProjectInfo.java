package com.jn.park.attractinvest.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbProjectInfo implements Serializable {
    private String id;

    private String projectName;

    private String source;

    private String size;

    private String introducer;

    private Byte recordStatus;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private Date modifiedTime;

    private String industryAssessment;

    private String departmentId;

    private String departmentName;

    private Byte status;

    private String projectProcess;

    private String compactStatus;

    private Date compactStartTime;

    private Date compactEndTime;

    private String investmentApprover;

    private Date investmentApproverTime;

    private String propertyApprover;

    private Date propertyApproverTime;

    private String pmApprover;

    private Date pmApproverTime;

    private String companyName;

    private String companyId;

    private String rentInfo;

    private Date expectEnterTime;

    private Date sureTime;

    private String approvalOpioion;

    private String legalPersoner;

    private String legalPhone;

    private String comAdmin;

    private String linker;

    private String linkerPhone;

    private String enterpriseProperty;

    private String industryTypeName;

    private String industryType;

    private Date rentStartTime;

    private Date comEntTime;

    private Integer rentMonthNum;

    private String remerk;

    private BigDecimal actualTotalAccount;

    private String roomBillId;

    private Date enterTime;

    private String mainTowerId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer == null ? null : introducer.trim();
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

    public String getIndustryAssessment() {
        return industryAssessment;
    }

    public void setIndustryAssessment(String industryAssessment) {
        this.industryAssessment = industryAssessment == null ? null : industryAssessment.trim();
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getProjectProcess() {
        return projectProcess;
    }

    public void setProjectProcess(String projectProcess) {
        this.projectProcess = projectProcess == null ? null : projectProcess.trim();
    }

    public String getCompactStatus() {
        return compactStatus;
    }

    public void setCompactStatus(String compactStatus) {
        this.compactStatus = compactStatus == null ? null : compactStatus.trim();
    }

    public Date getCompactStartTime() {
        return compactStartTime;
    }

    public void setCompactStartTime(Date compactStartTime) {
        this.compactStartTime = compactStartTime;
    }

    public Date getCompactEndTime() {
        return compactEndTime;
    }

    public void setCompactEndTime(Date compactEndTime) {
        this.compactEndTime = compactEndTime;
    }

    public String getInvestmentApprover() {
        return investmentApprover;
    }

    public void setInvestmentApprover(String investmentApprover) {
        this.investmentApprover = investmentApprover == null ? null : investmentApprover.trim();
    }

    public Date getInvestmentApproverTime() {
        return investmentApproverTime;
    }

    public void setInvestmentApproverTime(Date investmentApproverTime) {
        this.investmentApproverTime = investmentApproverTime;
    }

    public String getPropertyApprover() {
        return propertyApprover;
    }

    public void setPropertyApprover(String propertyApprover) {
        this.propertyApprover = propertyApprover == null ? null : propertyApprover.trim();
    }

    public Date getPropertyApproverTime() {
        return propertyApproverTime;
    }

    public void setPropertyApproverTime(Date propertyApproverTime) {
        this.propertyApproverTime = propertyApproverTime;
    }

    public String getPmApprover() {
        return pmApprover;
    }

    public void setPmApprover(String pmApprover) {
        this.pmApprover = pmApprover == null ? null : pmApprover.trim();
    }

    public Date getPmApproverTime() {
        return pmApproverTime;
    }

    public void setPmApproverTime(Date pmApproverTime) {
        this.pmApproverTime = pmApproverTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getRentInfo() {
        return rentInfo;
    }

    public void setRentInfo(String rentInfo) {
        this.rentInfo = rentInfo == null ? null : rentInfo.trim();
    }

    public Date getExpectEnterTime() {
        return expectEnterTime;
    }

    public void setExpectEnterTime(Date expectEnterTime) {
        this.expectEnterTime = expectEnterTime;
    }

    public Date getSureTime() {
        return sureTime;
    }

    public void setSureTime(Date sureTime) {
        this.sureTime = sureTime;
    }

    public String getApprovalOpioion() {
        return approvalOpioion;
    }

    public void setApprovalOpioion(String approvalOpioion) {
        this.approvalOpioion = approvalOpioion == null ? null : approvalOpioion.trim();
    }

    public String getLegalPersoner() {
        return legalPersoner;
    }

    public void setLegalPersoner(String legalPersoner) {
        this.legalPersoner = legalPersoner == null ? null : legalPersoner.trim();
    }

    public String getLegalPhone() {
        return legalPhone;
    }

    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone == null ? null : legalPhone.trim();
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin == null ? null : comAdmin.trim();
    }

    public String getLinker() {
        return linker;
    }

    public void setLinker(String linker) {
        this.linker = linker == null ? null : linker.trim();
    }

    public String getLinkerPhone() {
        return linkerPhone;
    }

    public void setLinkerPhone(String linkerPhone) {
        this.linkerPhone = linkerPhone == null ? null : linkerPhone.trim();
    }

    public String getEnterpriseProperty() {
        return enterpriseProperty;
    }

    public void setEnterpriseProperty(String enterpriseProperty) {
        this.enterpriseProperty = enterpriseProperty == null ? null : enterpriseProperty.trim();
    }

    public String getIndustryTypeName() {
        return industryTypeName;
    }

    public void setIndustryTypeName(String industryTypeName) {
        this.industryTypeName = industryTypeName == null ? null : industryTypeName.trim();
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType == null ? null : industryType.trim();
    }

    public Date getRentStartTime() {
        return rentStartTime;
    }

    public void setRentStartTime(Date rentStartTime) {
        this.rentStartTime = rentStartTime;
    }

    public Date getComEntTime() {
        return comEntTime;
    }

    public void setComEntTime(Date comEntTime) {
        this.comEntTime = comEntTime;
    }

    public Integer getRentMonthNum() {
        return rentMonthNum;
    }

    public void setRentMonthNum(Integer rentMonthNum) {
        this.rentMonthNum = rentMonthNum;
    }

    public String getRemerk() {
        return remerk;
    }

    public void setRemerk(String remerk) {
        this.remerk = remerk == null ? null : remerk.trim();
    }

    public BigDecimal getActualTotalAccount() {
        return actualTotalAccount;
    }

    public void setActualTotalAccount(BigDecimal actualTotalAccount) {
        this.actualTotalAccount = actualTotalAccount;
    }

    public String getRoomBillId() {
        return roomBillId;
    }

    public void setRoomBillId(String roomBillId) {
        this.roomBillId = roomBillId == null ? null : roomBillId.trim();
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public String getMainTowerId() {
        return mainTowerId;
    }

    public void setMainTowerId(String mainTowerId) {
        this.mainTowerId = mainTowerId == null ? null : mainTowerId.trim();
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
        TbProjectInfo other = (TbProjectInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getIntroducer() == null ? other.getIntroducer() == null : this.getIntroducer().equals(other.getIntroducer()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getIndustryAssessment() == null ? other.getIndustryAssessment() == null : this.getIndustryAssessment().equals(other.getIndustryAssessment()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProjectProcess() == null ? other.getProjectProcess() == null : this.getProjectProcess().equals(other.getProjectProcess()))
            && (this.getCompactStatus() == null ? other.getCompactStatus() == null : this.getCompactStatus().equals(other.getCompactStatus()))
            && (this.getCompactStartTime() == null ? other.getCompactStartTime() == null : this.getCompactStartTime().equals(other.getCompactStartTime()))
            && (this.getCompactEndTime() == null ? other.getCompactEndTime() == null : this.getCompactEndTime().equals(other.getCompactEndTime()))
            && (this.getInvestmentApprover() == null ? other.getInvestmentApprover() == null : this.getInvestmentApprover().equals(other.getInvestmentApprover()))
            && (this.getInvestmentApproverTime() == null ? other.getInvestmentApproverTime() == null : this.getInvestmentApproverTime().equals(other.getInvestmentApproverTime()))
            && (this.getPropertyApprover() == null ? other.getPropertyApprover() == null : this.getPropertyApprover().equals(other.getPropertyApprover()))
            && (this.getPropertyApproverTime() == null ? other.getPropertyApproverTime() == null : this.getPropertyApproverTime().equals(other.getPropertyApproverTime()))
            && (this.getPmApprover() == null ? other.getPmApprover() == null : this.getPmApprover().equals(other.getPmApprover()))
            && (this.getPmApproverTime() == null ? other.getPmApproverTime() == null : this.getPmApproverTime().equals(other.getPmApproverTime()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getRentInfo() == null ? other.getRentInfo() == null : this.getRentInfo().equals(other.getRentInfo()))
            && (this.getExpectEnterTime() == null ? other.getExpectEnterTime() == null : this.getExpectEnterTime().equals(other.getExpectEnterTime()))
            && (this.getSureTime() == null ? other.getSureTime() == null : this.getSureTime().equals(other.getSureTime()))
            && (this.getApprovalOpioion() == null ? other.getApprovalOpioion() == null : this.getApprovalOpioion().equals(other.getApprovalOpioion()))
            && (this.getLegalPersoner() == null ? other.getLegalPersoner() == null : this.getLegalPersoner().equals(other.getLegalPersoner()))
            && (this.getLegalPhone() == null ? other.getLegalPhone() == null : this.getLegalPhone().equals(other.getLegalPhone()))
            && (this.getComAdmin() == null ? other.getComAdmin() == null : this.getComAdmin().equals(other.getComAdmin()))
            && (this.getLinker() == null ? other.getLinker() == null : this.getLinker().equals(other.getLinker()))
            && (this.getLinkerPhone() == null ? other.getLinkerPhone() == null : this.getLinkerPhone().equals(other.getLinkerPhone()))
            && (this.getEnterpriseProperty() == null ? other.getEnterpriseProperty() == null : this.getEnterpriseProperty().equals(other.getEnterpriseProperty()))
            && (this.getIndustryTypeName() == null ? other.getIndustryTypeName() == null : this.getIndustryTypeName().equals(other.getIndustryTypeName()))
            && (this.getIndustryType() == null ? other.getIndustryType() == null : this.getIndustryType().equals(other.getIndustryType()))
            && (this.getRentStartTime() == null ? other.getRentStartTime() == null : this.getRentStartTime().equals(other.getRentStartTime()))
            && (this.getComEntTime() == null ? other.getComEntTime() == null : this.getComEntTime().equals(other.getComEntTime()))
            && (this.getRentMonthNum() == null ? other.getRentMonthNum() == null : this.getRentMonthNum().equals(other.getRentMonthNum()))
            && (this.getRemerk() == null ? other.getRemerk() == null : this.getRemerk().equals(other.getRemerk()))
            && (this.getActualTotalAccount() == null ? other.getActualTotalAccount() == null : this.getActualTotalAccount().equals(other.getActualTotalAccount()))
            && (this.getRoomBillId() == null ? other.getRoomBillId() == null : this.getRoomBillId().equals(other.getRoomBillId()))
            && (this.getEnterTime() == null ? other.getEnterTime() == null : this.getEnterTime().equals(other.getEnterTime()))
            && (this.getMainTowerId() == null ? other.getMainTowerId() == null : this.getMainTowerId().equals(other.getMainTowerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getIntroducer() == null) ? 0 : getIntroducer().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getIndustryAssessment() == null) ? 0 : getIndustryAssessment().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProjectProcess() == null) ? 0 : getProjectProcess().hashCode());
        result = prime * result + ((getCompactStatus() == null) ? 0 : getCompactStatus().hashCode());
        result = prime * result + ((getCompactStartTime() == null) ? 0 : getCompactStartTime().hashCode());
        result = prime * result + ((getCompactEndTime() == null) ? 0 : getCompactEndTime().hashCode());
        result = prime * result + ((getInvestmentApprover() == null) ? 0 : getInvestmentApprover().hashCode());
        result = prime * result + ((getInvestmentApproverTime() == null) ? 0 : getInvestmentApproverTime().hashCode());
        result = prime * result + ((getPropertyApprover() == null) ? 0 : getPropertyApprover().hashCode());
        result = prime * result + ((getPropertyApproverTime() == null) ? 0 : getPropertyApproverTime().hashCode());
        result = prime * result + ((getPmApprover() == null) ? 0 : getPmApprover().hashCode());
        result = prime * result + ((getPmApproverTime() == null) ? 0 : getPmApproverTime().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getRentInfo() == null) ? 0 : getRentInfo().hashCode());
        result = prime * result + ((getExpectEnterTime() == null) ? 0 : getExpectEnterTime().hashCode());
        result = prime * result + ((getSureTime() == null) ? 0 : getSureTime().hashCode());
        result = prime * result + ((getApprovalOpioion() == null) ? 0 : getApprovalOpioion().hashCode());
        result = prime * result + ((getLegalPersoner() == null) ? 0 : getLegalPersoner().hashCode());
        result = prime * result + ((getLegalPhone() == null) ? 0 : getLegalPhone().hashCode());
        result = prime * result + ((getComAdmin() == null) ? 0 : getComAdmin().hashCode());
        result = prime * result + ((getLinker() == null) ? 0 : getLinker().hashCode());
        result = prime * result + ((getLinkerPhone() == null) ? 0 : getLinkerPhone().hashCode());
        result = prime * result + ((getEnterpriseProperty() == null) ? 0 : getEnterpriseProperty().hashCode());
        result = prime * result + ((getIndustryTypeName() == null) ? 0 : getIndustryTypeName().hashCode());
        result = prime * result + ((getIndustryType() == null) ? 0 : getIndustryType().hashCode());
        result = prime * result + ((getRentStartTime() == null) ? 0 : getRentStartTime().hashCode());
        result = prime * result + ((getComEntTime() == null) ? 0 : getComEntTime().hashCode());
        result = prime * result + ((getRentMonthNum() == null) ? 0 : getRentMonthNum().hashCode());
        result = prime * result + ((getRemerk() == null) ? 0 : getRemerk().hashCode());
        result = prime * result + ((getActualTotalAccount() == null) ? 0 : getActualTotalAccount().hashCode());
        result = prime * result + ((getRoomBillId() == null) ? 0 : getRoomBillId().hashCode());
        result = prime * result + ((getEnterTime() == null) ? 0 : getEnterTime().hashCode());
        result = prime * result + ((getMainTowerId() == null) ? 0 : getMainTowerId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", projectName=").append(projectName);
        sb.append(", source=").append(source);
        sb.append(", size=").append(size);
        sb.append(", introducer=").append(introducer);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", industryAssessment=").append(industryAssessment);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", status=").append(status);
        sb.append(", projectProcess=").append(projectProcess);
        sb.append(", compactStatus=").append(compactStatus);
        sb.append(", compactStartTime=").append(compactStartTime);
        sb.append(", compactEndTime=").append(compactEndTime);
        sb.append(", investmentApprover=").append(investmentApprover);
        sb.append(", investmentApproverTime=").append(investmentApproverTime);
        sb.append(", propertyApprover=").append(propertyApprover);
        sb.append(", propertyApproverTime=").append(propertyApproverTime);
        sb.append(", pmApprover=").append(pmApprover);
        sb.append(", pmApproverTime=").append(pmApproverTime);
        sb.append(", companyName=").append(companyName);
        sb.append(", companyId=").append(companyId);
        sb.append(", rentInfo=").append(rentInfo);
        sb.append(", expectEnterTime=").append(expectEnterTime);
        sb.append(", sureTime=").append(sureTime);
        sb.append(", approvalOpioion=").append(approvalOpioion);
        sb.append(", legalPersoner=").append(legalPersoner);
        sb.append(", legalPhone=").append(legalPhone);
        sb.append(", comAdmin=").append(comAdmin);
        sb.append(", linker=").append(linker);
        sb.append(", linkerPhone=").append(linkerPhone);
        sb.append(", enterpriseProperty=").append(enterpriseProperty);
        sb.append(", industryTypeName=").append(industryTypeName);
        sb.append(", industryType=").append(industryType);
        sb.append(", rentStartTime=").append(rentStartTime);
        sb.append(", comEntTime=").append(comEntTime);
        sb.append(", rentMonthNum=").append(rentMonthNum);
        sb.append(", remerk=").append(remerk);
        sb.append(", actualTotalAccount=").append(actualTotalAccount);
        sb.append(", roomBillId=").append(roomBillId);
        sb.append(", enterTime=").append(enterTime);
        sb.append(", mainTowerId=").append(mainTowerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}