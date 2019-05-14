package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CompanyTree {

    @ApiModelProperty(value = "任务批次")
    private String taskbatch;

    @ApiModelProperty(value = "模板ID")
    private String modelid;

    @ApiModelProperty(value = "")
    private String tabid;

    @ApiModelProperty(value = "")
    private String tabname;

    @ApiModelProperty(value = "")
    private String targetid;

    @ApiModelProperty(value = "指标名称")
    private String targetname;

    @ApiModelProperty(value = "父ID")
    private String parentid;

    @ApiModelProperty(value = "填报格式名称")
    private  String formid;

    @ApiModelProperty(value = "填报格式名称")
    private String formname;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "指标值")
    private String DATA;


    @ApiModelProperty(value = "合计")
    private String sumval;

    @ApiModelProperty(value = "子集")
    private List<CompanyTree> children;


    public String getTaskbatch() {
        return taskbatch;
    }

    public void setTaskbatch(String taskbatch) {
        this.taskbatch = taskbatch;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public String getTabid() {
        return tabid;
    }

    public void setTabid(String tabid) {
        this.tabid = tabid;
    }

    public String getTabname() {
        return tabname;
    }

    public void setTabname(String tabname) {
        this.tabname = tabname;
    }

    public String getTargetid() {
        return targetid;
    }

    public void setTargetid(String targetid) {
        this.targetid = targetid;
    }

    public String getTargetname() {
        return targetname;
    }

    public void setTargetname(String targetname) {
        this.targetname = targetname;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

    public String getSumval() {
        return sumval;
    }

    public void setSumval(String sumval) {
        this.sumval = sumval;
    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public List<CompanyTree> getChildren() {
        return children;
    }

    public void setChildren(List<CompanyTree> children) {
        this.children = children;
    }
}
