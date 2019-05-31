package com.jn.enterprise.technologyfinancial.investors.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/9 17:16
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AffiliationUnitInfoParam", description = "科技金融投资人认证查询所属单位入参")
public class AffiliationUnitInfoParam extends Page implements Serializable {
    @ApiModelProperty(value = "单位名称",example = "xxx机构")
    private String orgName;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
