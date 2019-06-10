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
    @ApiModelProperty(value = "企业管理员账号")
    private String comAdmin;

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

    @ApiModelProperty(value = "企业性质ID")
    private String comProperty;

    @ApiModelProperty(value = "企业性质名称")
    private String comPropertyName;

    @ApiModelProperty(value = "企业人数")
    private String comPerSonNumber;
    @ApiModelProperty(value = "企业规模")
    private String comScale;
    @ApiModelProperty(value = "企业员工头像列表")
    private List<String> personAvatar;

    @ApiModelProperty(value = "注册地址")
    private String comAddress;
    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "浏览数")
    private String browseNumber;

    @ApiModelProperty(value = "评论数")
    private String commentNumber;

    @ApiModelProperty(value = "关注企业的用户数")
    private String careNumber;
    @ApiModelProperty(value = "是否关注 0 否 1 是")
    private String isCare;

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
    @ApiModelProperty(value = "信用积分")
    private String creditPoints;
    @ApiModelProperty(value = "信用积分更新时间")
    private String creditUpdateTime;

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

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
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

    public String getComProperty() {
        return comProperty;
    }

    public void setComProperty(String comProperty) {
        this.comProperty = comProperty;
    }

    public String getComPropertyName() {
        return comPropertyName;
    }

    public void setComPropertyName(String comPropertyName) {
        this.comPropertyName = comPropertyName;
    }

    public String getComPerSonNumber() {
        return comPerSonNumber;
    }

    public void setComPerSonNumber(String comPerSonNumber) {
        this.comPerSonNumber = comPerSonNumber;
    }

    public String getComScale() {
        return comScale;
    }

    public void setComScale(String comScale) {
        this.comScale = comScale;
    }

    public List<String> getPersonAvatar() {
        return personAvatar;
    }

    public void setPersonAvatar(List<String> personAvatar) {
        this.personAvatar = personAvatar;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getIsCare() {
        return isCare;
    }

    public void setIsCare(String isCare) {
        this.isCare = isCare;
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

    @Override
    public String toString() {
        return "CompanyInfoShow{" +
                "companyId='" + companyId + '\'' +
                ", comName='" + comName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", comWeb='" + comWeb + '\'' +
                ", comAdmin='" + comAdmin + '\'' +
                ", affiliatedId='" + affiliatedId + '\'' +
                ", affiliatedName='" + affiliatedName + '\'' +
                ", comServer='" + comServer + '\'' +
                ", comDemand='" + comDemand + '\'' +
                ", foundingTime='" + foundingTime + '\'' +
                ", comProperty='" + comProperty + '\'' +
                ", comPropertyName='" + comPropertyName + '\'' +
                ", comPerSonNumber='" + comPerSonNumber + '\'' +
                ", comScale='" + comScale + '\'' +
                ", personAvatar=" + personAvatar +
                ", comAddress='" + comAddress + '\'' +
                ", city='" + city + '\'' +
                ", browseNumber='" + browseNumber + '\'' +
                ", commentNumber='" + commentNumber + '\'' +
                ", careNumber='" + careNumber + '\'' +
                ", isCare='" + isCare + '\'' +
                ", comSynopsis='" + comSynopsis + '\'' +
                ", addrPark='" + addrPark + '\'' +
                ", conTele='" + conTele + '\'' +
                ", ownerLaw='" + ownerLaw + '\'' +
                ", ownerPhone='" + ownerPhone + '\'' +
                ", products='" + products + '\'' +
                ", creditPoints='" + creditPoints + '\'' +
                ", creditUpdateTime='" + creditUpdateTime + '\'' +
                '}';
    }
}
