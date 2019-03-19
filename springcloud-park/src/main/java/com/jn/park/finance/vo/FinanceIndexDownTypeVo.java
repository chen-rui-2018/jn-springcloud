package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIndexDownTypeVo",description = "支出录入查询")
public class FinanceIndexDownTypeVo implements Serializable {

    @ApiModelProperty(value = "费用发生月份")
    private String  costHappendRtime;
    @ApiModelProperty(value = "支出金额")
    private String cost;
    @ApiModelProperty(value = "打标后类型")
    private String costAfterTypeName;
    @ApiModelProperty(value = "操作时间")
    private String modifiedTime;
    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    public String getCostHappendRtime() {
        return costHappendRtime;
    }

    public void setCostHappendRtime(String costHappendRtime) {
        this.costHappendRtime = costHappendRtime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostAfterTypeName() {
        return costAfterTypeName;
    }

    public void setCostAfterTypeName(String costAfterTypeName) {
        this.costAfterTypeName = costAfterTypeName;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
