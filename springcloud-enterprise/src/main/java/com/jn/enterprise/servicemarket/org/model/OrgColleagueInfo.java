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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    @Override
    public String toString() {
        return "OrgColleagueInfo{" +
                "account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", education='" + education + '\'' +
                ", position='" + position + '\'' +
                ", orgIdentity='" + orgIdentity + '\'' +
                ", entryDate='" + entryDate + '\'' +
                '}';
    }
}
