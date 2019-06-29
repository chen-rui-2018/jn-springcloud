package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 上架常规产品的bean
 * @author： chenr
 * @date： Created on 2019/2/15 14:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CommonServiceShelf", description = "上架常规产品信息")
public class CommonServiceShelf implements Serializable {
    @ApiModelProperty(value = "服务产品模板Id,所选产品的Id",required = true)
    @NotBlank(message = "模板id不能为空")
    private String templateId;
    @ApiModelProperty(value = "服务产品Id")
    private String productId;
    @ApiModelProperty(value = "服务产品名称")
    private String productName;
    @ApiModelProperty(value = "服务产品专员账号,多个时使用逗号','分隔")
    private String advisorAccount;
    @ApiModelProperty(value = "上架此产品的机构id" ,required = true)
    @NotBlank(message = "机构名称不能为空")
    private String orgId;
    public String getTemplateId() {
        return templateId;
    }
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "CommonServiceShelf{" +
                "templateId='" + templateId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", orgId='" + orgId + '\'' +
                '}';
    }
}
