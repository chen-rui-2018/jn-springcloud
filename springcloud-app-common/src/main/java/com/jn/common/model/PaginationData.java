package com.jn.common.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Pagination 分頁
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
public class PaginationData<T> {
    private T rows;
    @ApiModelProperty(value = "总页数")
    private long total;

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public PaginationData(T rows, long total) {
        super();
        this.rows = rows;
        this.total = total;
    }

    public PaginationData() {

    }

    @Override
    public String toString() {
        return "PaginationData{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
