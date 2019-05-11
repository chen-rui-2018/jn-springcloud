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
    @ApiModelProperty(value = "投资人姓名",required = true,example = "wangsong")
    @NotNull(message = "投资人姓名不能为空")
    private String investorName;
    @ApiModelProperty(value = "头像url",required = true,example = "xxx/avg.jpg")
    @NotNull(message = "头像url不能为空")
    private String avatar;
    @ApiModelProperty(value = "性别（0:女  1:男）",required = true,example = "1")
    @NotNull(message = "性别不能为空")
    @Pattern(regexp="^[01]$",message="{sex:'默认值值只允许为0,1'}")
    private String sex;
    @ApiModelProperty(value = "所属单位id",example = "123234")
    private String orgId;
    @ApiModelProperty(value = "所属单位名称",example = "xxx单位")
    private String orgName;
    @ApiModelProperty(value = "职务",required = true,example = "xxx职位")
    @NotNull(message = "职务不能为空")
    private String position;
    @ApiModelProperty(value = "常住地省份",required = true,example = "xxx省")
    @NotNull(message = "常住地省份不能为空")
    private String addressProvince;
    @ApiModelProperty(value = "常住地城市",required = true,example = "xxx市")
    @NotNull(message = "常住地城市不能为空")
    private String addressCity;
    @ApiModelProperty(value = "常住地区域",required = true,example = "xxx区")
    @NotNull(message = "常住地区域不能为空")
    private String addressArea;
    @ApiModelProperty(value = "手机号码",required = true,example = "18088888888")
    @NotNull(message = "手机号码不能为空")
    private String phone;
    @ApiModelProperty(value = "邮箱",required = true,example = "123@qq.com")
    @NotNull(message = "邮箱不能为空")
    private String email;
    @ApiModelProperty(value = "个人简介",required = true,example = "个人简介....")
    @NotNull(message = "个人简介不能为空")
    @Size(max=512,message = "个人简介不能超过512个字")
    private String personalProfile;
    @ApiModelProperty(value = "投融资经历",required = true,example = "融资经历....")
    @NotNull(message = "投融资经历不能为空")
    @Size(max=500,message = "投融资经历不能超过500个字")
    private String invesFinanExper;
    @ApiModelProperty(value = "主投领域",required = true)
    @NotNull(message = "主投领域不能为空")
    private List<InvestorMainArea>investorMainAreaList;
    @ApiModelProperty(value = "主投轮次",required = true)
    @NotNull(message = "主投轮次不能为空")
    private List<InvestorMainRound>investorMainRoundList;
    @ApiModelProperty(value = "工作经历")
    private List<InvestorWorkExperienceParam> investorWorkExperienceParamList;
    @ApiModelProperty(value = "教育经历")
    private List<InvestorEducationExperienceParam> investorEducationExperienceParamList;

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

    public List<InvestorWorkExperienceParam> getInvestorWorkExperienceParamList() {
        return investorWorkExperienceParamList;
    }

    public void setInvestorWorkExperienceParamList(List<InvestorWorkExperienceParam> investorWorkExperienceParamList) {
        this.investorWorkExperienceParamList = investorWorkExperienceParamList;
    }

    public List<InvestorEducationExperienceParam> getInvestorEducationExperienceParamList() {
        return investorEducationExperienceParamList;
    }

    public void setInvestorEducationExperienceParamList(List<InvestorEducationExperienceParam> investorEducationExperienceParamList) {
        this.investorEducationExperienceParamList = investorEducationExperienceParamList;
    }
}
