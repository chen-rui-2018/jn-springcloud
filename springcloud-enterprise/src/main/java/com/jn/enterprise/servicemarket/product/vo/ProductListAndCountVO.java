package com.jn.enterprise.servicemarket.product.vo;

import com.jn.common.model.PaginationData;
import com.jn.enterprise.servicemarket.product.model.ServiceContent;
import com.jn.enterprise.servicemarket.product.model.ServiceStatistics;
import com.jn.enterprise.servicemarket.product.model.WebServiceProductInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 包含机构 服务等统计信息的服务产品列表
 * @author： chenr
 * @date： Created on 2019/3/19 11:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ProductListAndCountVO",description = "包含机构 服务等统计信息的服务产品列表")
public class ProductListAndCountVO implements Serializable {
    @ApiModelProperty(value="统计信息")
    private ServiceStatistics serviceStatistics;
    @ApiModelProperty(value = "服务产品列表信息")
    private PaginationData< List<WebServiceProductInfo>> productInfos;

    public ServiceStatistics getServiceStatistics() {
        return serviceStatistics;
    }

    public void setServiceStatistics(ServiceStatistics serviceStatistics) {
        this.serviceStatistics = serviceStatistics;
    }

    public PaginationData<List<WebServiceProductInfo>> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(PaginationData<List<WebServiceProductInfo>> productInfos) {
        this.productInfos = productInfos;
    }
}
