package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/13 9:59
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorListParam",description = "服务顾问列表查询入参")
public class AdvisorListParam extends Page implements Serializable {
    @ApiModelProperty(value = "领域",example = "technology_financial")
    private String domain;
    @ApiModelProperty(value = "排序类型(integrate:综合排序   popularity：人气排序   praise：好评排序   serviceNum：服务量排序)",example="integrate")
    private String sortTypes;
    @ApiModelProperty(value = "关键词",example="上海")
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
