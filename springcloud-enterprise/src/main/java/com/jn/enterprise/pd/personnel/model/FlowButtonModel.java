package com.jn.enterprise.pd.personnel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： huangbq
 * @date： Created on 2019/3/18 12:33
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FlowButtonModel",description = "审批按钮")
public class FlowButtonModel {

    @ApiModelProperty("按钮名称")
    private String name;
    @ApiModelProperty("节点名称")
    private Boolean isPass;
    @ApiModelProperty("按钮执行的动作")
    private String action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPass() {
        return isPass;
    }

    public void setPass(Boolean pass) {
        isPass = pass;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
