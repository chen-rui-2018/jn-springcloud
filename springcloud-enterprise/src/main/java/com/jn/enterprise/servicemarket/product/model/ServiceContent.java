package com.jn.enterprise.servicemarket.product.model;

import com.jn.enterprise.servicemarket.product.entity.TbServiceAndAdvisor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;


/**
 * @author： chenr
 * @date： Created on 2019/02/13 9:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceContent", description = "服务基本信息")
public class ServiceContent  implements Serializable {
    @ApiModelProperty(value = "服务产品ID")
    private String productId;
    @ApiModelProperty(value = "服务产品编号")
    private String serialNumber;
    @ApiModelProperty(value = "服务产品名称")
    private String productName;
    @ApiModelProperty(value = "服务产品参考价格范围")
    private String referPrice;
    @ApiModelProperty(value = "服务产品领域ID")
    private String signoryId;
    @ApiModelProperty(value = "服务产品领域名称")
    private String signoryName;
    @ApiModelProperty(value = "服务产品机构id")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "服务产品服务周期,单位为年或月或者日(天)")
    private String serviceCycle;
    @ApiModelProperty(value = "服务产品图片路径")
    private String pictureUrl;
    @ApiModelProperty(value = "服务产品类型(0-常规产品,1-特色产品)0 ")
    private String productType;
    @ApiModelProperty(value = "状态( -1无效(下架) 0-待审核 1-有效(上架/审核通过) 2-审核不通过)")
    private String status;
    @ApiModelProperty(value = "服务产品专员账号")
    private String advisorAccount;
    @ApiModelProperty(value = "服务产品的详情存入数据库时,后台转换使用")
    private String  serviceDetails;
    @ApiModelProperty(value = "服务产品详情")
    private String productDetails;
    @ApiModelProperty(value = "模板ID", hidden = true)
    private String templateId;
    @ApiModelProperty(value = "是否删除", hidden = true)
    private String recordStatus;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private String createdTime;
    @ApiModelProperty(value = "创建者账号", hidden = true)
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间", hidden = true)
    private String modifiedTime;
    @ApiModelProperty(value = "修改者账号", hidden = true)
    private String modifierAccount;
    @ApiModelProperty(value = "浏览数", hidden = true)
    private String viewCount;

    @ApiModelProperty(value = "专员")
    private List<TbServiceAndAdvisor> tb_service_and_advisor;

    private static final long serialVersionUID = 1L;

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

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public List<TbServiceAndAdvisor> getTb_service_and_advisor() {
        return tb_service_and_advisor;
    }

    public void setTb_service_and_advisor(List<TbServiceAndAdvisor> tb_service_and_advisor) {
        this.tb_service_and_advisor = tb_service_and_advisor;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReferPrice() {
        return referPrice;
    }

    public void setReferPrice(String referPrice) {
        this.referPrice = referPrice;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    public String getSignoryName() {
        return signoryName;
    }

    public void setSignoryName(String signoryName) {
        this.signoryName = signoryName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getServiceCycle() {
        return serviceCycle;
    }

    public void setServiceCycle(String serviceCycle) {
        this.serviceCycle = serviceCycle;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceContent{" +
                "productId='" + productId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", referPrice='" + referPrice + '\'' +
                ", signoryId='" + signoryId + '\'' +
                ", signoryName='" + signoryName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", serviceCycle='" + serviceCycle + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", productType='" + productType + '\'' +
                ", status='" + status + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", serviceDetails='" + serviceDetails + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", templateId='" + templateId + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", tb_service_and_advisor=" + tb_service_and_advisor +
                '}';
    }
}
