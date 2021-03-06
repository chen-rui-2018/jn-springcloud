package com.jn.enterprise.servicemarket.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/2/22 10:47
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ProductInquiryInfo",description = "前台服务产品列表查询入参")
public class ProductInquiryInfo extends Page implements Serializable {
    @ApiModelProperty(value = "领域Id")
    private String signoryId;
    @ApiModelProperty(value = "机构id,要进行机构筛选时传入")
    private String orgId;
    @ApiModelProperty(value = "排序类型,(人气-popularity,好评-praise,服务量-serviceNum,综合-integrate),用户中心查询产品时不传值",example = "serviceNum")
    private String sortTypes;
    @ApiModelProperty(value = "关键词-(包含-名称,内容详情)用户中心查询产品时,传入名称",example = "代理记账")
    private String keyWords;
    @ApiModelProperty(value = "产品类型 0-常规产品,1-特色产品 不传则为全部",example = "1")
    private String productType;
    @ApiModelProperty(value ="状态( -1无效(下架) 0-待审核 1-有效(上架/审核通过) 2-审核不通过)")
    private String productStatus;
    @ApiModelProperty(value = "常规产品id,通过上架时所需的产品列表获取")
    private String commentProductId;

    public String getCommentProductId() {
        return commentProductId;
    }

    public void setCommentProductId(String commentProductId) {
        this.commentProductId = commentProductId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "ProductInquiryInfo{" +
                "signoryId='" + signoryId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", sortTypes='" + sortTypes + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", productType='" + productType + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", commentProductId='" + commentProductId + '\'' +
                '}';
    }
}
