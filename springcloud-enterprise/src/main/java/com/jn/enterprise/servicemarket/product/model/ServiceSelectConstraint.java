package com.jn.enterprise.servicemarket.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务产品管理,列表查询条件bean
 * @author： chenr
 * @date： Created on 2019/2/14 14:57
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceSelectConstraint", description = "列表查询条件bean信息")
public class ServiceSelectConstraint extends Page implements Serializable {
    @ApiModelProperty(value = "服务产品类型")
    private String productType;
    @ApiModelProperty(value = "服务产品状态")
    private String status;
    @ApiModelProperty(value = "服务产品领域名称")
    private String signoryName;
    @ApiModelProperty(value = "产品机构名称")
    private String orgName;
    @ApiModelProperty(value = "服务产品名称")
    private String productName;
    @ApiModelProperty(value = "服务产品发布开始日期")
    private String startTime;
    @ApiModelProperty(value = "服务产品发布结束日期")
    private String endTime;
    @ApiModelProperty(value = "机构类别")
    private String orgType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSignoryName() {
        return signoryName;
    }

    public void setSignoryName(String signoryName) {
        this.signoryName = signoryName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
}
