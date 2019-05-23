package com.jn.enterprise.servicemarket.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 11:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorProductQuery", description = "机构-服务产品列表查询条件,包含机构下产品统计信息")
public class OrgCountQueryParam  extends Page implements Serializable {
    @ApiModelProperty(value ="机构id",required = true,example = "1001211")
    @NotBlank(message = "机构id不能为空!")
    private String orgd;
    @ApiModelProperty(value ="产品类型,0-常规服务产品,1-特色服务产品,不给值则返回全部",example = "0")
    private String productType;
    @ApiModelProperty(value ="五星好评,输入'5'则表示只返回五分服务产品",example = "5")
    private String praise;

    public String getOrgd() {
        return orgd;
    }

    public void setOrgd(String orgd) {
        this.orgd = orgd;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }
}
