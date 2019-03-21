package com.jn.enterprise.servicemarket.org.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/26 10:52
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "OrgColleagueParam", description = "机构同事列表查询入参")
public class OrgColleagueParam extends Page implements Serializable {
    @ApiModelProperty(value = "是否分页(1:分页   0:不分页)")
    @Pattern(regexp = "^[01]$", message = "{isDefault:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
