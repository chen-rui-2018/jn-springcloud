package com.jn.enterprise.data.vo;

import com.jn.enterprise.data.model.InputFormatModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 19:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TargetVO",description = "指标信息")
public class TargetVO implements Serializable {

    @ApiModelProperty(value = "指标ID" ,example = "1000")
    private String targetId;
    @ApiModelProperty(value = "父节点ID",example = "0001")
    private String parentId;
    @ApiModelProperty(value = "指标顺序",example = "23")
    private Integer orderNumber;
    @ApiModelProperty(value = "指标名称",example = "公司名称")
    private String targetName ;
    @ApiModelProperty(value = "部门ID",example = "001")
    private String departmentId;
    @ApiModelProperty(value = "部门名称",example = "招商部")
    private String departmentName;
    @ApiModelProperty(value = "是否支出多行输入（0：是，1：否）",example = "1")
    private Integer isMuiltRow ;
    @ApiModelProperty(value = "指标单位" ,example = "万元")
    private String unit ;
    @ApiModelProperty(value = "指标类型（0：企业指标，1园区指标）",example = "0")
    private Integer targetType;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）",example = "1")
    private Integer recordStatus ;
    @ApiModelProperty(value = "创建者账号",example = "zhangsan")
    private String creatorAccount ;
    @ApiModelProperty(value = "创建时间",example = "2018-12-21")
    private Date createdTime;
    @ApiModelProperty(value = "最新更新者账号",example = "lishi")
    private String modifierAccount;
    @ApiModelProperty(value = "创建时间",example = "2018-12-21")
    private Date modifiedTime ;
    @ApiModelProperty(value = "指标说明",example = "当前指标用于。。。。")
    private String targetCommon ;
    @ApiModelProperty(value = "tab指标集合所有的指标填写格式",example = "23")
    private List<InputFormatModel> inputFormatModels;

    public List<InputFormatModel> getInputFormatModels() {
        return inputFormatModels;
    }

    public void setInputFormatModels(List<InputFormatModel> inputFormatModels) {
        this.inputFormatModels = inputFormatModels;
    }

    public String getTargetCommon() {
        return targetCommon;
    }

    public void setTargetCommon(String targetCommon) {
        this.targetCommon = targetCommon;
    }

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

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
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

    public Integer getIsMuiltRow() {
        return isMuiltRow;
    }

    public void setIsMuiltRow(Integer isMuiltRow) {
        this.isMuiltRow = isMuiltRow;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

}
