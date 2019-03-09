package com.jn.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/26 14:27
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AffiliateParam", description = "所属机构编码查询用户信息入参")
public class AffiliateParam extends Page implements Serializable {
    @ApiModelProperty("所属机构编码")
    @NotNull(message = "所属机构编码不能为空")
    @Size(max = 32, message = "所属机构编码长度不能超过32个字")
    private String affiliateCode;

    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getAffiliateCode() {
        return affiliateCode;
    }

    public void setAffiliateCode(String affiliateCode) {
        this.affiliateCode = affiliateCode;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
