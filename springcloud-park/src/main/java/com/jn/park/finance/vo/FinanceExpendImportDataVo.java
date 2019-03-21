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
@ApiModel(value = "FinanceExpendImportDataVo",description = "录入导入")
public class FinanceExpendImportDataVo implements Serializable {

    @ApiModelProperty(value = "费用发生时间YYYYMM")
    private String costHappendTime;

    @ApiModelProperty(value = "费用金额")
    private String cost;

    @ApiModelProperty(value = "费用流水号")
    private String costId;

    @ApiModelProperty(value = "批次号")
    private String excelId;

    @ApiModelProperty(value = "打标前费用名称")
    private String costBeforeTypeName;

    @ApiModelProperty(value = "打标后费用类型")
    private String costAfterTypeId;

    @ApiModelProperty(value = "打标后费用名称")
    private String costAfterTypeName;

    @ApiModelProperty(value = "费用发生部门ID")
    private String departmentId;

    @ApiModelProperty(value = "费用发生部门名称")
    private String departmentName;


    public String getCostHappendTime() {
        return costHappendTime;
    }

    public void setCostHappendTime(String costHappendTime) {
        this.costHappendTime = costHappendTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public String getExcelId() {
        return excelId;
    }

    public void setExcelId(String excelId) {
        this.excelId = excelId;
    }

    public String getCostBeforeTypeName() {
        return costBeforeTypeName;
    }

    public void setCostBeforeTypeName(String costBeforeTypeName) {
        this.costBeforeTypeName = costBeforeTypeName;
    }

    public String getCostAfterTypeId() {
        return costAfterTypeId;
    }

    public void setCostAfterTypeId(String costAfterTypeId) {
        this.costAfterTypeId = costAfterTypeId;
    }

    public String getCostAfterTypeName() {
        return costAfterTypeName;
    }

    public void setCostAfterTypeName(String costAfterTypeName) {
        this.costAfterTypeName = costAfterTypeName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "FinanceExpendImportDataVo{" +
                "costHappendTime='" + costHappendTime + '\'' +
                ", cost='" + cost + '\'' +
                ", costId='" + costId + '\'' +
                ", excelId='" + excelId + '\'' +
                ", costBeforeTypeName='" + costBeforeTypeName + '\'' +
                ", costAfterTypeId='" + costAfterTypeId + '\'' +
                ", costAfterTypeName='" + costAfterTypeName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
