package com.jn.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分頁實體
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Page",description = "分页")
public class Page {

    @ApiModelProperty(value = "页码",example = "1")
    private int page=1;

    @ApiModelProperty(value = "每页显示数量",example = "10")
    private int rows=10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

}
