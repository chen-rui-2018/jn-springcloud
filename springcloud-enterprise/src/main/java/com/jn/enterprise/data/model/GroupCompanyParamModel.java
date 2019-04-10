package com.jn.enterprise.data.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 14:58
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "GroupCompanyParamModel", description = "企业列表获取参数")
public class GroupCompanyParamModel extends Page implements Serializable {

    @ApiModelProperty(value = "公司名称",example = "XXXX企业")
    private String companyName;

    @ApiModelProperty(value = "状态（0：有效；1作废）",example = "1")
    private String recordStatus;

    @ApiModelProperty(value = "群组Id",example = "0001")
    private String groupId;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
