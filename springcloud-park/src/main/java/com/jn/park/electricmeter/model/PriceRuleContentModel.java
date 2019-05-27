package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/18 18:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PriceRuleContent",description = "计价规则内容")
public class PriceRuleContentModel implements Serializable {
    @ApiModelProperty("记录Id")
    private String id;

    @ApiModelProperty("规则id")
    private String ruleId;

    @ApiModelProperty("规则Id")
    private String ruleName;

    @ApiModelProperty("规则名称")
    private String price;

    @ApiModelProperty("是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty("开始")
    private Integer start;

    @ApiModelProperty("结束")
    private Integer end;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
