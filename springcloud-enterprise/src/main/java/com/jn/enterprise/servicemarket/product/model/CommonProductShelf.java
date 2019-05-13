package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 常规产品上架
 * @author： chenr
 * @date： Created on 2019/3/23 16:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CommonProductShelf",description = "常规产品上架入参")
public class CommonProductShelf implements Serializable{
    @ApiModelProperty(value = "服务产品模板Id,所选产品的Id",required = true,example = "00000000000000001111111111111111")
    @NotBlank(message = "模板id不能为空")
    private String templateId;
    @ApiModelProperty(value = "服务产品顾问账号,多个时使用逗号','分隔",example = "wangsong,qianqi")
    private String advisorAccount;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }
}
