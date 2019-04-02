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
    @ApiModelProperty(value = "机构ID",example = "10e9c030f3844ba3bbde2a0d88a6bd7d")
    private String orgId;
    @ApiModelProperty(value = "服务产品Id",example = "3677b55f9bd647ee950fe71b079f1e69")
    private String productId;
    @ApiModelProperty(value = "顾问账号",example = "wangsong")
    private String advisorAccount;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }
}
