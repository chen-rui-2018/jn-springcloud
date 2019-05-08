package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/24 19:48
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessPromotionWorkFlow", description = "企业宣传工作流传参")
public class BusinessPromotionWorkFlow implements Serializable {
    @ApiModelProperty(value = "宣传编码")
    private String propagandaCode;
    @ApiModelProperty(value = "宣传产品")
    private String propagandaTitle;
    @ApiModelProperty(value = "宣传类型")
    private String propagandaType;
    @ApiModelProperty(value = "发布平台(1：APP  2:门户  3：其他...)")
    private String issuePlatform;
    @ApiModelProperty(value = "生效日期")
    private String effectiveDate;
    @ApiModelProperty(value = "失效日期")
    private String invalidDate;
    @ApiModelProperty(value = "宣传区域(top:顶部  central:中部     bottom:底部)")
    private String propagandaArea;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "宣传详情")
    private String propagandaDetails;
    @ApiModelProperty(value = "宣传海报")
    private String posterUrl;
    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "机构id")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "宣传费用规则编码")
    private String proFeeRuleCode;
    @ApiModelProperty(value = "宣传费用")
    private Double propagandaFee;
    @ApiModelProperty(value = "是否支付")
    private String isPay;
    @ApiModelProperty(value = "审批状态")
    private String approvalStatus;
    @ApiModelProperty(value = "审批说明")
    private String approvalDesc;
    @ApiModelProperty(value = "订单号")
    private String orderCode;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private String modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "是否删除（0：已删除  1：有效）")
    private Byte recordStatus;


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

    public String getPropagandaType() {
        return propagandaType;
    }

    public void setPropagandaType(String propagandaType) {
        this.propagandaType = propagandaType;
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

    public String getPropagandaArea() {
        return propagandaArea;
    }

    public void setPropagandaArea(String propagandaArea) {
        this.propagandaArea = propagandaArea;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPropagandaDetails() {
        return propagandaDetails;
    }

    public void setPropagandaDetails(String propagandaDetails) {
        this.propagandaDetails = propagandaDetails;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProFeeRuleCode() {
        return proFeeRuleCode;
    }

    public void setProFeeRuleCode(String proFeeRuleCode) {
        this.proFeeRuleCode = proFeeRuleCode;
    }

    public Double getPropagandaFee() {
        return propagandaFee;
    }

    public void setPropagandaFee(Double propagandaFee) {
        this.propagandaFee = propagandaFee;
    }

    public String getIsPay() {
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalDesc() {
        return approvalDesc;
    }

    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }
}
