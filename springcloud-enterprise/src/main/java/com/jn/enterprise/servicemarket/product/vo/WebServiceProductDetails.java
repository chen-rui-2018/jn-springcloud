package com.jn.enterprise.servicemarket.product.vo;

import com.jn.enterprise.servicemarket.product.model.WebServiceProductInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * web 前台服务产品详情
 * @author： chenr
 * @date： Created on 2019/3/1 17:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "WebServiceProductDetails",description = "web 前台服务产品详情")
public class WebServiceProductDetails implements Serializable {
    @ApiModelProperty(value ="服务产品详情")
    private  WebServiceProductInfo info;
    @ApiModelProperty(value ="服务产品详情下,同类型产品列表")
    private List<WebServiceProductInfo> infoList;

    public List<WebServiceProductInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<WebServiceProductInfo> infoList) {
        this.infoList = infoList;
    }

    public WebServiceProductInfo getInfo() {
        return info;
    }

    public void setInfo(WebServiceProductInfo info) {
        this.info = info;
    }
}
