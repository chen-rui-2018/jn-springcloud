package com.jn.enterprise.usercenterindex.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/4 19:24
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "EmployeeRequisitionModel", description = "员工申请")
public class EmployeeRequisitionModel implements Serializable {

    @ApiModelProperty(value = "总数")
    private String total;

    @ApiModelProperty(value = "未审批")
    private String unExamine;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUnExamine() {
        return unExamine;
    }

    public void setUnExamine(String unExamine) {
        this.unExamine = unExamine;
    }

    @Override
    public String toString() {
        return "EmployeeRequisitionModel{" +
                "total='" + total + '\'' +
                ", unExamine='" + unExamine + '\'' +
                '}';
    }
}
