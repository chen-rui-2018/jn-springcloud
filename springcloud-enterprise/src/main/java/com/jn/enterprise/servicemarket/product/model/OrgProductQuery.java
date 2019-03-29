package com.jn.enterprise.servicemarket.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 机构产品列表查询条件
 * @author： chenr
 * @date： Created on 2019/3/23 17:05
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgProductQuery" ,description = "机构产品列表查询条件")
public class OrgProductQuery extends Page implements Serializable {
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
}
