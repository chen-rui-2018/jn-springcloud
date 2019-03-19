package com.jn.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
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
    @ApiModelProperty("是否分页（“TRUE”:分页  “FALSE”:不分页）")
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
