package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 我的机构,专员-产品统计数
 * @author： chenr
 * @date： Created on 2019/3/26 18:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="OrgCount",description = "我的机构,专员-产品统计数")
public class OrgCount implements Serializable {
    @ApiModelProperty(value="专员数")
    private String  advisorNum;
    @ApiModelProperty(value ="产品数")
    private String productNum;

    public String getAdvisorNum() {
        return advisorNum;
    }

    public void setAdvisorNum(String advisorNum) {
        this.advisorNum = advisorNum;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }
}
