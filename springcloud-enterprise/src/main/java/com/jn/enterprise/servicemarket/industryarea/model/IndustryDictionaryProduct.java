package com.jn.enterprise.servicemarket.industryarea.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 机构数据字典
 * @author： jiangyl
 * @date： Created on 2019/3/1 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "IndustryDictionaryProduct",description = "机构数据字典[包含常规服务]")
public class IndustryDictionaryProduct {
    @ApiModelProperty(value = "领域ID")
    private String id;

    @ApiModelProperty(value = "领域值")
    private String preValue;

    @ApiModelProperty(value = "产品列表")
    private List<IndustryProduct> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }

    public List<IndustryProduct> getProducts() {
        return products;
    }

    public void setProducts(List<IndustryProduct> products) {
        this.products = products;
    }
}
