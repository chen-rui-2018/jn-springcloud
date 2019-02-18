package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/18 15:15
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRating",description = "服务评价信息查询入参")
public class ServiceEvaluationQuery  extends Page implements Serializable {
    @ApiModelProperty(value = "服务顾问账号")
    @NotBlank(message = "服务顾问账号不能为空！")
    private String advisorAccount;
    @ApiModelProperty(value = "评价类型:全部、好评、中评、差评")
    private String ratingType;
    @ApiModelProperty(value = "是否分页：true:分页   false:不分页")
    private Boolean needPage=false;

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

    public Boolean getNeedPage() {
        return needPage;
    }

    public void setNeedPage(Boolean needPage) {
        this.needPage = needPage;
    }
}
