package com.jn.enterprise.servicemarket.require.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/6 9:54
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequirePortalParam", description = "需求管理（后台门户管理入参）")
public class RequirePortalParam extends Page implements Serializable {
    @ApiModelProperty(value = "产品类型(0:常规产品  1:特色产品))")
    @Pattern(regexp = "^[01]$", message = "{productType:'默认值只允许为0,1'}")
    private String productType;
    @ApiModelProperty(value = "对接结果(1:对接成功  2:对接失败  3:企业需求撤销 4:未对接)")
    @Pattern(regexp = "^[1234]$", message = "{对接结果:'默认值只允许为1,2,3,4'}")
    private String handleResult;
    @ApiModelProperty(value = "业务领域id")
    private String businessId;
    @ApiModelProperty(value = "服务机构")
    private String serviceOrg;
    @ApiModelProperty(value = "需求日期开始时间（格式201905）")
    @Pattern(regexp = "((19[2-9][0-9])|(20((0[0-9])|(1[0-8]))))((0?[1-9])|(1[0-2]))",
            message = "{requireStartTime:'获得时间格式错误'}")
    private String requireStartTime;
    @ApiModelProperty(value = "需求日期结束时间（格式201905）")
    @Pattern(regexp = "((19[2-9][0-9])|(20((0[0-9])|(1[0-8]))))((0?[1-9])|(1[0-2]))",
            message = "{requireEndTime:'获得时间格式错误'}")
    private String requireEndTime;
    @ApiModelProperty(value = "服务产品")
    private String serviceProduct;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getServiceOrg() {
        return serviceOrg;
    }

    public void setServiceOrg(String serviceOrg) {
        this.serviceOrg = serviceOrg;
    }

    public String getRequireStartTime() {
        return requireStartTime;
    }

    public void setRequireStartTime(String requireStartTime) {
        this.requireStartTime = requireStartTime;
    }

    public String getRequireEndTime() {
        return requireEndTime;
    }

    public void setRequireEndTime(String requireEndTime) {
        this.requireEndTime = requireEndTime;
    }

    public String getServiceProduct() {
        return serviceProduct;
    }

    public void setServiceProduct(String serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
