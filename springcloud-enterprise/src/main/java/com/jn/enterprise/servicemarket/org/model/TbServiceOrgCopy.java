package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class TbServiceOrgCopy implements Serializable {
    private String orgId;

    private String orgAccount;

    private String orgName;

    private String orgRegisterTime;

    private String orgCode;

    private String operateStatus;

    private String orgPrincipal;

    private String orgBusinType;

    private String orgBusinAddress;

    private String orgBusinScope;

    private String isApprove;

    private String orgSynopsis;

    private String orgBusiness;

    private String orgSpeciality;

    private String orgLogo;

    private Integer orgShow;

    private String orgType;

    private String orgHobby;

    private String orgStatus;

    private String checkTime;

    private String businessType;

    private String businessSType;

    private String createdTime;

    private String creatorAccount;

    private String modifiedTime;

    private String modifierAccount;

    private String recordStatus;

    @ApiModelProperty(value = "服务机构团队人员结构")
    TbServiceOrgElementCopy tb_service_org_element;

    @ApiModelProperty(value = "服务机构地址信息")
    TbServiceOrgInfoCopy tb_service_org_info;

    @ApiModelProperty(value = "服务机构资质")
    List<TbServiceOrgLicenseCopy> tb_service_org_license;

    @ApiModelProperty(value = "服务机构团队信息")
    List<TbServiceOrgTeamCopy> tb_service_org_team;

    @ApiModelProperty(value = "服务机构特性")
    List<TbServiceOrgTraitCopy> tb_service_org_trait;


    public TbServiceOrgElementCopy getTb_service_org_element() {
        return tb_service_org_element;
    }

    public void setTb_service_org_element(TbServiceOrgElementCopy tb_service_org_element) {
        this.tb_service_org_element = tb_service_org_element;
    }

    public TbServiceOrgInfoCopy getTb_service_org_info() {
        return tb_service_org_info;
    }

    public void setTb_service_org_info(TbServiceOrgInfoCopy tb_service_org_info) {
        this.tb_service_org_info = tb_service_org_info;
    }

    public List<TbServiceOrgLicenseCopy> getTb_service_org_license() {
        return tb_service_org_license;
    }

    public void setTb_service_org_license(List<TbServiceOrgLicenseCopy> tb_service_org_license) {
        this.tb_service_org_license = tb_service_org_license;
    }

    public List<TbServiceOrgTeamCopy> getTb_service_org_team() {
        return tb_service_org_team;
    }

    public void setTb_service_org_team(List<TbServiceOrgTeamCopy> tb_service_org_team) {
        this.tb_service_org_team = tb_service_org_team;
    }

    public List<TbServiceOrgTraitCopy> getTb_service_org_trait() {
        return tb_service_org_trait;
    }

    public void setTb_service_org_trait(List<TbServiceOrgTraitCopy> tb_service_org_trait) {
        this.tb_service_org_trait = tb_service_org_trait;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }




    private static final long serialVersionUID = 1L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgAccount() {
        return orgAccount;
    }

    public void setOrgAccount(String orgAccount) {
        this.orgAccount = orgAccount == null ? null : orgAccount.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgRegisterTime() {
        return orgRegisterTime;
    }

    public void setOrgRegisterTime(String orgRegisterTime) {
        this.orgRegisterTime = orgRegisterTime;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus == null ? null : operateStatus.trim();
    }

    public String getOrgPrincipal() {
        return orgPrincipal;
    }

    public void setOrgPrincipal(String orgPrincipal) {
        this.orgPrincipal = orgPrincipal == null ? null : orgPrincipal.trim();
    }

    public String getOrgBusinType() {
        return orgBusinType;
    }

    public void setOrgBusinType(String orgBusinType) {
        this.orgBusinType = orgBusinType == null ? null : orgBusinType.trim();
    }

    public String getOrgBusinAddress() {
        return orgBusinAddress;
    }

    public void setOrgBusinAddress(String orgBusinAddress) {
        this.orgBusinAddress = orgBusinAddress == null ? null : orgBusinAddress.trim();
    }

    public String getOrgBusinScope() {
        return orgBusinScope;
    }

    public void setOrgBusinScope(String orgBusinScope) {
        this.orgBusinScope = orgBusinScope == null ? null : orgBusinScope.trim();
    }

    public String getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(String isApprove) {
        this.isApprove = isApprove == null ? null : isApprove.trim();
    }

    public String getOrgSynopsis() {
        return orgSynopsis;
    }

    public void setOrgSynopsis(String orgSynopsis) {
        this.orgSynopsis = orgSynopsis == null ? null : orgSynopsis.trim();
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness == null ? null : orgBusiness.trim();
    }

    public String getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String orgSpeciality) {
        this.orgSpeciality = orgSpeciality == null ? null : orgSpeciality.trim();
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo == null ? null : orgLogo.trim();
    }

    public Integer getOrgShow() {
        return orgShow;
    }

    public void setOrgShow(Integer orgShow) {
        this.orgShow = orgShow;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    public String getOrgHobby() {
        return orgHobby;
    }

    public void setOrgHobby(String orgHobby) {
        this.orgHobby = orgHobby == null ? null : orgHobby.trim();
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus == null ? null : orgStatus.trim();
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getBusinessSType() {
        return businessSType;
    }

    public void setBusinessSType(String businessSType) {
        this.businessSType = businessSType == null ? null : businessSType.trim();
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
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
        TbServiceOrgCopy other = (TbServiceOrgCopy) that;
        return (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
            && (this.getOrgAccount() == null ? other.getOrgAccount() == null : this.getOrgAccount().equals(other.getOrgAccount()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOrgRegisterTime() == null ? other.getOrgRegisterTime() == null : this.getOrgRegisterTime().equals(other.getOrgRegisterTime()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getOperateStatus() == null ? other.getOperateStatus() == null : this.getOperateStatus().equals(other.getOperateStatus()))
            && (this.getOrgPrincipal() == null ? other.getOrgPrincipal() == null : this.getOrgPrincipal().equals(other.getOrgPrincipal()))
            && (this.getOrgBusinType() == null ? other.getOrgBusinType() == null : this.getOrgBusinType().equals(other.getOrgBusinType()))
            && (this.getOrgBusinAddress() == null ? other.getOrgBusinAddress() == null : this.getOrgBusinAddress().equals(other.getOrgBusinAddress()))
            && (this.getOrgBusinScope() == null ? other.getOrgBusinScope() == null : this.getOrgBusinScope().equals(other.getOrgBusinScope()))
            && (this.getIsApprove() == null ? other.getIsApprove() == null : this.getIsApprove().equals(other.getIsApprove()))
            && (this.getOrgSynopsis() == null ? other.getOrgSynopsis() == null : this.getOrgSynopsis().equals(other.getOrgSynopsis()))
            && (this.getOrgBusiness() == null ? other.getOrgBusiness() == null : this.getOrgBusiness().equals(other.getOrgBusiness()))
            && (this.getOrgSpeciality() == null ? other.getOrgSpeciality() == null : this.getOrgSpeciality().equals(other.getOrgSpeciality()))
            && (this.getOrgLogo() == null ? other.getOrgLogo() == null : this.getOrgLogo().equals(other.getOrgLogo()))
            && (this.getOrgShow() == null ? other.getOrgShow() == null : this.getOrgShow().equals(other.getOrgShow()))
            && (this.getOrgType() == null ? other.getOrgType() == null : this.getOrgType().equals(other.getOrgType()))
            && (this.getOrgHobby() == null ? other.getOrgHobby() == null : this.getOrgHobby().equals(other.getOrgHobby()))
            && (this.getOrgStatus() == null ? other.getOrgStatus() == null : this.getOrgStatus().equals(other.getOrgStatus()))
            && (this.getCheckTime() == null ? other.getCheckTime() == null : this.getCheckTime().equals(other.getCheckTime()))
            && (this.getBusinessType() == null ? other.getBusinessType() == null : this.getBusinessType().equals(other.getBusinessType()))
            && (this.getBusinessSType() == null ? other.getBusinessSType() == null : this.getBusinessSType().equals(other.getBusinessSType()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgAccount() == null) ? 0 : getOrgAccount().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOrgRegisterTime() == null) ? 0 : getOrgRegisterTime().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getOperateStatus() == null) ? 0 : getOperateStatus().hashCode());
        result = prime * result + ((getOrgPrincipal() == null) ? 0 : getOrgPrincipal().hashCode());
        result = prime * result + ((getOrgBusinType() == null) ? 0 : getOrgBusinType().hashCode());
        result = prime * result + ((getOrgBusinAddress() == null) ? 0 : getOrgBusinAddress().hashCode());
        result = prime * result + ((getOrgBusinScope() == null) ? 0 : getOrgBusinScope().hashCode());
        result = prime * result + ((getIsApprove() == null) ? 0 : getIsApprove().hashCode());
        result = prime * result + ((getOrgSynopsis() == null) ? 0 : getOrgSynopsis().hashCode());
        result = prime * result + ((getOrgBusiness() == null) ? 0 : getOrgBusiness().hashCode());
        result = prime * result + ((getOrgSpeciality() == null) ? 0 : getOrgSpeciality().hashCode());
        result = prime * result + ((getOrgLogo() == null) ? 0 : getOrgLogo().hashCode());
        result = prime * result + ((getOrgShow() == null) ? 0 : getOrgShow().hashCode());
        result = prime * result + ((getOrgType() == null) ? 0 : getOrgType().hashCode());
        result = prime * result + ((getOrgHobby() == null) ? 0 : getOrgHobby().hashCode());
        result = prime * result + ((getOrgStatus() == null) ? 0 : getOrgStatus().hashCode());
        result = prime * result + ((getCheckTime() == null) ? 0 : getCheckTime().hashCode());
        result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
        result = prime * result + ((getBusinessSType() == null) ? 0 : getBusinessSType().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgId=").append(orgId);
        sb.append(", orgAccount=").append(orgAccount);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgRegisterTime=").append(orgRegisterTime);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", operateStatus=").append(operateStatus);
        sb.append(", orgPrincipal=").append(orgPrincipal);
        sb.append(", orgBusinType=").append(orgBusinType);
        sb.append(", orgBusinAddress=").append(orgBusinAddress);
        sb.append(", orgBusinScope=").append(orgBusinScope);
        sb.append(", isApprove=").append(isApprove);
        sb.append(", orgSynopsis=").append(orgSynopsis);
        sb.append(", orgBusiness=").append(orgBusiness);
        sb.append(", orgSpeciality=").append(orgSpeciality);
        sb.append(", orgLogo=").append(orgLogo);
        sb.append(", orgShow=").append(orgShow);
        sb.append(", orgType=").append(orgType);
        sb.append(", orgHobby=").append(orgHobby);
        sb.append(", orgStatus=").append(orgStatus);
        sb.append(", checkTime=").append(checkTime);
        sb.append(", businessType=").append(businessType);
        sb.append(", businessSType=").append(businessSType);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}