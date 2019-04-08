package com.jn.enterprise.data.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 18:02
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "Tab",description = "tab表单")
public class Tab {
    @ApiModelProperty(value = "表名称")
    private String tab_name;
    @ApiModelProperty(value = "表类型（0：上月填报值；1：上年同期值；2：上月上年同期值；3增幅）")
    private String tab_clumn_target_show;
    @ApiModelProperty(value = "表填报列类型（0：累计值；1：本期值）")
    private String tab_clumn_type;
    @ApiModelProperty(value = "状态（0：有效；1作废）")
    private String status ;
    @ApiModelProperty(value = "表生成模式（0:普通模板1：科技园模板）")
    private String tab_create_type;
    @ApiModelProperty(value = "tab表的显示顺序（因为可能会存在一组tabtab1tab2）")
    private String order;

    private List<Target> targetList;

    public String getTab_name() {
        return tab_name;
    }

    public void setTab_name(String tab_name) {
        this.tab_name = tab_name;
    }

    public String getTab_clumn_target_show() {
        return tab_clumn_target_show;
    }

    public void setTab_clumn_target_show(String tab_clumn_target_show) {
        this.tab_clumn_target_show = tab_clumn_target_show;
    }

    public String getTab_clumn_type() {
        return tab_clumn_type;
    }

    public void setTab_clumn_type(String tab_clumn_type) {
        this.tab_clumn_type = tab_clumn_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTab_create_type() {
        return tab_create_type;
    }

    public void setTab_create_type(String tab_create_type) {
        this.tab_create_type = tab_create_type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
