package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CompanyTree {

    @ApiModelProperty(value = "父ID")
    private String parent_id;

    @ApiModelProperty(value = "")
    private String tatarget_name;

    @ApiModelProperty(value = "")
    private String task_batch;

    @ApiModelProperty(value = "")
    private String target_id;

    @ApiModelProperty(value = "")
    private String model_id;

    @ApiModelProperty(value = "")
    private String tab_id;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "指标值")
    private String DATA;

    @ApiModelProperty(value = "合计")
    private String sum_val;

    @ApiModelProperty(value = "指标名称")
    private String target_name;

    @ApiModelProperty(value = "填报格式名称")
    private String form_name;

    private  String form_id;




    public String getForm_name() {
        return form_name;
    }

    public void setForm_name(String form_name) {
        this.form_name = form_name;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    private List<CompanyTree> children;

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }


    public String getTatarget_name() {
        return tatarget_name;
    }

    public void setTatarget_name(String tatarget_name) {
        this.tatarget_name = tatarget_name;
    }


    public String getTask_batch() {
        return task_batch;
    }

    public void setTask_batch(String task_batch) {
        this.task_batch = task_batch;
    }

    public String getTarget_id() {
        return target_id;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public String getTab_id() {
        return tab_id;
    }

    public void setTab_id(String tab_id) {
        this.tab_id = tab_id;
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

    public String getSum_val() {
        return sum_val;
    }

    public void setSum_val(String sum_val) {
        this.sum_val = sum_val;
    }

    public String getTarget_name() {
        return target_name;
    }

    public void setTarget_name(String target_name) {
        this.target_name = target_name;
    }

    public List<CompanyTree> getChildren() {
        return children;
    }

    public void setChildren(List<CompanyTree> children) {
        this.children = children;
    }
}
