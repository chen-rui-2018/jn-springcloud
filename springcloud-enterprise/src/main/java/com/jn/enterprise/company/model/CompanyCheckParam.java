package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;

/**
 * 升级企业入参Bean
 * @author： jiangyl
 * @date： Created on 2019/3/5 10:40
 * @version： v1.0
 * @modified By: huxw
 */
@ApiModel(value = "CompanyCheckParam",description = "升级企业入参")
public class CompanyCheckParam implements Serializable {
    @ApiModelProperty(value = "企业ID", hidden = true)
    private String id;
    @NotNull(message = "企业名称不能为空")
    @ApiModelProperty(value = "企业名称", required = true, example = "南京白下园区")
    private String comName;
    @NotNull(message = "企业简称不能为空")
    @ApiModelProperty(value = "企业简称", required = true, example = "白下")
    private String comNameShort;
    @NotNull(message = "企业领域不能为空")
    @ApiModelProperty(value = "企业领域[产业领域、所属行业][传机构字典接口入参preType=1返回的ID]", required = true, notes = "传机构字典接口入参preType=1返回的ID", example = "cloud_computing")
    private String induType;
    @NotNull(message = "企业法人不能为空")
    @ApiModelProperty(value = "企业法人", required = true, example = "李薇薇")
    private String ownerLaw;
    @ApiModelProperty(value = "法人联系方式", required = true, example = "123456789")
    @NotNull(message = "法人联系方式不能为空")
    private String ownerPhone;
    @NotNull(message = "注册时间不能为空")
    @Pattern(regexp = "^[12]\\d{3}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[1-2]\\d|3[01])$", message = "注册时间校验失败")
    @ApiModelProperty(value = "注册时间yyyy-MM-dd", required = true, example = "2018-01-01")
    private String foundingTime;
    @NotNull(message = "落地时间不能为空")
    @Pattern(regexp = "^[12]\\d{3}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[1-2]\\d|3[01])$", message = "落地时间校验失败")
    @ApiModelProperty(value = "落地时间yyyy-MM-dd", required = true, example = "2018-01-01")
    private String runTime;
    @NotNull(message = "公司注册地址不能为空")
    @ApiModelProperty(value = "公司注册地址", required = true, example = "南京白下区")
    private String comAddress;
    @NotNull(message = "实际经营地址不能为空")
    @ApiModelProperty(value = "实际经营地址（园区地址）",required = true,example = "南京白下区")
    private String addrPark;
    @ApiModelProperty(value = "固定电话", example = "010-111111")
    private String comTele;
    @NotNull(message = "注册资金不能为空")
    @Pattern(regexp = "^\\d+.?\\d*$", message = "注册资金校验失败")
    @ApiModelProperty(value = "注册资金（万元）", required = true, example = "500")
    private String regCapital;
    @NotNull(message = "企业规模不能为空")
    @ApiModelProperty(value = "企业规模", required = true, example = "100-200人")
    private String comScale;
    @NotNull(message = "统一社会信用代码不能为空")
    @ApiModelProperty(value = "统一社会信用代码", required = true, example = "1000")
    private String unifyCode;
    @NotNull(message = "企业性质不能为空")
    @ApiModelProperty(value = "企业性质[传机构字典接口入参preType=3返回的ID]", required = true,notes = "传机构字典接口入参preType=3返回的ID", example = "joint_enterprise")
    private String comProperty;
    @NotNull(message = "企业来源不能为空")
    @Pattern(regexp = "^[12]$", message = "企业来源校验错误")
    @ApiModelProperty(value = "企业来源 [1人才企业2招商企业]",notes = "1人才企业2招商企业", required = true, example = "1")
    private String comSource;
    @NotNull(message = "企业logo不能为空")
    @ApiModelProperty(value = "企业logo", required = true, example = "http://xxxx.png")
    private String avatar;
    @NotNull(message = "三证一体或营业执照照片不能为空")
    @ApiModelProperty(value = "三证一体或营业执照照片", required = true, example = "http://xxxx.png")
    private String businessLicense;
    @NotNull(message = "验证码不能为空")
    @Pattern(regexp = "^\\d{6}$", message = "验证码校验失败，请输入6位验证码")
    @ApiModelProperty(value = "验证码", required = true, example = "123456")
    private String checkCode;
    @ApiModelProperty(value = "企业官网地址", example = "http://www.baidu.com")
    private String comWeb;
    @ApiModelProperty(value = "我的服务", example = "我的服务")
    private String comServer;
    @ApiModelProperty(value = "我的需求", example = "我的需求")
    private String comDemand;
    @ApiModelProperty(value = "所属园区[园区ID]", example = "846841")
    private String affiliatedPark;

    @ApiModelProperty(value = "信用分", hidden = true)
    private String creditPoints;
    @ApiModelProperty(value = "信用分更新时间", hidden = true)
    private String creditUpdateTime;
    @ApiModelProperty(value = "企业管理员", hidden = true)
    private String comAdmin;
    @ApiModelProperty(value = "是否删除", hidden = true)
    private String recordStatus;
    @ApiModelProperty(value = "审批状态", hidden = true)
    private String checkStatus;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private String createdTime;
    @ApiModelProperty(value = "创建者账号", hidden = true)
    private String creatorAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComNameShort() {
        return comNameShort;
    }

    public void setComNameShort(String comNameShort) {
        this.comNameShort = comNameShort;
    }

    public String getInduType() {
        return induType;
    }

    public void setInduType(String induType) {
        this.induType = induType;
    }

    public String getOwnerLaw() {
        return ownerLaw;
    }

    public void setOwnerLaw(String ownerLaw) {
        this.ownerLaw = ownerLaw;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(String foundingTime) {
        this.foundingTime = foundingTime;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark;
    }

    public String getComTele() {
        return comTele;
    }

    public void setComTele(String comTele) {
        this.comTele = comTele;
    }

    public String getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(String regCapital) {
        this.regCapital = regCapital;
    }

    public String getComScale() {
        return comScale;
    }

    public void setComScale(String comScale) {
        this.comScale = comScale;
    }

    public String getUnifyCode() {
        return unifyCode;
    }

    public void setUnifyCode(String unifyCode) {
        this.unifyCode = unifyCode;
    }

    public String getComProperty() {
        return comProperty;
    }

    public void setComProperty(String comProperty) {
        this.comProperty = comProperty;
    }

    public String getComSource() {
        return comSource;
    }

    public void setComSource(String comSource) {
        this.comSource = comSource;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getComWeb() {
        return comWeb;
    }

    public void setComWeb(String comWeb) {
        this.comWeb = comWeb;
    }

    public String getComServer() {
        return comServer;
    }

    public void setComServer(String comServer) {
        this.comServer = comServer;
    }

    public String getComDemand() {
        return comDemand;
    }

    public void setComDemand(String comDemand) {
        this.comDemand = comDemand;
    }

    public String getAffiliatedPark() {
        return affiliatedPark;
    }

    public void setAffiliatedPark(String affiliatedPark) {
        this.affiliatedPark = affiliatedPark;
    }

    public String getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(String creditPoints) {
        this.creditPoints = creditPoints;
    }

    public String getCreditUpdateTime() {
        return creditUpdateTime;
    }

    public void setCreditUpdateTime(String creditUpdateTime) {
        this.creditUpdateTime = creditUpdateTime;
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
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

    @Override
    public String toString() {
        return "CompanyCheckParam{" +
                "id='" + id + '\'' +
                ", comName='" + comName + '\'' +
                ", comNameShort='" + comNameShort + '\'' +
                ", induType='" + induType + '\'' +
                ", ownerLaw='" + ownerLaw + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", foundingTime='" + foundingTime + '\'' +
                ", runTime='" + runTime + '\'' +
                ", comAddress='" + comAddress + '\'' +
                ", addrPark='" + addrPark + '\'' +
                ", comTele='" + comTele + '\'' +
                ", regCapital='" + regCapital + '\'' +
                ", comScale='" + comScale + '\'' +
                ", unifyCode='" + unifyCode + '\'' +
                ", comProperty='" + comProperty + '\'' +
                ", comSource='" + comSource + '\'' +
                ", avatar='" + avatar + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", comWeb='" + comWeb + '\'' +
                ", comServer='" + comServer + '\'' +
                ", comDemand='" + comDemand + '\'' +
                ", affiliatedPark='" + affiliatedPark + '\'' +
                ", creditPoints='" + creditPoints + '\'' +
                ", creditUpdateTime='" + creditUpdateTime + '\'' +
                ", comAdmin='" + comAdmin + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                '}';
    }
}
