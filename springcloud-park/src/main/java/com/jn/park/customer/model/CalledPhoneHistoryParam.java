package com.jn.park.customer.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/6/14 15:10
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CalledPhoneHistoryParam",description = "客服中心来电用户历史信息入参")
public class CalledPhoneHistoryParam extends Page implements Serializable {
    @ApiModelProperty(value = "来电用户电话",example = "18088888888")
    @Pattern(regexp = "(^(((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8})$)"
            +"|(^0\\d{2,3}-[1-9]\\d{6,7}$)"+"|(^0\\d{2,3}[1-9]\\d{6,7}$)"+"|(^100[1-5])"+"|(^800[1-5])"+"|(^8000[1-5])" +"|(\\s*)"
            ,message="来电用户电话只能是手机号(18088888888)或座机号(0256-9978827,025-66666666)")
    private  String searchPhone;
    @ApiModelProperty(value = "页码",example = "1")
    private int page=1;
    @ApiModelProperty(value = "每页显示数量",example = "10")
    private int rows=20;

    public String getSearchPhone() {
        return searchPhone;
    }

    public void setSearchPhone(String searchPhone) {
        this.searchPhone = searchPhone;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "CalledPhoneHistoryParam{" +
                "searchPhone='" + searchPhone + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
