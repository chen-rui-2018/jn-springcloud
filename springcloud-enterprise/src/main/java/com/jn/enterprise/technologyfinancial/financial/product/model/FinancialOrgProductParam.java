package com.jn.enterprise.technologyfinancial.financial.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/6/19 10:23
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinancialOrgProductParam", description = "机构金融产品列表查询入参")
public class FinancialOrgProductParam extends Page implements Serializable {
    @ApiModelProperty(value = "机构id",required = true)
    @NotBlank(message = "机构id不能为空")
    private String orgId;
    @ApiModelProperty(value = "产品类型 0-常规产品,1-特色产品",example = "1")
    @NotBlank(message = "产品类型不能为空")
    private String productType;
    @ApiModelProperty(value = "关键词-服务产品名称",example = "代理理财")
    private String keyWords;
    @ApiModelProperty(value ="状态( -1无效(下架) 0-待审核 1-有效(上架/审核通过) 2-审核不通过)",example = "1")
    private String productStatus;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    @NotNull
    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(@NotNull String needPage) {
        this.needPage = needPage;
    }

    @Override
    public String toString() {
        return "FinancialOrgProductParam{" +
                "orgId='" + orgId + '\'' +
                ", productType='" + productType + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", needPage='" + needPage + '\'' +
                '}';
    }
}
