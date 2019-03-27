package com.jn.park.policy.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/27 16:44
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyClassShow",description = "政策中心首页入参")
public class PolicyCenterHomeParam extends Page implements Serializable {
    @ApiModelProperty(value = "政策级别编码(通过政策级别列表接口获取)",example = "area_level")
    private String policyLevelCode;
    @ApiModelProperty(value = "政策分类编码(通过政策分类列表接口获取)",example = "tax_incentives")
    private String policyClassCode;
    @ApiModelProperty(value = "政策类型(0：普通政策  1：图解政策)",example = "0")
    private String policyType;
    @ApiModelProperty(value = "发布时间(范围1990~2039)",example = "2019")
    @Pattern(regexp = "((199[0-9])|(20[0-3][0-9]))",
            message = "{releaseTime:'发布时间格式错误'}")
    private String releaseTime;
    @ApiModelProperty(value = "政策检索",example = "xxx政策")
    private String policySearch;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;


    public String getPolicyLevelCode() {
        return policyLevelCode;
    }

    public void setPolicyLevelCode(String policyLevelCode) {
        this.policyLevelCode = policyLevelCode;
    }

    public String getPolicyClassCode() {
        return policyClassCode;
    }

    public void setPolicyClassCode(String policyClassCode) {
        this.policyClassCode = policyClassCode;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getPolicySearch() {
        return policySearch;
    }

    public void setPolicySearch(String policySearch) {
        this.policySearch = policySearch;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
