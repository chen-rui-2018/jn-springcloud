package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

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
    @ApiModelProperty(value = "服务顾问账号",example = "wangsong")
    @NotBlank(message = "服务顾问账号不能为空！")
    private String advisorAccount;
    @ApiModelProperty(value = "评价类型:praise:好评  average:中评  badReview:差评",example = "praise")
    private String ratingType;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    private static final long serialVersionUID = 1L;

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
}
