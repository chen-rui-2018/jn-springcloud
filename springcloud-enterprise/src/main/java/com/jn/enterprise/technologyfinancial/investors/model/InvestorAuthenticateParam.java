package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/15 10:08
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorAuthenticateParam", description = "科技金融投资人认证入参")
public class InvestorAuthenticateParam implements Serializable {
    @ApiModelProperty(value = "投资人姓名")
    @NotNull(message = "投资人姓名不能为空")
    private String investorName;
    @ApiModelProperty(value = "头像url")
    @NotNull(message = "头像url不能为空")
    private String avatar;
    @ApiModelProperty(value = "性别（0:女  1:男）")
    @NotNull(message = "性别不能为空")
    @Pattern(regexp="^[01]$",message="{sex:'默认值值只允许为0,1'}")
    private String sex;
    @ApiModelProperty(value = "所属单位id")
    private String orgId;
    @ApiModelProperty(value = "所属单位名称")
    private String orgName;
    @ApiModelProperty(value = "职务")
    @NotNull(message = "职务不能为空")
    private String position;
    @ApiModelProperty(value = "常住地省份")
    @NotNull(message = "常住地省份不能为空")
    private String addressProvince;
    @ApiModelProperty(value = "常住地城市")
    @NotNull(message = "常住地城市不能为空")
    private String addressCity;
    @ApiModelProperty(value = "常住地区域")
    @NotNull(message = "常住地区域不能为空")
    private String addressArea;
    @ApiModelProperty(value = "手机号码")
    @NotNull(message = "手机号码不能为空")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    @NotNull(message = "邮箱不能为空")
    private String email;
    @ApiModelProperty(value = "个人简介")
    @NotNull(message = "个人简介不能为空")
    @Size(max=512,message = "个人简介不能超过512个字")
    private String personalProfile;
    @ApiModelProperty(value = "主投领域")
    @NotNull(message = "主投领域不能为空")
    private List<InvestorMainArea>investorMainAreaList;
    @ApiModelProperty(value = "主投轮次")
    @NotNull(message = "主投轮次不能为空")
    private List<InvestorMainRound>investorMainRoundList;
    @ApiModelProperty(value = "工作经历")
    private List<InvestorWorkExperience>investorWorkExperienceList;
    @ApiModelProperty(value = "教育经历")
    private List<InvestorEduExperience>investorEduExperienceList;

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

    public List<InvestorMainArea> getInvestorMainAreaList() {
        return investorMainAreaList;
    }

    public void setInvestorMainAreaList(List<InvestorMainArea> investorMainAreaList) {
        this.investorMainAreaList = investorMainAreaList;
    }

    public List<InvestorMainRound> getInvestorMainRoundList() {
        return investorMainRoundList;
    }

    public void setInvestorMainRoundList(List<InvestorMainRound> investorMainRoundList) {
        this.investorMainRoundList = investorMainRoundList;
    }

    public List<InvestorWorkExperience> getInvestorWorkExperienceList() {
        return investorWorkExperienceList;
    }

    public void setInvestorWorkExperienceList(List<InvestorWorkExperience> investorWorkExperienceList) {
        this.investorWorkExperienceList = investorWorkExperienceList;
    }

    public List<InvestorEduExperience> getInvestorEduExperienceList() {
        return investorEduExperienceList;
    }

    public void setInvestorEduExperienceList(List<InvestorEduExperience> investorEduExperienceList) {
        this.investorEduExperienceList = investorEduExperienceList;
    }
}
