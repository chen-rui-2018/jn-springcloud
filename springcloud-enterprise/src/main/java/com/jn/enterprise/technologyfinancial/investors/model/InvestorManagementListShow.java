package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/21 15:19
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorManagementListShow", description = "科技金融管理投资人管理列表展示出参")
public class InvestorManagementListShow implements Serializable {
    @ApiModelProperty(value = "投资人账号")
    private String investorAccount;
    @ApiModelProperty(value = "姓名")
    private String investorName;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "所属单位")
    private String orgName;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "常住地")
    private String permanentAddress;
    @ApiModelProperty(value = "手机号码")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "申请日期")
    private String applyTime;
    @ApiModelProperty(value = "状态")
    private String status;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
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

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InvestorManagementListShow{" +
                "investorAccount='" + investorAccount + '\'' +
                ", investorName='" + investorName + '\'' +
                ", sex='" + sex + '\'' +
                ", orgName='" + orgName + '\'' +
                ", position='" + position + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
