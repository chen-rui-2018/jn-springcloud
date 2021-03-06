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
    @ApiModelProperty(value = "服务产品名称[模糊搜索]",example = "代理记账")
    private String productName;
    @ApiModelProperty(value = "专员名称[模糊搜索]",example = "战三")
    private String advisorName;
    @ApiModelProperty("当前用户[前台请忽略此参数]")
    private String account;

    public String getIssueAccount() {
        return issueAccount;
    }

    public void setIssueAccount(String issueAccount) {
        this.issueAccount = issueAccount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
