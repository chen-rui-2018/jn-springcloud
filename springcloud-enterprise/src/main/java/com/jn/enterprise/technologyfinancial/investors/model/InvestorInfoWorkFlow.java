package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/5/9 9:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorInfoWorkFlow", description = "科技金融投资人认证ibps工作流入参")
public class InvestorInfoWorkFlow implements Serializable {
    @ApiModelProperty(value = "投资人编码")
    private String investorCode;
    @ApiModelProperty(value = "投资人账号")
    private String investorAccount;
    @ApiModelProperty(value = "投资人姓名")
    private String investorName;
    @ApiModelProperty(value = "投资人头像")
    private String avatar;
    @ApiModelProperty(value = "投资人性别(0:女  1：男)")
    private String sex;
    @ApiModelProperty(value = "投资人所属机构id")
    private String orgId;
    @ApiModelProperty(value = "投资人所属机构名称")
    private String orgName;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "常住地（省份）")
    private String addressProvince;
    @ApiModelProperty(value = "常住地（城市）")
    private String addressCity;
    @ApiModelProperty(value = "常住地（区域）")
    private String addressArea;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "个人简介")
    private String personalProfile;
    @ApiModelProperty(value = "投融资经历")
    private String invesFinanExper;
    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "审批状态")
    private String approvalStatus;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private String modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "是否删除 0：已删除  1：有效")
    private byte recordStatus;
    @ApiModelProperty(value = "主投领域")
    private List<InvestorMainAreaWorkFlow>tb_service_investor_main_area;
    @ApiModelProperty(value = "主投轮次")
    private List<InvestorMainRoundWorkFlow>tb_service_investor_main_round;
    @ApiModelProperty(value = "工作经历")
    private List<InvestorWorkExperienceWorkFlow> tb_service_investor_work_exp;
    @ApiModelProperty(value = "教育经历")
    private List<InvestorEducationExperienceWorkFlow> tb_service_investor_edu_exp;

    public String getInvestorCode() {
        return investorCode;
    }

    public void setInvestorCode(String investorCode) {
        this.investorCode = investorCode;
    }

    public String getInvestorAccount() {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount) {
        this.investorAccount = investorAccount;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getInvesFinanExper() {
        return invesFinanExper;
    }

    public void setInvesFinanExper(String invesFinanExper) {
        this.invesFinanExper = invesFinanExper;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    public byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public List<InvestorMainAreaWorkFlow> getTb_service_investor_main_area() {
        return tb_service_investor_main_area;
    }

    public void setTb_service_investor_main_area(List<InvestorMainAreaWorkFlow> tb_service_investor_main_area) {
        this.tb_service_investor_main_area = tb_service_investor_main_area;
    }

    public List<InvestorMainRoundWorkFlow> getTb_service_investor_main_round() {
        return tb_service_investor_main_round;
    }

    public void setTb_service_investor_main_round(List<InvestorMainRoundWorkFlow> tb_service_investor_main_round) {
        this.tb_service_investor_main_round = tb_service_investor_main_round;
    }

    public List<InvestorWorkExperienceWorkFlow> getTb_service_investor_work_exp() {
        return tb_service_investor_work_exp;
    }

    public void setTb_service_investor_work_exp(List<InvestorWorkExperienceWorkFlow> tb_service_investor_work_exp) {
        this.tb_service_investor_work_exp = tb_service_investor_work_exp;
    }

    public List<InvestorEducationExperienceWorkFlow> getTb_service_investor_edu_exp() {
        return tb_service_investor_edu_exp;
    }

    public void setTb_service_investor_edu_exp(List<InvestorEducationExperienceWorkFlow> tb_service_investor_edu_exp) {
        this.tb_service_investor_edu_exp = tb_service_investor_edu_exp;
    }

    @Override
    public String toString() {
        return "InvestorInfoWorkFlow{" +
                "investorCode='" + investorCode + '\'' +
                ", investorAccount='" + investorAccount + '\'' +
                ", investorName='" + investorName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", sex='" + sex + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", position='" + position + '\'' +
                ", addressProvince='" + addressProvince + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressArea='" + addressArea + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                ", invesFinanExper='" + invesFinanExper + '\'' +
                ", status='" + status + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus=" + recordStatus +
                ", tb_service_investor_main_area=" + tb_service_investor_main_area +
                ", tb_service_investor_main_round=" + tb_service_investor_main_round +
                ", tb_service_investor_work_exp=" + tb_service_investor_work_exp +
                ", tb_service_investor_edu_exp=" + tb_service_investor_edu_exp +
                '}';
    }
}
