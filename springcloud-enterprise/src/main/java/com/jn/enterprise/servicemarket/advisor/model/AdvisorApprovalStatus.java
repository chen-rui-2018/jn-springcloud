package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/25 17:20
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorApprovalStatus", description = "认证专员的状态出参")
public class AdvisorApprovalStatus implements Serializable {
    @ApiModelProperty(value = "专员认证状态(0：未认证  1：认证中  2：已认证  3：认证通过)")
    private int approvalStatus;
    @ApiModelProperty(value = "专员认证状态说明)")
    private String approvalDesc;

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalDesc() {
        return approvalDesc;
    }

    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc;
    }

    @Override
    public String toString() {
        return "AdvisorApprovalStatus{" +
                "approvalStatus=" + approvalStatus +
                ", approvalDesc='" + approvalDesc + '\'' +
                '}';
    }
}
