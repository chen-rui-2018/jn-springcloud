package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/4/24 19:48
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessPromotionWorkFlow", description = "企业宣传工作流传参")
public class BusinessPromotionWorkFlow implements Serializable {
    @ApiModelProperty(value = "宣传id")
    private String id;
    @ApiModelProperty(value = "宣传编码")
    private String propagandaCode;
    @ApiModelProperty(value = "发布平台(1：APP  2:门户  3：其他...)")
    private String issuePlatform;
    @ApiModelProperty(value = "宣传类型")
    private String propagandaType;
    @ApiModelProperty(value = "生效日期")
    private Date effectiveDate;
    @ApiModelProperty(value = "失效日期")
    private Date invalidDate;
    @ApiModelProperty(value = "宣传产品")
    private String propagandaTitle;
    @ApiModelProperty(value = "宣传详情")
    private String propagandaDetails;
    @ApiModelProperty(value = "宣传区域(top:顶部  central:中部     bottom:底部)")
    @NotNull(message="宣传区域不能为空")
    private String propagandaArea;
    @ApiModelProperty(value = "宣传海报")
    @NotNull(message="宣传海报不能为空")
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

    public String getPropagandaType() {
        return propagandaType;
    }

    public void setPropagandaType(String propagandaType) {
        this.propagandaType = propagandaType;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Date invalidDate) {
        this.invalidDate = invalidDate;
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
}
