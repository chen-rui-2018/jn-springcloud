package com.jn.enterprise.data.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 18:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ModelData",description = "数据模板")
public class ModelData {
    @ApiModelProperty(value = "tab集合")
    private List<Tab> tabs ;

    @ApiModelProperty(value = "指标ID")
    private String targetd ;
    @ApiModelProperty(value = "模板ID")
    private String modelId;
    @ApiModelProperty(value = "模板名称")
    private String modelName ;
    @ApiModelProperty(value = "填报类型（0：企业，1：园管委会）")
    private String modelType ;
    @ApiModelProperty(value = "填报群组，填报对象")
    private String modelFormTargetId ;
    @ApiModelProperty(value = "填报周期（1：年，0：月）")
    private String modelCycle ;
    @ApiModelProperty(value = "提前预警天数")
    private String warningBeforeDays ;
    @ApiModelProperty(value = "预警方式：（0:短信1:邮件2:app）多选，值以逗号隔开")
    private String warningBy ;
    @ApiModelProperty(value = "PC广告图地址")
    private String pcAd;
    @ApiModelProperty(value = "app广告图地址")
    private String appAd;
    @ApiModelProperty(value = "状态（0：发布1：暂停2：失效）")
    private String recordStatus ;
    @ApiModelProperty(value = "描述")
    private String comment ;
    @ApiModelProperty(value = "附件")
    private String otherData;
    @ApiModelProperty(value = "群组ID")
    private String groupId;
    @ApiModelProperty(value = "年报表：任务生成日期（YYYYMMDD）月报表：是一个01-31之间的数字")
    private String taskCreateTime ;
    @ApiModelProperty(value = "年报表：截止日期（YYYYMMDD）月报表：当月/下月+01-31之间的数字")
    private String filllInFormDeadline;
    @ApiModelProperty(value = "部门ID")
    private String departmentId;
    @ApiModelProperty(value = "部门名称")
    private String departmentName ;
    @ApiModelProperty(value = "模板序号")
    private String order ;
    @ApiModelProperty(value = "任务全部填写完后的提醒人")
    private String reminder ;
    @ApiModelProperty(value = "是否已经提醒，填报完成")
    private String remindStatus ;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount ;
    @ApiModelProperty(value = "最新更新时间")
    private String modifiedTime;

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }

    public String getTargetd() {
        return targetd;
    }

    public void setTargetd(String targetd) {
        this.targetd = targetd;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelFormTargetId() {
        return modelFormTargetId;
    }

    public void setModelFormTargetId(String modelFormTargetId) {
        this.modelFormTargetId = modelFormTargetId;
    }

    public String getModelCycle() {
        return modelCycle;
    }

    public void setModelCycle(String modelCycle) {
        this.modelCycle = modelCycle;
    }

    public String getWarningBeforeDays() {
        return warningBeforeDays;
    }

    public void setWarningBeforeDays(String warningBeforeDays) {
        this.warningBeforeDays = warningBeforeDays;
    }

    public String getWarningBy() {
        return warningBy;
    }

    public void setWarningBy(String warningBy) {
        this.warningBy = warningBy;
    }

    public String getPcAd() {
        return pcAd;
    }

    public void setPcAd(String pcAd) {
        this.pcAd = pcAd;
    }

    public String getAppAd() {
        return appAd;
    }

    public void setAppAd(String appAd) {
        this.appAd = appAd;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(String taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getFilllInFormDeadline() {
        return filllInFormDeadline;
    }

    public void setFilllInFormDeadline(String filllInFormDeadline) {
        this.filllInFormDeadline = filllInFormDeadline;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public String getRemindStatus() {
        return remindStatus;
    }

    public void setRemindStatus(String remindStatus) {
        this.remindStatus = remindStatus;
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
}
