package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 机构申请审核信息
 * @author： jiangyl
 * @date： Created on 2019/2/25 10:43
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgApplyCheckData",description = "机构申请审核信息")
public class OrgApplyCheckData {
    @ApiModelProperty(value = "机构ID")
    @NotNull(message = "机构ID不能为空")
    private String orgId;
    @ApiModelProperty(value = "审核状态2不通过1通过")
    @Pattern(regexp = "^[21]$", message = "{checkStatus:'审核状态只允许为2,1'}")
    private String checkStatus;
    @ApiModelProperty(value = "审批意见")
    @NotNull(message = "审批意见不能为空")
    private String ckeckMessage;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCkeckMessage() {
        return ckeckMessage;
    }

    public void setCkeckMessage(String ckeckMessage) {
        this.ckeckMessage = ckeckMessage;
    }
}
