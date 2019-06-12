package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 数据上报指标对象
 * <pre>
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/24
 * </pre>
 */
@ApiModel(value = "DataTargetModel",description = "数据上报指标对象")
public class DataTargetModel implements Serializable {
    private static final long serialVersionUID = 967104402523863506L;
    @ApiModelProperty("指标ID")
    private String targetId;

    @ApiModelProperty("父节点ID")
    private String parentId;

    @ApiModelProperty("排序")
    private Integer orderNumber;

    @ApiModelProperty("指标名称")
    private String targetName;

    @ApiModelProperty("指标值")
    private String targetValue;

    @ApiModelProperty("指标值")
    private String targetData;

    @ApiModelProperty("指标单位")
    private String targetUnit;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public String getTargetData() {
        return targetData;
    }

    public void setTargetData(String targetData) {
        this.targetData = targetData;
    }

    public String getTargetUnit() {
        return targetUnit;
    }

    public void setTargetUnit(String targetUnit) {
        this.targetUnit = targetUnit;
    }

    @Override
    public String toString() {
        return "DataTargetModel{" +
                "targetId='" + targetId + '\'' +
                ", parentId='" + parentId + '\'' +
                ", orderNumber=" + orderNumber +
                ", targetName='" + targetName + '\'' +
                ", targetValue='" + targetValue + '\'' +
                ", targetData='" + targetData + '\'' +
                ", targetUnit='" + targetUnit + '\'' +
                '}';
    }
}
