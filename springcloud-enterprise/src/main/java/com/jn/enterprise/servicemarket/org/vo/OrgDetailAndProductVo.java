package com.jn.enterprise.servicemarket.org.vo;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.product.model.WebServiceProductInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/3/21 15:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgDetailAndProductVo",description = "机构详情和机构产品列表(app机构信息)")
public class OrgDetailAndProductVo implements Serializable {
    @ApiModelProperty(value = "产品详情信息")
    private OrgDetailVo orgDetailVo;
    @ApiModelProperty(value="此机构的产品类表信息")
    private PaginationData<List<WebServiceProductInfo>> productList;

    public OrgDetailVo getOrgDetailVo() {
        return orgDetailVo;
    }

    public void setOrgDetailVo(OrgDetailVo orgDetailVo) {
        this.orgDetailVo = orgDetailVo;
    }

    public PaginationData<List<WebServiceProductInfo>> getProductList() {
        return productList;
    }

    public void setProductList(PaginationData<List<WebServiceProductInfo>> productList) {
        this.productList = productList;
    }
}
