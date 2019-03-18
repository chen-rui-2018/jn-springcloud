package com.jn.enterprise.pd.personnel.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： huangbq
 * @date： Created on 2019/3/18 12:33
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PersonnelFlowFormBaseAbstractModel",description = "提交审批的抽象基类，所有需要提交审批的表单对象都要继承此类")
public abstract class PersonnelFlowFormBaseAbstractModel {


    @ApiModelProperty("是否审批通过(false不通过，true通过)")
    private Boolean passStatus;
    @ApiModelProperty("审批意见")
    private String comment;


    public Boolean getPassStatus() {
        return passStatus;
    }

    public void setPassStatus(Boolean passStatus) {
        this.passStatus = passStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
