package com.jn.park.policy.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/29 10:28
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyManagementParam",description = "政策管理入参")
public class PolicyManagementParam extends Page implements Serializable {
    @ApiModelProperty(value = "状态(0：无效   1：有效，不传返回全部)",example = "1")
    @Pattern(regexp="^[01]$",message="{status:'状态值只允许为0,1'}")
    private String status;
    @ApiModelProperty(value = "政策标题",example = "xxx政策")
    private String policyTitle;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    @Override
    public String toString() {
        return "PolicyManagementParam{" +
                "status='" + status + '\'' +
                ", policyTitle='" + policyTitle + '\'' +
                ", needPage='" + needPage + '\'' +
                '}';
    }
}
