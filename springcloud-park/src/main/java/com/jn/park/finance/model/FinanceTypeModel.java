package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceTypeModel",description = "财务项目类型")
public class FinanceTypeModel implements Serializable {
    @ApiModelProperty("财务项目ID")
    private String id;

    @NotNull(message = "财务项目名称不能为空")
    @ApiModelProperty("财务项目名称")
    private String financeName;

    @NotNull(message = "显示顺序不能为空")
    @Min(value = 1,message = "显示顺序只能为正整数")
    @ApiModelProperty("显示顺序（越小越靠前）")
    private Integer showOrder;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

}