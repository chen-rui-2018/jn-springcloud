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
@ApiModel(value = "RequireOtherParam", description = "我收到的需求查询入参")
public class RequireReceivedParam extends Page implements Serializable {
    @ApiModelProperty(value = "需求人",example = "xxx需求人")
    private String requirePerson;
    @ApiModelProperty(value = "意向产品",example = "***产品")
    private String intentProduct;
    @ApiModelProperty(value = "对接结果(1:对接成功  2:对接失败  3:企业需求撤销 4:未对接),全部传空，pc端查询条件",example = "4")
    @Pattern(regexp = "^[1234]|(\\s*)$", message = "{对接结果:'默认值只允许为1,2,3,4'}")
    private String handleResult;
    @ApiModelProperty(value = "数据状态(1:待受理  2:待评价  3:已评价),全部传空，app端查询条件")
    @Pattern(regexp = "^[123]|(\\s*)$", message = "{对接结果:'默认值只允许为1,2,3'}")
    private String dataStatus;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getRequirePerson() {
        return requirePerson;
    }

    public void setRequirePerson(String requirePerson) {
        this.requirePerson = requirePerson;
    }

    public String getIntentProduct() {
        return intentProduct;
    }

    public void setIntentProduct(String intentProduct) {
        this.intentProduct = intentProduct;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
