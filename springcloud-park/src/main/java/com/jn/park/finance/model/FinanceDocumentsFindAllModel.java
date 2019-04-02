package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**支出录入查询分页
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceDocumentsFindAllModel",description = "财务文档分页查询")
public class FinanceDocumentsFindAllModel extends Page implements Serializable {


    private static final long serialVersionUID = 5842851749684048601L;

    @ApiModelProperty(value = "文档编码",example = "WDZL20190322001")
    private String  documentCode;

    @ApiModelProperty(value = "文档名称",example = "测试001")
    private String  documentName;

    @ApiModelProperty(value = "上传人",example = "ad123")
    private String  documentUploader;

    @NotNull(message = "开始时间不能为空")
    @ApiModelProperty(value = "开始时间 YYYY-MM",example = "2019-01")
    private String startTime;

    @NotNull(message = "结束时间不能为空")
    @ApiModelProperty(value = "结束时间 YYYY-MM",example = "2019-12")
    private String endTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentUploader() {
        return documentUploader;
    }

    public void setDocumentUploader(String documentUploader) {
        this.documentUploader = documentUploader;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "FinanceDocumentsFindAllModel{" +
                "documentCode='" + documentCode + '\'' +
                ", documentName='" + documentName + '\'' +
                ", documentUploader='" + documentUploader + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
