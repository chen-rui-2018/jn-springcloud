package com.jn.enterprise.servicemarket.require.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/4 16:21
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequireTechnologyParam", description = "需求管理（科技金融提需求入参）")
public class RequireTechnologyParam implements Serializable {
    @ApiModelProperty(value = "产品Id",required = true,example = "xxx1234")
    @NotNull(message = "产品Id不能为空")
    private String productId;
    @ApiModelProperty(value = "产品名称",required = true,example = "xxx产品")
    @NotNull(message = "产品名称不能为空")
    private String productName;
    @ApiModelProperty(value = "需求描述",example = "xxx需求")
    private String requireDetail;
    @ApiModelProperty(value = "融资金额（万元）",required = true,example = "50")
    @Pattern(regexp ="[0-9]*",message = "融资金额只能输入数字")
    @NotNull(message = "融资金额不能为空")
    private String financingAmount;
    @ApiModelProperty(value = "实际贷款金额（万元）",example = "40")
    @Pattern(regexp ="[0-9]*",message = "实际贷款金额只能输入数字")
    private String actualLoanAmount;
    @ApiModelProperty(value = "融资期限最小值(3个月及以下  6个月及以下  12个月及以下  36个月及以下,值为空  36个月以上，值不为空))",example = "3")
    @Pattern(regexp = "^[0-9]*|(\\s+)$", message = "{loanTermMin:'默认值只允许为数字}")
    private String financingPeriodMin;
    @ApiModelProperty(value = "融资期限最大值(3个月及以下  6个月及以下  12个月及以下  36个月及以下，值不为空  36个月以上，值为空))",example = "6")
    @Pattern(regexp = "^[0-9]*|(\\s+)$", message = "{loanTermMax:'默认值只允许为数字}")
    private String financingPeriodMax;
    @ApiModelProperty(value = "资金需求日期",required = true,example = "2019-03-22")
    @NotNull(message = "资金需求日期不能为空")
    @Pattern(regexp = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-" +
            "(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})" +
            "(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)",
            message = "{expectedDate:'资金需求日期格式错误'}")
    private String expectedDate;
    @ApiModelProperty(value = "资金需求说明",example = "xxx需求说明")
    private String fundsReqDesc;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRequireDetail() {
        return requireDetail;
    }

    public void setRequireDetail(String requireDetail) {
        this.requireDetail = requireDetail;
    }

    public String getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(String financingAmount) {
        this.financingAmount = financingAmount;
    }

    public String getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(String actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
    }

    public String getFinancingPeriodMin() {
        return financingPeriodMin;
    }

    public void setFinancingPeriodMin(String financingPeriodMin) {
        this.financingPeriodMin = financingPeriodMin;
    }

    public String getFinancingPeriodMax() {
        return financingPeriodMax;
    }

    public void setFinancingPeriodMax(String financingPeriodMax) {
        this.financingPeriodMax = financingPeriodMax;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getFundsReqDesc() {
        return fundsReqDesc;
    }

    public void setFundsReqDesc(String fundsReqDesc) {
        this.fundsReqDesc = fundsReqDesc;
    }
}
