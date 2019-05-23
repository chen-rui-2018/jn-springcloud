package com.jn.hr.archives.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-16 下午 7:02
 */
@ApiModel(value = "ResumeDatabasePage", description = "员工档案分页实体类")
public class EmployeeFilePage extends Page implements Serializable {
    @ApiModelProperty(value = "文号")
    private String symbol;
    @ApiModelProperty(value = "题名")
    private String titleName;
    @ApiModelProperty(value = "分类ID")
    private String classId;
    @ApiModelProperty(value = "档案表ID")
    private String fileId;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "EmployeeFilePage{" +
                "symbol='" + symbol + '\'' +
                ", titleName='" + titleName + '\'' +
                ", classId='" + classId + '\'' +
                ", fileId='" + fileId + '\'' +
                "} " + super.toString();
    }
}
