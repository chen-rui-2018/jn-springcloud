package com.jn.hr.archives.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.PaginationData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author dt
 * @create 2019-04-16 下午 6:54
 */
@ApiModel(value = "EmployeeFile", description = "员工档案实体")
public class EmployeeFile extends BaseRowModel implements Serializable {
    @ApiModelProperty(value = "唯一标识符")
    private String fileId;
    @ApiModelProperty(value = "分类ID")
    private String classId;
    @ApiModelProperty(value = "分类名称")
    @ExcelProperty(value = "分类名称", index = 0)
    private String nodeName;
    @ApiModelProperty(value = "文号")
    @ExcelProperty(value = "文号", index = 1)
    private String symbol;
    @ApiModelProperty(value = "题名")
    @ExcelProperty(value = "题名", index = 2)
    private String titleName;
    @ApiModelProperty(value = "备注")
    @ExcelProperty(value = "备注", index = 3)
    private String remark;
    @ApiModelProperty(value = "责任人")
    @ExcelProperty(value = "责任人", index = 4)
    private String personLiable;
    @ApiModelProperty(value = "附件管理")
    private String accessoryManagement;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Byte recordStatus;
    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty(value = "创建时间")
    private String createdTimeStr;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifierAccount;
    @ApiModelProperty(value = "最新更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    @ApiModelProperty(value = "登记部门")
    @ExcelProperty(value = "登记部门", index = 5)
    private String regDepartment;
    @ApiModelProperty(value = "档案附件")

    private PaginationData<List<FileAttachment>> fileAttachmentList;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPersonLiable() {
        return personLiable;
    }

    public void setPersonLiable(String personLiable) {
        this.personLiable = personLiable;
    }

    public String getAccessoryManagement() {
        return accessoryManagement;
    }

    public void setAccessoryManagement(String accessoryManagement) {
        this.accessoryManagement = accessoryManagement;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
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

    public String getRegDepartment() {
        return regDepartment;
    }

    public void setRegDepartment(String regDepartment) {
        this.regDepartment = regDepartment;
    }


    public PaginationData<List<FileAttachment>> getFileAttachmentList() {
        return fileAttachmentList;
    }

    public void setFileAttachmentList(PaginationData<List<FileAttachment>> fileAttachmentList) {
        this.fileAttachmentList = fileAttachmentList;
    }

    public String getCreatedTimeStr() {
        return createdTimeStr;
    }

    public void setCreatedTimeStr(String createdTimeStr) {
        this.createdTimeStr = createdTimeStr;
    }

    @Override
    public String toString() {
        return "EmployeeFile{" +
                "fileId='" + fileId + '\'' +
                ", classId='" + classId + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", symbol='" + symbol + '\'' +
                ", titleName='" + titleName + '\'' +
                ", remark='" + remark + '\'' +
                ", personLiable='" + personLiable + '\'' +
                ", accessoryManagement='" + accessoryManagement + '\'' +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", createdTimeStr='" + createdTimeStr + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", regDepartment='" + regDepartment + '\'' +
                ", fileAttachmentList=" + fileAttachmentList +
                "} " + super.toString();
    }
}
