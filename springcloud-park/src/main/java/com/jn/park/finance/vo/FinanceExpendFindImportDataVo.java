package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： tangry
 * @date： Created on 2019/3/13
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceExpendImportDataVo",description = "查询导入的数据")
public class FinanceExpendFindImportDataVo implements Serializable  {

    private static final long serialVersionUID = -1544111368208862317L;
    @ApiModelProperty(value = "数据ID")
    private String id;

    @ApiModelProperty(value = "费用发生时间YYYYMM")
    private String costHappendTime;

    @ApiModelProperty(value = "费用金额")
    private String cost;

    @ApiModelProperty(value = "费用流水号")
    private String costId;

    @ApiModelProperty(value = "打标前费用名称")
    private String costBeforeTypeName;

    @ApiModelProperty(value = "打标后费用类型")
    private String costAfterTypeId;

    @ApiModelProperty(value = "打标后费用名称")
    private String costAfterTypeName;


    @ApiModelProperty(value = "批次号")
    private String excelId;



    @ApiModelProperty(value = "费用发生部门Id")
    private String departmentId;

    @ApiModelProperty(value = "费用发生部门名称")
    private String departmentName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getExcelId() {
        return excelId;
    }

    public void setExcelId(String excelId) {
        this.excelId = excelId;
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
        return "FinanceExpendFindImportDataVo{" +
                "id='" + id + '\'' +
                ", costHappendTime='" + costHappendTime + '\'' +
                ", cost='" + cost + '\'' +
                ", costId='" + costId + '\'' +
                ", costBeforeTypeName='" + costBeforeTypeName + '\'' +
                ", costAfterTypeId='" + costAfterTypeId + '\'' +
                ", costAfterTypeName='" + costAfterTypeName + '\'' +
                ", excelId='" + excelId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
