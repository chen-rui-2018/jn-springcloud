package com.jn.paycode.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class PaymentCode implements Serializable {
    @ApiModelProperty(value = "字典ID")
    private String id;
    @ApiModelProperty(value = "字典值")
    private String codeValue;
    @ApiModelProperty(value = "字典类型[1账单类型]")
    private String codeType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
}