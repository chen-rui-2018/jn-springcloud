package com.jn.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 账单详情实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/2 16:41
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillDetails" ,description = "账单详情实体类")
public class PayBillDetails implements Serializable {
    private static final long serialVersionUID = 9133457186116223879L;

    @ApiModelProperty(value="费用详情名称",example = "房间号")
    private String costName;

    @ApiModelProperty(value="费用详情对应值",example = "607")
    private String costValue;

    @ApiModelProperty(value="排序字段(升序排序【1-100】)",example = "1")
    private Integer sort;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostValue() {
        return costValue;
    }

    public void setCostValue(String costValue) {
        this.costValue = costValue;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
