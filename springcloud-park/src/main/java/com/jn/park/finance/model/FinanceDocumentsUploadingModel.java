package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**支出录入查询分页
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceDocumentsUploadingModel",description = "文档上传")
public class FinanceDocumentsUploadingModel extends Page implements Serializable {


    private static final long serialVersionUID = 3330731679047628250L;
    @ApiModelProperty(value = "文档编号")
    private String  docId;

    @ApiModelProperty(value = "文档名称")
    private String  docName;

    @ApiModelProperty(value = "部门ID")
    private String  departmentId;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "文档上传人")
    private String docUploader;

    @ApiModelProperty(value = "文档说明")
    private String comment;

    @ApiModelProperty(value = "附件名称")
    private String docFileName;

    @ApiModelProperty(value = "附件code")
    private String docFileCode;


    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
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

    public String getDocUploader() {
        return docUploader;
    }

    public void setDocUploader(String docUploader) {
        this.docUploader = docUploader;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    public String getDocFileCode() {
        return docFileCode;
    }

    public void setDocFileCode(String docFileCode) {
        this.docFileCode = docFileCode;
    }


    @Override
    public String toString() {
        return "FinanceDocumentsUploadingModel{" +
                "docId='" + docId + '\'' +
                ", docName='" + docName + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", docUploader='" + docUploader + '\'' +
                ", comment='" + comment + '\'' +
                ", docFileName='" + docFileName + '\'' +
                ", docFileCode='" + docFileCode + '\'' +
                '}';
    }
}
