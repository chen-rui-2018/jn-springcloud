package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 企业实体
 * @author： shaobao
 * @date： Created on 2019/5/28 19:21
 * @version： v1.0
 * @modified By: huxw
 **/
@ApiModel(value = "ServiceCompany",description = "企业实体")
public class ServiceCompany implements Serializable {

    @ApiModelProperty(value = "企业ID")
    private String id;
    @ApiModelProperty(value = "企业名称")
    private String comName;
    @ApiModelProperty(value = "企业简称")
    private String comNameShort;
    @ApiModelProperty(value = "企业领域")
    private String induType;
    @ApiModelProperty(value = "企业法人")
    private String ownerLaw;
    @ApiModelProperty(value = "法人联系方式")
    private String ownerPhone;
    @ApiModelProperty(value = "注册时间yyyy-MM-dd")
    private String foundingTime;
    @ApiModelProperty(value = "落地时间yyyy-MM-dd")
    private String runTime;
    @ApiModelProperty(value = "公司注册地址")
    private String comAddress;
    @ApiModelProperty(value = "实际经营地址（园区地址）")
    private String addrPark;
    @ApiModelProperty(value = "固定电话")
    private String comTele;
    @ApiModelProperty(value = "注册资金（万元）")
    private String regCapital;
    @ApiModelProperty(value = "企业规模")
    private String comScale;
    @ApiModelProperty(value = "统一社会信用代码")
    private String unifyCode;
    @ApiModelProperty(value = "企业来源 [1人才企业 2招商企业]")
    private String comSource;
    @ApiModelProperty(value = "企业logo")
    private String avatar;
    @ApiModelProperty(value = "三证一体或营业执照照片")
    private String businessLicense;
    @ApiModelProperty(value = "企业官网地址")
    private String comWeb;
    @ApiModelProperty(value = "我的服务")
    private String comServer;
    @ApiModelProperty(value = "我的需求")
    private String comDemand;
    @ApiModelProperty(value = "所属园区[园区ID]")
    private String affiliatedPark;
    @ApiModelProperty(value = "企业性质")
    private String comProperty;
    @ApiModelProperty(value = "企业简介")
    private String comSynopsis;
    @ApiModelProperty(value = "企业宣传图")
    private String propagandaPicture;
    @ApiModelProperty(value = "企业宣传图")
    private String mainProducts;
    @ApiModelProperty(value = "信用分")
    private String creditPoints;
    @ApiModelProperty(value = "信用分更新时间")
    private String creditUpdateTime;
    @ApiModelProperty(value = "企业管理员")
    private String comAdmin;
    @ApiModelProperty(value = "是否删除")
    private String recordStatus;
    @ApiModelProperty(value = "审批状态")
    private String checkStatus;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;
    @ApiModelProperty(value = "企业ID")
    private String comId;

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

    public String getComProperty() {
        return comProperty;
    }

    public void setComProperty(String comProperty) {
        this.comProperty = comProperty;
    }

    public String getComSynopsis() {
        return comSynopsis;
    }

    public void setComSynopsis(String comSynopsis) {
        this.comSynopsis = comSynopsis;
    }

    public String getPropagandaPicture() {
        return propagandaPicture;
    }

    public void setPropagandaPicture(String propagandaPicture) {
        this.propagandaPicture = propagandaPicture;
    }

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts;
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

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    @Override
    public String toString() {
        return "ServiceCompany{" +
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
                ", comSource='" + comSource + '\'' +
                ", avatar='" + avatar + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", comWeb='" + comWeb + '\'' +
                ", comServer='" + comServer + '\'' +
                ", comDemand='" + comDemand + '\'' +
                ", affiliatedPark='" + affiliatedPark + '\'' +
                ", comProperty='" + comProperty + '\'' +
                ", comSynopsis='" + comSynopsis + '\'' +
                ", propagandaPicture='" + propagandaPicture + '\'' +
                ", mainProducts='" + mainProducts + '\'' +
                ", creditPoints='" + creditPoints + '\'' +
                ", creditUpdateTime='" + creditUpdateTime + '\'' +
                ", comAdmin='" + comAdmin + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", checkStatus='" + checkStatus + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", comId='" + comId + '\'' +
                '}';
    }
}