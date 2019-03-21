package com.jn.enterprise.technologyfinancial.investors.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/21 19:16
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorManagementNameParam", description = "科技金融管理投资人管理姓名查询入参")
public class InvestorManagementNameParam extends Page implements Serializable {
    @ApiModelProperty(value = "姓名")
    private String investorName;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页",required = true)
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
