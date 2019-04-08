package com.jn.enterprise.data.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 19:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Target",description = "指标信息")
public class Target implements Serializable {

    @ApiModelProperty(value = "指标ID")
    private String targetId;
    @ApiModelProperty(value = "是否具备子节点（0：是，1否），显示图标是文件夹")
    private String haveChild;
    @ApiModelProperty(value = "父节点ID")
    private String parentId;
    @ApiModelProperty(value = "指标顺序")
    private String order;
    @ApiModelProperty(value = "指标名称")
    private String targetName ;
    @ApiModelProperty(value = "部门ID")
    private String departmentId;
    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    @ApiModelProperty(value = "是否支出多行输入（0：是，1：否）")
    private String isMuiltRow ;
    @ApiModelProperty(value = "指标单位")
    private String unit ;
    @ApiModelProperty(value = "指标类型（0：企业指标，1园区指标）")
    private String targetType;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private String recordStatus ;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount ;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;
    @ApiModelProperty(value = "创建时间")
    private String modifiedTime ;
    @ApiModelProperty(value = "指标填写格式")
    private List<InputFormat> inputFormats;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getHaveChild() {
        return haveChild;
    }

    public void setHaveChild(String haveChild) {
        this.haveChild = haveChild;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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

    public String getIsMuiltRow() {
        return isMuiltRow;
    }

    public void setIsMuiltRow(String isMuiltRow) {
        this.isMuiltRow = isMuiltRow;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<InputFormat> getInputFormats() {
        return inputFormats;
    }

    public void setInputFormats(List<InputFormat> inputFormats) {
        this.inputFormats = inputFormats;
    }
}
