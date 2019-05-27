package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/27 15:59
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyInfoShow",description = "企业基本信息")
public class CompanyInfoShow  implements Serializable {
    @ApiModelProperty(value = "企业ID")
    private String companyId;

    @ApiModelProperty(value = "企业名称")
    private String comName;

    @ApiModelProperty(value = "企业logo地址")
    private String avatar;

    @ApiModelProperty(value = "企业官网地址")
    private String comWeb;

    @ApiModelProperty(value = "所属园区ID")
    private String affiliatedId;

    @ApiModelProperty(value = "所属园区名称")
    private String affiliatedName;

    @ApiModelProperty(value = "我的服务")
    private String comServer;

    @ApiModelProperty(value = "我的需求")
    private String comDemand;

    @ApiModelProperty(value = "成立时间")
    private String foundingTime;

    @ApiModelProperty(value = "企业类型Id")
    private String comType;

    @ApiModelProperty(value = "企业人数")
    private String comPerSonNumber;
    @ApiModelProperty(value = "企业员工头像列表")
    private List<String> personAvatar;

    @ApiModelProperty(value = "注册地址")
    private String comAddress;

    @ApiModelProperty(value = "浏览数")
    private String browseNumber;

    @ApiModelProperty(value = "评论数")
    private String commentNumber;

    @ApiModelProperty(value = "关注用户数")
    private String careNumber;

    @ApiModelProperty(value = "公司简介")
    private String comSynopsis;
    @ApiModelProperty(value = "工作地址")
    private String addrPark;

    @ApiModelProperty(value = "联系电话")
    private String conTele;
    @ApiModelProperty(value = "企业法人")
    private String ownerLaw;
    @ApiModelProperty(value = "企业法人电话")
    private String ownerPhone;
    @ApiModelProperty(value = "企业产品")
    private String  products;

    public List<String> getPersonAvatar() {
        return personAvatar;
    }

    public void setPersonAvatar(List<String> personAvatar) {
        this.personAvatar = personAvatar;
    }

    public String getComSynopsis() {
        return comSynopsis;
    }

    public void setComSynopsis(String comSynopsis) {
        this.comSynopsis = comSynopsis;
    }

    public String getAddrPark() {
        return addrPark;
    }

    public void setAddrPark(String addrPark) {
        this.addrPark = addrPark;
    }

    public String getConTele() {
        return conTele;
    }

    public void setConTele(String conTele) {
        this.conTele = conTele;
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

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getComWeb() {
        return comWeb;
    }

    public void setComWeb(String comWeb) {
        this.comWeb = comWeb;
    }

    public String getAffiliatedId() {
        return affiliatedId;
    }

    public void setAffiliatedId(String affiliatedId) {
        this.affiliatedId = affiliatedId;
    }

    public String getAffiliatedName() {
        return affiliatedName;
    }

    public void setAffiliatedName(String affiliatedName) {
        this.affiliatedName = affiliatedName;
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

    public String getFoundingTime() {
        return foundingTime;
    }

    public void setFoundingTime(String foundingTime) {
        this.foundingTime = foundingTime;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getComPerSonNumber() {
        return comPerSonNumber;
    }

    public void setComPerSonNumber(String comPerSonNumber) {
        this.comPerSonNumber = comPerSonNumber;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(String browseNumber) {
        this.browseNumber = browseNumber;
    }

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCareNumber() {
        return careNumber;
    }

    public void setCareNumber(String careNumber) {
        this.careNumber = careNumber;
    }
}
