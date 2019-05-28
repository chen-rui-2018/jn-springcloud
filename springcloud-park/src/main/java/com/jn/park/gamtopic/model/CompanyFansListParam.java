package com.jn.park.gamtopic.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/27 20:21
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyFansListParam",description = "企业关注列表查询入参")
public class CompanyFansListParam extends Page implements Serializable {
    @ApiModelProperty(value = "企业id", required = true, example = "13256465789798")
    @NotBlank(message = "企业id不能为空")
    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
