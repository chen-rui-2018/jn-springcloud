package com.jn.hardware.model.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/9 14:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SecurityMonitoringPointShow",description = "监控点列表查询返回实体")
public class SecurityMonitoringPointShow implements Serializable {

    private static final long serialVersionUID = -6385652670433388801L;
    @ApiModelProperty(value = "记录总条数")
    private Integer total;
    @ApiModelProperty(value = "当前页数")
    private Integer pageNo;
    @ApiModelProperty(value = "每页记录总条数")
    private Integer pageSize;
    @ApiModelProperty(value = "监控点信息列表")
    private List<SecurityMonitoringPoint> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<SecurityMonitoringPoint> getList() {
        return list;
    }

    public void setList(List<SecurityMonitoringPoint> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SecurityMonitoringPointShow{" +
                "total=" + total +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
