package com.jn.enterprise.servicemarket.org.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/26 10:52
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "OrgColleagueQuery", description = "机构同事列表查询入参")
public class OrgColleagueQuery extends Page implements Serializable {
    @ApiModelProperty(value = "是否分页(“TRUE”:分页  “FALSE”:不分页)")
    private String needPage;

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
