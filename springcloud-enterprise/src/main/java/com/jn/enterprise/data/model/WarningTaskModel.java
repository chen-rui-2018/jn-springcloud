package com.jn.enterprise.data.model;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/23 21:21
 * @version： v1.0
 * @modified By:
 */
public class WarningTaskModel implements Serializable {

    private String taskName;

    private Integer inLine;

    private Integer outLine;

    private String formTime;

    private String warningBy;

    private String fileType;

    private String fillInFormId;

    public String getFillInFormId() {
        return fillInFormId;
    }

    public void setFillInFormId(String fillInFormId) {
        this.fillInFormId = fillInFormId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getWarningBy() {
        return warningBy;
    }

    public void setWarningBy(String warningBy) {
        this.warningBy = warningBy;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getInLine() {
        return inLine;
    }

    public void setInLine(Integer inLine) {
        this.inLine = inLine;
    }

    public Integer getOutLine() {
        return outLine;
    }

    public void setOutLine(Integer outLine) {
        this.outLine = outLine;
    }

    public String getFormTime() {
        return formTime;
    }

    public void setFormTime(String formTime) {
        this.formTime = formTime;
    }
}
