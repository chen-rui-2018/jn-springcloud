package com.jn.enterprise.servicemarket.comment.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 我收到的评价查询入参
 * @author： jiangyl
 * @date： Created on 2019/2/25 15:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ReceiveRatingParameter",description = "我收到的评价查询入参")
public class ReceiveRatingParameter extends Page {
    @ApiModelProperty(value = "需求提出人",example = "wangsong")
    private String issueAccount;
    @ApiModelProperty(value = "服务产品Id",example = "3677b55f9bd647ee950fe71b079f1e69")
    private String productId;
    @ApiModelProperty(value = "顾问Id",example = "41da7180518e4546b7f96fc02db08be3")
    private String advisorId;
    @ApiModelProperty("当前用户[前台请忽略此参数]")
    private String account;

    public String getIssueAccount() {
        return issueAccount;
    }

    public void setIssueAccount(String issueAccount) {
        this.issueAccount = issueAccount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
