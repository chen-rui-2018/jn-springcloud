package com.jn.enterprise.servicemarket.comment.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 对他人评价查询入参
 * @author： jiangyl
 * @date： Created on 2019/2/25 15:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "RatingParameter",description = "对他人评价查询入参")
public class RatingParameter extends Page {
    @ApiModelProperty(value = "机构名称[模糊搜索]",example = "中国电信")
    private String orgName;
    @ApiModelProperty(value = "服务产品名称",example = "通讯服务")
    private String productName;
    @ApiModelProperty(value = "专员账号",example = "wangsong")
    private String advisorAccount;

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

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }
}
