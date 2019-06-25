package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class TbServiceOrgCopy implements Serializable {
    @ApiModelProperty(value = "机构id")
    private String orgId;
    @ApiModelProperty(value = "原有机构id(修改时，旧数据的机构id)")
    private String originalId;
    @ApiModelProperty(value = "机构账号")
    private String orgAccount;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "注册时间")
    private String orgRegisterTime;
    @ApiModelProperty(value = "统一社会信用代码")
    private String orgCode;
    @ApiModelProperty(value = "经营状态")
    private String operateStatus;
    @ApiModelProperty(value = "法人")
    private String orgPrincipal;
    @ApiModelProperty(value = "企业工商类型")
    private String orgBusinType;
    @ApiModelProperty(value = "企业工商经营场所")
    private String orgBusinAddress;
    @ApiModelProperty(value = "企业工商经营范围")
    private String orgBusinScope;
    @ApiModelProperty(value = "是否认证")
    private String isApprove;
    @ApiModelProperty(value = "服务商简介")
    private String orgSynopsis;
    @ApiModelProperty(value = "主营业务")
    private String orgBusiness;
    @ApiModelProperty(value = "业务擅长")
    private String orgSpeciality;
    @ApiModelProperty(value = "机构logo")
    private String orgLogo;
    @ApiModelProperty(value = "浏览量")
    private Integer orgShow;
    @ApiModelProperty(value = "机构类型")
    private String orgType;
    @ApiModelProperty(value = "客户偏好")
    private String orgHobby;
    @ApiModelProperty(value = "审批状态")
    private String orgStatus;
    @ApiModelProperty(value = "审批时间")
    private String checkTime;
    @ApiModelProperty(value = "一级业务领域")
    private String businessType;
    @ApiModelProperty(value = "二级业务领域")
    private String businessSType;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private String modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "是否删除")
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


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getOrgAccount() {
        return orgAccount;
    }

    public void setOrgAccount(String orgAccount) {
        this.orgAccount = orgAccount;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
        this.orgCode = orgCode;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getOrgPrincipal() {
        return orgPrincipal;
    }

    public void setOrgPrincipal(String orgPrincipal) {
        this.orgPrincipal = orgPrincipal;
    }

    public String getOrgBusinType() {
        return orgBusinType;
    }

    public void setOrgBusinType(String orgBusinType) {
        this.orgBusinType = orgBusinType;
    }

    public String getOrgBusinAddress() {
        return orgBusinAddress;
    }

    public void setOrgBusinAddress(String orgBusinAddress) {
        this.orgBusinAddress = orgBusinAddress;
    }

    public String getOrgBusinScope() {
        return orgBusinScope;
    }

    public void setOrgBusinScope(String orgBusinScope) {
        this.orgBusinScope = orgBusinScope;
    }

    public String getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(String isApprove) {
        this.isApprove = isApprove;
    }

    public String getOrgSynopsis() {
        return orgSynopsis;
    }

    public void setOrgSynopsis(String orgSynopsis) {
        this.orgSynopsis = orgSynopsis;
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness;
    }

    public String getOrgSpeciality() {
        return orgSpeciality;
    }

    public void setOrgSpeciality(String orgSpeciality) {
        this.orgSpeciality = orgSpeciality;
    }

    public String getOrgLogo() {
        return orgLogo;
    }

    public void setOrgLogo(String orgLogo) {
        this.orgLogo = orgLogo;
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
        this.orgType = orgType;
    }

    public String getOrgHobby() {
        return orgHobby;
    }

    public void setOrgHobby(String orgHobby) {
        this.orgHobby = orgHobby;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
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
        this.businessType = businessType;
    }

    public String getBusinessSType() {
        return businessSType;
    }

    public void setBusinessSType(String businessSType) {
        this.businessSType = businessSType;
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
        this.creatorAccount = creatorAccount;
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
        this.modifierAccount = modifierAccount;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

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

    @Override
    public String toString() {
        return "TbServiceOrgCopy{" +
                "orgId='" + orgId + '\'' +
                ", originalId='" + originalId + '\'' +
                ", orgAccount='" + orgAccount + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgRegisterTime='" + orgRegisterTime + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", operateStatus='" + operateStatus + '\'' +
                ", orgPrincipal='" + orgPrincipal + '\'' +
                ", orgBusinType='" + orgBusinType + '\'' +
                ", orgBusinAddress='" + orgBusinAddress + '\'' +
                ", orgBusinScope='" + orgBusinScope + '\'' +
                ", isApprove='" + isApprove + '\'' +
                ", orgSynopsis='" + orgSynopsis + '\'' +
                ", orgBusiness='" + orgBusiness + '\'' +
                ", orgSpeciality='" + orgSpeciality + '\'' +
                ", orgLogo='" + orgLogo + '\'' +
                ", orgShow=" + orgShow +
                ", orgType='" + orgType + '\'' +
                ", orgHobby='" + orgHobby + '\'' +
                ", orgStatus='" + orgStatus + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessSType='" + businessSType + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", tb_service_org_element=" + tb_service_org_element +
                ", tb_service_org_info=" + tb_service_org_info +
                ", tb_service_org_license=" + tb_service_org_license +
                ", tb_service_org_team=" + tb_service_org_team +
                ", tb_service_org_trait=" + tb_service_org_trait +
                '}';
    }
}