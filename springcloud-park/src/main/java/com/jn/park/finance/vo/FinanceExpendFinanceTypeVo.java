package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceExpendFinanceTypeVo",description = "打标类型")
public class FinanceExpendFinanceTypeVo implements Serializable {
    private static final long serialVersionUID = -3566973047961435830L;
    @ApiModelProperty(value = "类型ID")
    private String id;
    @ApiModelProperty(value = "类型名称")
    private String financeName;

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


    @Override
    public String toString() {
        return "FinanceExpendFinanceTypeVo{" +
                "id='" + id + '\'' +
                ", financeName='" + financeName + '\'' +
                '}';
    }
}
