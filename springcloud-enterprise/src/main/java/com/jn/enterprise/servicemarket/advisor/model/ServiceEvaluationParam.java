package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/18 15:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceEvaluationParam",description = "服务评价信息查询入参")
public class ServiceEvaluationParam extends Page implements Serializable {
    @ApiModelProperty(value = "机构id(查询机构评价必传)",example = "xxx123")
    private String orgId;
    @ApiModelProperty(value = "产品id（查询产品的评价必传）",example = "xxx456")
    private String productId;
    @ApiModelProperty(value = "服务顾问账号(查询顾问的评价必传)",example = "wangsong")
    private String advisorAccount;
    @ApiModelProperty(value = "评价类型:praise:好评  average:中评  badReview:差评,不传查询全部",example = "praise")
    private String ratingType;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;
    @ApiModelProperty(value = "是否公共页面  1:是公共页面   0:不是公共页面",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{isPublicPage:'默认值只允许为0,1'}")
    @NotNull(message="是否公共页面不能为空")
    private String isPublicPage;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    public String getIsPublicPage() {
        return isPublicPage;
    }

    public void setIsPublicPage(String isPublicPage) {
        this.isPublicPage = isPublicPage;
    }
}
