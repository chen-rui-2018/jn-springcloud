package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/22 14:47
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorManagementParam",description = "顾问管理入参")
public class AdvisorManagementParam extends Page implements Serializable {
    @ApiModelProperty(value = "顾问姓名")
    private String advisorName;
    @ApiModelProperty(value = "审批状态（pending:待审批   approvalNotPassed:审批不通过  noFeedBack:未反馈   rejected:已拒绝)")
    private String approvalStatus;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
