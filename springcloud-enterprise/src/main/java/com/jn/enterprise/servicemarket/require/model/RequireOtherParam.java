package com.jn.enterprise.servicemarket.require.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/4 17:36
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequireOtherParam", description = "对他人的需求查询入参")
public class RequireOtherParam extends Page implements Serializable {
    @ApiModelProperty(value = "意向产品",example = "xxx产品")
    private String intentProduct;
    @ApiModelProperty(value = "意向机构",example = "xxx机构")
    private String intentOrg;
    @ApiModelProperty(value = "对接结果(1:对接成功  2:对接失败  3:企业需求撤销 4:未对接)",example = "1")
    @Pattern(regexp = "^[1234]|(\\s*)$", message = "{对接结果:'默认值只允许为1,2,3,4'}")
    private String handleResult;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getIntentProduct() {
        return intentProduct;
    }

    public void setIntentProduct(String intentProduct) {
        this.intentProduct = intentProduct;
    }

    public String getIntentOrg() {
        return intentOrg;
    }

    public void setIntentOrg(String intentOrg) {
        this.intentOrg = intentOrg;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
