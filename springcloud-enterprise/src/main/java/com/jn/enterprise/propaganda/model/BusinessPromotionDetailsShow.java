package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/18 14:50
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessPromotionDetailsShow", description = "企业宣传详情出参")
public class BusinessPromotionDetailsShow implements Serializable {
    @ApiModelProperty(value = "宣传id")
    private String id;
    @ApiModelProperty(value = "宣传编码")
    private String propagandaCode;
    @ApiModelProperty(value = "发布平台")
    private String issuePlatform;
    @ApiModelProperty(value = "生效日期")
    private String effectiveDate;
    @ApiModelProperty(value = "失效日期")
    private String invalidDate;
    @ApiModelProperty(value = "宣传类型")
    private String propagandaType;
    @ApiModelProperty(value = "宣传类型名称")
    private String propagandaTypeName;
    @ApiModelProperty(value = "宣传产品/宣传标题")
    private String propagandaTitle;
    @ApiModelProperty(value = "宣传详情")
    private String propagandaDetails;
    @ApiModelProperty(value = "宣传区域(top:顶部  central:中部     bottom:底部)")
    private String propagandaArea;
    @ApiModelProperty(value = "宣传区域Url")
    private String propagandaAreaUrl;
    @ApiModelProperty(value = "宣传海报")
    private String posterUrl;
    @ApiModelProperty(value = "宣传费用")
    private String propagandaFee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropagandaCode() {
        return propagandaCode;
    }

    public void setPropagandaCode(String propagandaCode) {
        this.propagandaCode = propagandaCode;
    }

    public String getIssuePlatform() {
        return issuePlatform;
    }

    public void setIssuePlatform(String issuePlatform) {
        this.issuePlatform = issuePlatform;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(String invalidDate) {
        this.invalidDate = invalidDate;
    }

    public String getPropagandaType() {
        return propagandaType;
    }

    public void setPropagandaType(String propagandaType) {
        this.propagandaType = propagandaType;
    }

    public String getPropagandaTypeName() {
        return propagandaTypeName;
    }

    public void setPropagandaTypeName(String propagandaTypeName) {
        this.propagandaTypeName = propagandaTypeName;
    }

    public String getPropagandaTitle() {
        return propagandaTitle;
    }

    public void setPropagandaTitle(String propagandaTitle) {
        this.propagandaTitle = propagandaTitle;
    }

    public String getPropagandaDetails() {
        return propagandaDetails;
    }

    public void setPropagandaDetails(String propagandaDetails) {
        this.propagandaDetails = propagandaDetails;
    }


    public String getPropagandaArea() {
        return propagandaArea;
    }

    public void setPropagandaArea(String propagandaArea) {
        this.propagandaArea = propagandaArea;
    }

    public String getPropagandaAreaUrl() {
        return propagandaAreaUrl;
    }

    public void setPropagandaAreaUrl(String propagandaAreaUrl) {
        this.propagandaAreaUrl = propagandaAreaUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getPropagandaFee() {
        return propagandaFee;
    }

    public void setPropagandaFee(String propagandaFee) {
        this.propagandaFee = propagandaFee;
    }


    @Override
    public String toString() {
        return "BusinessPromotionDetailsShow{" +
                "id='" + id + '\'' +
                ", propagandaCode='" + propagandaCode + '\'' +
                ", issuePlatform='" + issuePlatform + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", invalidDate='" + invalidDate + '\'' +
                ", propagandaType='" + propagandaType + '\'' +
                ", propagandaTypeName='" + propagandaTypeName + '\'' +
                ", propagandaTitle='" + propagandaTitle + '\'' +
                ", propagandaDetails='" + propagandaDetails + '\'' +
                ", propagandaArea='" + propagandaArea + '\'' +
                ", propagandaAreaUrl='" + propagandaAreaUrl + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", propagandaFee='" + propagandaFee + '\'' +
                '}';
    }
}
