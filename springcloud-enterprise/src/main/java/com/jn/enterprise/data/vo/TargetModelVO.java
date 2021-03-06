package com.jn.enterprise.data.vo;

import com.jn.enterprise.data.model.TreeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/12 15:31
 * @version： v1.0
 * @modified By:
 */

@ApiModel(value = "TargetModeVO",description = "指标树")
public class TargetModelVO implements Serializable {
    @ApiModelProperty(value = "指标ID" ,example = "由后端生成")
    private String id;
    @ApiModelProperty(value = "父节点ID",example = "0001")
    private String pid;
    @ApiModelProperty(value = "指标顺序",example = "23")
    private Integer orderNumber;
    @ApiModelProperty(value = "指标名称",example = "公司名称")
    private String text ;
    @ApiModelProperty(value = "部门ID",example = "001")
    private String departmentId;
    @ApiModelProperty(value = "状态）",example = "open")
    private String state;
    @ApiModelProperty(value = "部门名称",example = "招商部")
    private String departmentName;
    @ApiModelProperty(value = "是否支出多行输入（0：是，1：否）",example = "1")
    private String isMuiltRow ;
    @ApiModelProperty(value = "指标单位" ,example = "万元")
    private String unit ;
    @ApiModelProperty(value = "指标类型（0：企业指标，1园区指标）",example = "0")
    private String targetType;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）",example = "1")
    private String recordStatus ;
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
    @ApiModelProperty(value = "子节点",example = "1")
    public List<TargetModelVO> children;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getTargetCommon() {
        return targetCommon;
    }

    public void setTargetCommon(String targetCommon) {
        this.targetCommon = targetCommon;
    }

    public List<TargetModelVO> getChildren() {
        return children;
    }

    public void setChildren(List<TargetModelVO> children) {
        this.children = children;
    }
}
