package com.jn.park.customer.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/5/14 10:22
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ConsultationCustomerListParam",description = "客服中心园区用户咨询客服列表入参")
public class ConsultationCustomerListParam extends Page implements Serializable {
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    @Override
    public String toString() {
        return "ConsultationCustomerListParam{" +
                "needPage='" + needPage + '\'' +
                '}';
    }
}
