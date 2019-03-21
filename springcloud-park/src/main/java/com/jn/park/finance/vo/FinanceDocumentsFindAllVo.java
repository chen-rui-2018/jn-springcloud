package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： tangry
 * @date： Created on 2019/3/19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceDocumentsFindAllVo",description = "财务文档分页")
public class FinanceDocumentsFindAllVo implements Serializable {

    private static final long serialVersionUID = 7565383776161367946L;



    @ApiModelProperty(value = "文档编号")
    private int id;
    @ApiModelProperty(value = "文档编号")
    private String docId;
    @ApiModelProperty(value = "文档名称")
    private String docName;
    @ApiModelProperty(value = "上传人")
    private String docUploader;
    @ApiModelProperty(value = "上传时间")
    private String docUploadTime;
    @ApiModelProperty(value = "说明")
    private String comment;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDocUploader() {
        return docUploader;
    }

    public void setDocUploader(String docUploader) {
        this.docUploader = docUploader;
    }

    public String getDocUploadTime() {
        return docUploadTime;
    }

    public void setDocUploadTime(String docUploadTime) {
        this.docUploadTime = docUploadTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "FinanceDocumentsFindAllVo{" +
                "id=" + id +
                ", docId='" + docId + '\'' +
                ", docName='" + docName + '\'' +
                ", docUploader='" + docUploader + '\'' +
                ", docUploadTime='" + docUploadTime + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
