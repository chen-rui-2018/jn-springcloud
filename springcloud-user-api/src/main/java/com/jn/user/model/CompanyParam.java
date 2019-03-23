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
@ApiModel(value = "CompanyParam", description = "所属企业编码查询用户信息入参")
public class CompanyParam extends Page implements Serializable {
    @ApiModelProperty("所属企业编码")
    @NotNull(message = "所属企业编码不能为空")
    @Size(max = 32, message = "所属企业编码长度不能超过32个字")
    private String companyCode;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
