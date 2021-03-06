package com.jn.park.electricmeter.vo;

import com.jn.park.electricmeter.model.PriceRuleContentModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 17:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PriceRuleVO",description = "计价规则")
public class PriceRuleVO implements Serializable {
    @ApiModelProperty("规则Id")
    private String id;

    @ApiModelProperty("规则名称")
    private String ruleName;

    @ApiModelProperty("规则描述")
    private String ruleDesc;

    @ApiModelProperty("是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty("规则内容")
    private List<PriceRuleContentModel> priceRuleContents;

    @ApiModelProperty("是否默认使用的计价规则【只能有一条有效】1默认计价规则 0：正常规则")
    private String isDefaultUse;

    public String getIsDefaultUse() {
        return isDefaultUse;
    }

    public void setIsDefaultUse(String isDefaultUse) {
        this.isDefaultUse = isDefaultUse;
    }

    public List<PriceRuleContentModel> getPriceRuleContents() {
        return priceRuleContents;
    }

    public void setPriceRuleContents(List<PriceRuleContentModel> priceRuleContents) {
        this.priceRuleContents = priceRuleContents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }
}
