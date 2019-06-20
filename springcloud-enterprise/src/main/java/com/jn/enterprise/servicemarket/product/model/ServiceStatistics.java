package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统计服务产品界面的机构数/服务数等信息
 * @author： chenr
 * @date： Created on 2019/3/19 11:20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="ServiceStatistics", description = "统计服务产品界面的机构数/服务数等信息")
public class ServiceStatistics  implements Serializable {
    @ApiModelProperty(value = "机构数")
    private Integer orgCount;
    @ApiModelProperty(value = "产品数")
    private Integer productCount;
    @ApiModelProperty(value = "顾问数")
    private Integer advisorCount;
    @ApiModelProperty(value = "交易数")
    private Integer requireCount;
    @ApiModelProperty(value = "评价数")
    private Integer commentCount;

    public Integer getOrgCount() {
        return orgCount;
    }

    public void setOrgCount(Integer orgCount) {
        this.orgCount = orgCount;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getAdvisorCount() {
        return advisorCount;
    }

    public void setAdvisorCount(Integer advisorCount) {
        this.advisorCount = advisorCount;
    }

    public Integer getRequireCount() {
        return requireCount;
    }

    public void setRequireCount(Integer requireCount) {
        this.requireCount = requireCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return "ServiceStatistics{" +
                "orgCount=" + orgCount +
                ", productCount=" + productCount +
                ", advisorCount=" + advisorCount +
                ", requireCount=" + requireCount +
                ", commentCount=" + commentCount +
                '}';
    }
}
