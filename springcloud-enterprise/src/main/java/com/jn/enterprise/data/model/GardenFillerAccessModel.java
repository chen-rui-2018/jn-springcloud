package com.jn.enterprise.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/28 10:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GardenFillerAccessModel",description = "园区填报人权限控制")
public class GardenFillerAccessModel implements Serializable {
    @ApiModelProperty(  value="任务id" , example="0001" )
    private String fillId;

    @ApiModelProperty(  value="填报人账号", example="0001" )
    private String filler;

    @ApiModelProperty(  value="填报人电话", example="" )
    private String fillerTel;

    @ApiModelProperty(  value="部门ID", example="" )
    private String departmentId;

    @ApiModelProperty(  value="部门名称", example="" )
    private String departmentName;

    @ApiModelProperty(  value="状态（企业状态0：已上报；1未上报2：草稿", example="0" )
    private Byte status;

    @ApiModelProperty(  value="是否删除（0标记删除，1正常）", example="1" )
    private Byte recordStatus;

    @ApiModelProperty(  value="审核状态", example="0" )
    private Byte gardenExamineStauts;

    @ApiModelProperty(  value="审批意见", example="XXXX" )
    private String examineComment;

    @ApiModelProperty(  value="快照tabId", example="001" )
    private String tabId;

    public String getFillId() {
        return fillId;
    }

    public void setFillId(String fillId) {
        this.fillId = fillId;
    }

    public String getFiller() {
        return filler;
    }

    public void setFiller(String filler) {
        this.filler = filler;
    }

    public String getFillerTel() {
        return fillerTel;
    }

    public void setFillerTel(String fillerTel) {
        this.fillerTel = fillerTel;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Byte getGardenExamineStauts() {
        return gardenExamineStauts;
    }

    public void setGardenExamineStauts(Byte gardenExamineStauts) {
        this.gardenExamineStauts = gardenExamineStauts;
    }

    public String getExamineComment() {
        return examineComment;
    }

    public void setExamineComment(String examineComment) {
        this.examineComment = examineComment;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }
}
