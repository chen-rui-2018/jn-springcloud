package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/25 10:08
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ApprovalParam",description = "审批专员信息入参")
public class ApprovalParam  implements Serializable {
    @ApiModelProperty(value = "专员账号",required = true,example = "wangsong")
    @NotNull(message = "专员账号不能为空")
    private String advisorAccount;
    @ApiModelProperty(value = "审批结果(approved:审批通过   approvalNotPassed:审批不通过)",required = true,example = "approved")
    @NotNull(message = "审批结果不能为空")
    private String approvalResults;
    @ApiModelProperty(value = "审批说明",example = "xxx说明")
    private String approvalDesc;

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getApprovalResults() {
        return approvalResults;
    }

    public void setApprovalResults(String approvalResults) {
        this.approvalResults = approvalResults;
    }

    public String getApprovalDesc() {
        return approvalDesc;
    }

    public void setApprovalDesc(String approvalDesc) {
        this.approvalDesc = approvalDesc;
    }
}
