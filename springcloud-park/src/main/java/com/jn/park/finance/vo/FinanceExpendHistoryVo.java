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
@ApiModel(value = "FinanceExpendVo",description = "支出录入历史查询实体类")
public class FinanceExpendHistoryVo implements Serializable {

    private static final long serialVersionUID = 1947854306174339717L;

    @ApiModelProperty(value = "月份")
    private String costHappendTime;
    @ApiModelProperty(value = "流水号")
    private String costId;
    @ApiModelProperty(value = "支出金额")
    private String cost;
    @ApiModelProperty(value = "打标前费用名称")
    private String costBeforeTypeName;
    @ApiModelProperty(value = "打标后类型名称")
    private String costAfterTypeName;
    @ApiModelProperty(value = "操作时间")
    private String modifiedTime;
    @ApiModelProperty(value = "部门")
    private String departmentName;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCostHappendTime() {
        return costHappendTime;
    }

    public void setCostHappendTime(String costHappendTime) {
        this.costHappendTime = costHappendTime;
    }

    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostBeforeTypeName() {
        return costBeforeTypeName;
    }

    public void setCostBeforeTypeName(String costBeforeTypeName) {
        this.costBeforeTypeName = costBeforeTypeName;
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
