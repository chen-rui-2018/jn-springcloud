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
    @ApiModelProperty(value = "服务产品模板Id,所选产品的Id",required = true)
    @NotBlank(message = "模板id不能为空")
    private String templateId;
    @ApiModelProperty(value = "上架此产品的机构id" ,required = true)
    @NotBlank(message = "机构名称不能为空")
    private String orgId;
    @ApiModelProperty(value = "服务产品顾问账号,多个时使用逗号','分隔",example = "wangsong,qianqi")
    private String advisorAccount;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }
}
