package com.jn.enterprise.company.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 编辑企业入参Bean
 * @author： huxw
 * @date： Created on 2019-4-18 16:24:07
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyUpdateParam",description = "编辑企业入参")
public class CompanyUpdateParam implements Serializable {

    @ApiModelProperty(value = "ID", hidden = true)
    private String id;

    @ApiModelProperty(value = "企业ID", hidden = true)
    private String comId;

    @NotNull(message = "企业名称不能为空")
    @ApiModelProperty(value = "企业名称", required = true, example = "深圳腾讯")
    private String comName;

    @NotNull(message = "企业简称不能为空")
    @ApiModelProperty(value = "企业简称", required = true, example = "腾讯")
    private String comNameShort;

    @NotNull(message = "企业logo不能为空")
    @ApiModelProperty(value = "企业logo",required = true,example = "**/**/**,jpg")
    private String avatar;

    @NotNull(message = "统一社会信用代码不能为空")
    @ApiModelProperty(value = "统一社会信用代码",required = true,example = "1000")
    private String unifyCode;

    @NotNull(message = "企业法人不能为空")
    @ApiModelProperty(value = "企业法人", required = true, example = "李薇薇")
    private String ownerLaw;

    @NotNull(message = "法人联系电话不能为空")
    @ApiModelProperty(value = "法人联系电话",required = true, example = "010-12812025")
    private String ownerPhone;

    @NotNull(message = "企业性质不能为空")
    @ApiModelProperty(value = "企业性质[多个用,分隔][传机构字典接口入参preType=3返回的ID]",required = true,notes = "传机构字典接口入参preType=3返回的ID",example = "guoyouqiye,minyingqiye")
    private String comProperty;

    @NotNull(message = "注册资金不能为空")
    @ApiModelProperty(value = "注册资金（万元）",required = true,example = "500")
    private Long regCapital;

    @NotNull(message = "企业规模不能为空")
    @ApiModelProperty(value = "企业规模（万元）", required = true)
    private Long comScale;

    @NotNull(message = "注册时间不能为空")
    @ApiModelProperty(value = "注册时间yyyy-MM-dd",required = true,example = "2018-01-01")
    private String foundingTime;

    @NotNull(message = "落地时间不能为空")
    @ApiModelProperty(value = "落地时间yyyy-MM-dd",required = true,example = "2018-01-01")
    private String runTime;

    @NotNull(message = "企业领域不能为空")
    @ApiModelProperty(value = "企业领域[产业领域、所属行业][传机构字典接口入参preType=1返回的ID]", required = true,notes = "传机构字典接口入参preType=1返回的ID",example = "shengwuyiyao")
    private String induType;

    @NotNull(message = "企业领域代码不能为空")
    @ApiModelProperty(value = "企业领域代码",example = "qilydm")
    private String induCode;

    @NotNull(message = "三证一体或营业执照照片不能为空")
    @ApiModelProperty(value = "三证一体或营业执照照片", required = true)
    private String businessLicense;

    @NotNull(message = "公司宣传图片不能为空")
    @ApiModelProperty(value = "公司宣传图片（多个,分隔）", required = true, example = "xxx,xxx,xxx")
    private String propagandaPicture;

    @ApiModelProperty(value = "主要产品",example = "计算机软件开发。。。")
    private String mainProducts;

    @NotNull(message = "公司注册地址不能为空")
    @ApiModelProperty(value = "公司注册地址",required = true,example = "XX省XX市XXX")
    private String comAddress;

    @ApiModelProperty(value = "固定电话",example = "010-111111")
    private String comTele;

    @NotNull(message = "企业官网地址不能为空")
    @ApiModelProperty(value = "企业官网地址",required = true, example = "www.baidu.com")
    private String comWeb;

    @ApiModelProperty(value = "我的服务",example = "***服务")
    private String comServer;

    @ApiModelProperty(value = "我的需求",example = "***需求")
    private String comDemand;

    @NotNull(message = "实际经营地址不能为空")
    @ApiModelProperty(value = "实际经营地址（园区地址）",required = true,example = "XX省XX市XXX")
    private String addrPark;

    @NotNull(message = "公司简介不能为空")
    @ApiModelProperty(value = "公司简介", required = true)
    private String comSynopsis;

    @NotNull(message = "企业来源不能为空")
    @ApiModelProperty(value = "企业来源 [1人才企业2招商企业]",notes = "1人才企业2招商企业",required = true,example = "1")
    private String comSource;

    @NotNull(message = "所属园区不能为空")
    @ApiModelProperty(value = "所属园区", required = true, example = "xx高新园区")
    private String affiliatedPark;

    @ApiModelProperty(value = "创建者账号", hidden = true)
    private String creatorAccount;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createdTime;

    @ApiModelProperty(value = "是否删除（0标记删除，1正常）", hidden = true)
    private String recordStatus;

    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码",required = true,example = "1234")
    private String checkCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUnifyCode() {
        return unifyCode;
    }

    public void setUnifyCode(String unifyCode) {
        this.unifyCode = unifyCode;
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

    public String getComProperty() {
        return comProperty;
    }

    public void setComProperty(String comProperty) {
        this.comProperty = comProperty;
    }

    public Long getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Long regCapital) {
        this.regCapital = regCapital;
    }

    public Long getComScale() {
        return comScale;
    }

    public void setComScale(Long comScale) {
        this.comScale = comScale;
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

    public String getInduType() {
        return induType;
    }

    public void setInduType(String induType) {
        this.induType = induType;
    }

    public String getInduCode() {
        return induCode;
    }

    public void setInduCode(String induCode) {
        this.induCode = induCode;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
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

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComTele() {
        return comTele;
    }

    public void setComTele(String comTele) {
        this.comTele = comTele;
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

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark;
    }

    public String getComSynopsis() {
        return comSynopsis;
    }

    public void setComSynopsis(String comSynopsis) {
        this.comSynopsis = comSynopsis;
    }

    public String getAffiliatedPark() {
        return affiliatedPark;
    }

    public void setAffiliatedPark(String affiliatedPark) {
        this.affiliatedPark = affiliatedPark;
    }

    public String getComSource() {
        return comSource;
    }

    public void setComSource(String comSource) {
        this.comSource = comSource;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
