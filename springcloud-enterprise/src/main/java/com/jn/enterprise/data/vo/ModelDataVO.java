package com.jn.enterprise.data.vo;

import com.jn.enterprise.data.entity.TbDataReportingGardenFiller;
import com.jn.enterprise.data.model.CompanyDataModel;
import com.jn.enterprise.data.model.DepartementModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 18:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ModelDataVO",description = "数据模板")
public class ModelDataVO implements Serializable {

    @ApiModelProperty(value = "tab集合",example = "表集合")
    private List<TabVO> tabs ;

    @ApiModelProperty(value = "task",example = "任务信息")
    private CompanyDataModel taskInfo ;

    @ApiModelProperty(value = "模板ID",example = "001")
    private String modelId;
    @ApiModelProperty(value = "模板名称",example = "企业知识产权上报模板")
    private String modelName ;
    @ApiModelProperty(value = "填报类型（0：企业，1：园管委会）",example = "0")
    private Byte modelType ;
    @ApiModelProperty(value = "填报群组(企业群组)/园区填报部门",example = "A群组")
    private String modelFormTargetId ;
    @ApiModelProperty(value = "填报周期（1：年，0：月）",example = "1")
    private Byte modelCycle ;
    @ApiModelProperty(value = "提前预警天数",example = "7")
    private String warningBeforeDays ;
    @ApiModelProperty(value = "预警方式：（0:短信1:邮件2:app）多选，值以逗号隔开",example = "0，1，2")
    private String warningBy ;
    @ApiModelProperty(value = "PC广告图",example = "yellow.png")
    private String pcAd;
    @ApiModelProperty(value = "app广告图",example = "red.png")
    private String appAd;
    @ApiModelProperty(value = "状态（0：发布1：暂停2：失效）",example = "0")
    private Byte recordStatus ;
    @ApiModelProperty(value = "描述",example = "这个模板用于。。。。")
    private String comment ;
    @ApiModelProperty(value = "附件",example = "附件文件上传")
    private String otherData;
    @ApiModelProperty(value = "群组ID")
    private String groupId;
    @ApiModelProperty(value = "年报表：任务生成日期（YYYYMMDD）月报表：是一个01-31之间的数字",example = "20182222")
    private String taskCreateTime ;
    @ApiModelProperty(value = "年报表：截止日期（YYYYMMDD）月报表：当月/下月+01-31之间的数字",example ="下月22" )
    private String filllInFormDeadline;
    @ApiModelProperty(value = "部门ID",example ="001")
    private String departmentId;
    @ApiModelProperty(value = "部门名称",example ="招商部")
    private String departmentName ;
    @ApiModelProperty(value = "模板顺序",example = "001")
    private Integer orderNumber ;
    public Integer getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    @ApiModelProperty(value = "任务全部填写完后的提醒人",example = "提醒人账号")
    private String reminder ;
    @ApiModelProperty(value = "创建者账号",example = "zhangsan")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间",example = "2020-12-21")
    private Date createdTime;
    @ApiModelProperty(value = "最新更新者账号",example = "zhangsan")
    private String modifierAccount ;
    @ApiModelProperty(value = "最新更新时间",example = "2020-12-21")
    private Date modifiedTime;

    @ApiModelProperty(value = "任务的权限集合",example = "")
    private List<TbDataReportingGardenFiller> gardenFiller;

    public List<TbDataReportingGardenFiller> getGardenFiller() {
        return gardenFiller;
    }

    public void setGardenFiller(List<TbDataReportingGardenFiller> gardenFiller) {
        this.gardenFiller = gardenFiller;
    }
    

    public List<TabVO> getTabs() {
        return tabs;
    }

    public void setTabs(List<TabVO> tabs) {
        this.tabs = tabs;
    }

    public CompanyDataModel getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(CompanyDataModel taskInfo) {
        this.taskInfo = taskInfo;
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

    public Byte getModelType() {
        return modelType;
    }

    public void setModelType(Byte modelType) {
        this.modelType = modelType;
    }

    public String getModelFormTargetId() {
        return modelFormTargetId;
    }

    public void setModelFormTargetId(String modelFormTargetId) {
        this.modelFormTargetId = modelFormTargetId;
    }

    public Byte getModelCycle() {
        return modelCycle;
    }

    public void setModelCycle(Byte modelCycle) {
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

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
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

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
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
