package com.jn.enterprise.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "CodeVO", description = "码表出参")
public class CodeVO implements Serializable {
    @ApiModelProperty(value = "分组ID")
    private String groupId;
    @ApiModelProperty(value = "分组名称")
    private String groupName;
    @ApiModelProperty(value = "数据值")
    private String codeValue;
    @ApiModelProperty(value = "数据名")
    private String codeName;

    private static final long serialVersionUID = 1L;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}