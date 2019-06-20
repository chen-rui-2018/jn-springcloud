package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/26 17:03
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "OrgColleagueInfo", description = "机构同事列表展示")
public class OrgColleagueInfo implements Serializable {
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "联系手机")
    private String phone;
    @ApiModelProperty(value = "联系邮箱")
    private String email;
    @ApiModelProperty(value = "毕业学校")
    private String graduatedSchool;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "担任职务")
    private String position;
    @ApiModelProperty(value = "机构身份")
    private String orgIdentity;
    @ApiModelProperty(value = "入驻日期")
    private String entryDate;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "从业年限")
    private String workingYears;
    @ApiModelProperty(value = "操作--设为联系人(true:显示设为联系人，false:不显示设为联系人)")
    private boolean  setContact=false;
    @ApiModelProperty(value = "操作--取消联系人(true:显示取消联系人，false:不显示设为联系人)")
    private boolean  cancelContact=false;
    @ApiModelProperty(value = "操作--删除(true:显示删除，false:不显示删除)")
    private boolean  delOrgAdvisor=false;
    @ApiModelProperty(value = "操作--详情(true:显示详情，false:不显示详情)")
    private boolean  orgDetail=false;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrgIdentity() {
        return orgIdentity;
    }

    public void setOrgIdentity(String orgIdentity) {
        this.orgIdentity = orgIdentity;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(String workingYears) {
        this.workingYears = workingYears;
    }

    public boolean isSetContact() {
        return setContact;
    }

    public void setSetContact(boolean setContact) {
        this.setContact = setContact;
    }

    public boolean isCancelContact() {
        return cancelContact;
    }

    public void setCancelContact(boolean cancelContact) {
        this.cancelContact = cancelContact;
    }

    public boolean isDelOrgAdvisor() {
        return delOrgAdvisor;
    }

    public void setDelOrgAdvisor(boolean delOrgAdvisor) {
        this.delOrgAdvisor = delOrgAdvisor;
    }

    public boolean isOrgDetail() {
        return orgDetail;
    }

    public void setOrgDetail(boolean orgDetail) {
        this.orgDetail = orgDetail;
    }

    @Override
    public String toString() {
        return "OrgColleagueInfo{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", education='" + education + '\'' +
                ", position='" + position + '\'' +
                ", orgIdentity='" + orgIdentity + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", avatar='" + avatar + '\'' +
                ", workingYears='" + workingYears + '\'' +
                ", setContact=" + setContact +
                ", cancelContact=" + cancelContact +
                ", delOrgAdvisor=" + delOrgAdvisor +
                ", orgDetail=" + orgDetail +
                '}';
    }
}
