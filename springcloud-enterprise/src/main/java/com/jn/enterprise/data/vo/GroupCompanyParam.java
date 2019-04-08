package com.jn.enterprise.data.vo;

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
@ApiModel(value = "GroupCompanyParam", description = "企业列表获取参数")
public class GroupCompanyParam extends Page implements Serializable {

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "状态")
    private String recordStatus;

    @ApiModelProperty(value = "群组Id")
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
