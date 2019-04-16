package com.jn.enterprise.servicemarket.org.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务超市统计数据[业务领域查询]
 * @author： jiangyl
 * @date： Created on 2019/2/13 15:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessStatisticalNumVO", description = "服务超市统计数据[业务领域查询]")
public class BusinessStatisticalNumVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "机构数")
    private String orgNum;

    @ApiModelProperty(value = "产品")
    private String productNum;

    @ApiModelProperty(value = "顾问数")
    private String advisorNum;

    @ApiModelProperty(value = "评价数")
    private String evaluateNum;
    @ApiModelProperty(value = "交易量")
    private String transactionNum;

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getAdvisorNum() {
        return advisorNum;
    }

    public void setAdvisorNum(String advisorNum) {
        this.advisorNum = advisorNum;
    }

    public String getEvaluateNum() {
        return evaluateNum;
    }

    public void setEvaluateNum(String evaluateNum) {
        this.evaluateNum = evaluateNum;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }
}
