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
@ApiModel(value = "AdvisorManagementParam",description = "专员管理入参")
public class AdvisorManagementParam extends Page implements Serializable {
    @ApiModelProperty(value = "专员姓名",example = "王松")
    private String advisorName;
    @ApiModelProperty(value = "审批状态（pending:待审批   approvalNotPassed:审批不通过  noFeedBack:未反馈   rejected:已拒绝)",example = "pending")
    private String approvalStatus;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
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
