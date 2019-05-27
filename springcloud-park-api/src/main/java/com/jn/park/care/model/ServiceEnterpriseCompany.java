package com.jn.park.care.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 企业详情Bean
 * @author： tangry
 * @String： Created on 2019/5/23
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceEnterpriseCompany",description = "企业详情NewBean")
public class ServiceEnterpriseCompany implements Serializable {

    private static final long serialVersionUID = 8499827256700034168L;

    @ApiModelProperty(value = "企业ID")
    private String id;

    @ApiModelProperty(value = "企业名称")
    private String comName;

    @ApiModelProperty(value = "企业简称")
    private String comNameShort;

    @ApiModelProperty(value = "企业logo地址")
    private String avatar;

    @ApiModelProperty(value = "企业管理员(申请人)")
    private String comAdmin;

    @ApiModelProperty(value = "企业官网地址")
    private String comWeb;

    @ApiModelProperty(value = "公司简介")
    private String comSynopsis;

    @ApiModelProperty(value = "园区楼宇ID")
    private String parkBuildId;

    @ApiModelProperty(value = "园区楼宇名称")
    private String parkBuildName;

    @ApiModelProperty(value = "企业类型")
    private String comType;

    @ApiModelProperty(value = "企业来源 1人才企业2招商企业")
    private String comSource;

    @ApiModelProperty(value = "企业宣传图片")
    private String proImgs;

    @ApiModelProperty(value = "统一社会信用代码")
    private String unifyCode;

    @ApiModelProperty(value = "我的服务")
    private String comServer;

    @ApiModelProperty(value = "我的需求")
    private String comDemand;

    @ApiModelProperty(value = "浏览数")
    private String browseNumber;

    @ApiModelProperty(value = "评论数")
    private String commentNumber;

    @ApiModelProperty(value = "关注用户数")
    private String careUser;

    @ApiModelProperty(value = "创建人")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private String createdTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getComAdmin() {
        return comAdmin;
    }

    public void setComAdmin(String comAdmin) {
        this.comAdmin = comAdmin;
    }

    public String getComWeb() {
        return comWeb;
    }

    public void setComWeb(String comWeb) {
        this.comWeb = comWeb;
    }

    public String getComSynopsis() {
        return comSynopsis;
    }

    public void setComSynopsis(String comSynopsis) {
        this.comSynopsis = comSynopsis;
    }

    public String getParkBuildId() {
        return parkBuildId;
    }

    public void setParkBuildId(String parkBuildId) {
        this.parkBuildId = parkBuildId;
    }

    public String getParkBuildName() {
        return parkBuildName;
    }

    public void setParkBuildName(String parkBuildName) {
        this.parkBuildName = parkBuildName;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getComSource() {
        return comSource;
    }

    public void setComSource(String comSource) {
        this.comSource = comSource;
    }

    public String getProImgs() {
        return proImgs;
    }

    public void setProImgs(String proImgs) {
        this.proImgs = proImgs;
    }

    public String getUnifyCode() {
        return unifyCode;
    }

    public void setUnifyCode(String unifyCode) {
        this.unifyCode = unifyCode;
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

    public String getCareUser() {
        return careUser;
    }

    public void setCareUser(String careUser) {
        this.careUser = careUser;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "ServiceEnterpriseCompany{" +
                "id='" + id + '\'' +
                ", comName='" + comName + '\'' +
                ", comNameShort='" + comNameShort + '\'' +
                ", avatar='" + avatar + '\'' +
                ", comAdmin='" + comAdmin + '\'' +
                ", comWeb='" + comWeb + '\'' +
                ", comSynopsis='" + comSynopsis + '\'' +
                ", parkBuildId='" + parkBuildId + '\'' +
                ", parkBuildName='" + parkBuildName + '\'' +
                ", comType='" + comType + '\'' +
                ", comSource='" + comSource + '\'' +
                ", proImgs=" + proImgs +
                ", unifyCode='" + unifyCode + '\'' +
                ", comServer='" + comServer + '\'' +
                ", comDemand='" + comDemand + '\'' +
                ", browseNumber=" + browseNumber +
                ", commentNumber=" + commentNumber +
                ", careUser=" + careUser +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}