package com.jn.hardware.model.parking.door;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.checkerframework.checker.formatter.qual.UnknownFormat;

import java.io.Serializable;

/**
 * 道尔统一返回对象
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:50
 * @Version： v1.0
 * @Modified By:
 */

public class DoorHeadResult<T> implements Serializable {

    private static final long serialVersionUID = 2781143545628231967L;

    /**
     * 0 失败 1 成功
     */
    private String status="1";
    /**
     * 说明信息
     */
    private String message="成功";
    @ApiModelProperty(value = "当前页码")
    @JsonIgnore
    private String pageNo;
    @ApiModelProperty(value = "返回每页行数")
    @JsonIgnore
    private String pageSize;
    @ApiModelProperty(value = "记录总行数")
    @JsonIgnore
    private String rows;

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DoorHeadResult{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", pageNo='" + pageNo + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", rows='" + rows + '\'' +
                '}';
    }
}
