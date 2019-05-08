package com.jn.park.asset.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
* 物品租赁model
* @author： zhuyz
* @date： Created on 2019/4/29 15:36
* @version： v1.0
* @modified By:
*/
public class AssetArticleLeaseModel implements Serializable {
    private static final long serialVersionUID = -1978576433733574213L;

    @ApiModelProperty(value = "主键",example = "3")
    private String id;

    @ApiModelProperty(value = "资产编号",example = "572058527984517120")
    private String assetNumber;

    @ApiModelProperty(value = "物品名称",example = "空调")
    private String name;

    @ApiModelProperty(value = "资产类型id",example = "569824881294704640")
    private String typeId;

    @ApiModelProperty(value = "物品类型(资产类型)",example = "空调")
    private String assetType;

    @ApiModelProperty(value = "规格",example = "1匹")
    private String specification;

    @ApiModelProperty(value = "二维码地址",example = "qrCode")
    private String qrCode;

    @ApiModelProperty(value = "租借押金",example = "100")
    private BigDecimal leaseCash;

    @ApiModelProperty(value = "租借单价",example = "200")
    private BigDecimal leasePrice;

    @ApiModelProperty(value = "最低租借时间",example = "10")
    private String leaseTime;

    @ApiModelProperty(value = "图片url",example = "url")
    private String imgUrl;

    @ApiModelProperty(value = "物品介绍",example = "格力空调")
    private String articleIntroduction;

    @ApiModelProperty(value = "租借企业",example = "美的")
    private String leaseEnterprise;

    @ApiModelProperty(value = "联系人",example = "先生")
    private String contactName;

    @ApiModelProperty(value = "联系方式",example = "123456")
    private String contactPhone;

    @ApiModelProperty(value = "开始时间",example = "2019-05-01")
    private Date startTime;

    @ApiModelProperty(value = "结束时间",example = "2019-06-01")
    private Date endTime;

    @ApiModelProperty(value = "租借状态",example = "3")
    private Byte articleStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public BigDecimal getLeaseCash() {
        return leaseCash;
    }

    public void setLeaseCash(BigDecimal leaseCash) {
        this.leaseCash = leaseCash;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(String leaseTime) {
        this.leaseTime = leaseTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction;
    }

    public String getLeaseEnterprise() {
        return leaseEnterprise;
    }

    public void setLeaseEnterprise(String leaseEnterprise) {
        this.leaseEnterprise = leaseEnterprise;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Byte articleStatus) {
        this.articleStatus = articleStatus;
    }
}
