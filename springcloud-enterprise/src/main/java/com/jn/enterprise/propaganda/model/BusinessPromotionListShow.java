package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/4/18 11:54
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessPromotionListShow", description = "企业宣传查询列表出参")
public class BusinessPromotionListShow implements Serializable {
    @ApiModelProperty(value = "主键id")
    private String id;
    @ApiModelProperty(value = "宣传编码")
    private String propagandaCode;
    @ApiModelProperty(value = "宣传产品/宣传标题")
    private String propagandaTitle;
    @ApiModelProperty(value = "发布平台")
    private String issuePlatform;
    @ApiModelProperty(value = "生效日期")
    private String effectiveDate;
    @ApiModelProperty(value = "失效日期")
    private Date invalidDate;
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

    public String getPropagandaTitle() {
        return propagandaTitle;
    }

    public void setPropagandaTitle(String propagandaTitle) {
        this.propagandaTitle = propagandaTitle;
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

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
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
        return "BusinessPromotionListShow{" +
                "id='" + id + '\'' +
                ", propagandaCode='" + propagandaCode + '\'' +
                ", propagandaTitle='" + propagandaTitle + '\'' +
                ", issuePlatform='" + issuePlatform + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", invalidDate=" + invalidDate +
                ", posterUrl='" + posterUrl + '\'' +
                ", propagandaFee='" + propagandaFee + '\'' +
                '}';
    }
}
