package com.jn.enterprise.data.model;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/6 15:16
 * @version： v1.0
 * @modified By:
 */
public class ScientModel implements Serializable {
    /*@ApiModelProperty("填报ID")*/
    private String fallInFormId;

    /*@ApiModelProperty("快照指标ID")*/
    private String targetId;

    /*@ApiModelProperty("快照表模板ID")*/
    private String modelId;

    /*@ApiModelProperty("指标数据")*/
    private String data;

    /*@ApiModelProperty("快照表填报格式")*/
    private String formId;

    /*@ApiModelProperty("任务id")*/
    private String fillId;

    /*@ApiModelProperty("快照表表格ID")*/
    private String tabId;

    /*@ApiModelProperty("行号")*/
    private Integer rowNum;

    public String getFallInFormId() {
        return fallInFormId;
    }

    public void setFallInFormId(String fallInFormId) {
        this.fallInFormId = fallInFormId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }
}
