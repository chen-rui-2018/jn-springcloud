package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: yangph
 * @Date: 2019/2/13 9:59
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorInquiryInfo",description = "服务顾问列表查询入参")
public class AdvisorInquiryInfo extends Page {
    @ApiModelProperty(value = "领域")
    private String domain;
    @ApiModelProperty(value = "排序类型")
    private String sortTypes;
    @ApiModelProperty(value = "关键词")
    private String keyWords;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
