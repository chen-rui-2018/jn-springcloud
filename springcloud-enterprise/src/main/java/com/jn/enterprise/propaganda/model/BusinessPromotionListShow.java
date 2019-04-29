package com.jn.enterprise.propaganda.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/18 11:54
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessPromotionListShow", description = "企业宣传查询列表出参")
public class BusinessPromotionListShow implements Serializable {
    @ApiModelProperty(value = "订单号(已付款的宣传才有订单号)")
    private String orderNum;
    @ApiModelProperty(value = "宣传类型")
    private String propagandaType;
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
    private String invalidDate;
    @ApiModelProperty(value = "宣传海报")
    private String posterUrl;
    @ApiModelProperty(value = "宣传费用")
    private String propagandaFee;
    @ApiModelProperty(value = "审批状态(-1：未付款  0：未审批  1：审批中   2：审批通过/已发布   3：审批不通过)")
    private String approvalStatus;
    @ApiModelProperty(value = "宣传区域(top:顶部  central:中部  bottom:底部)")
    private String propagandaArea;
    @ApiModelProperty(value = "数据状态(0:无效/未上架  1:有效/以上架      审批通过，但未上架属于”待发布“，审批通过，已上架属于“已发布”)")
    private String status;


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPropagandaType() {
        return propagandaType;
    }

    public void setPropagandaType(String propagandaType) {
        this.propagandaType = propagandaType;
    }

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

    public String getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(String invalidDate) {
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

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getPropagandaArea() {
        return propagandaArea;
    }

    public void setPropagandaArea(String propagandaArea) {
        this.propagandaArea = propagandaArea;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BusinessPromotionListShow{" +
                "orderNum='" + orderNum + '\'' +
                ", propagandaType='" + propagandaType + '\'' +
                ", id='" + id + '\'' +
                ", propagandaCode='" + propagandaCode + '\'' +
                ", propagandaTitle='" + propagandaTitle + '\'' +
                ", issuePlatform='" + issuePlatform + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", invalidDate='" + invalidDate + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", propagandaFee='" + propagandaFee + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", propagandaArea='" + propagandaArea + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
