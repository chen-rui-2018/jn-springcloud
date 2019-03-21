package com.jn.enterprise.technologyfinancial.financial.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/18 19:41
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "FinancialProductListParam", description = "金融产品列表查询入参")
public class FinancialProductListParam extends Page implements Serializable {
    @ApiModelProperty(value = "贷款期限最小值(3个月及以下  6个月及以下  12个月及以下  36个月及以下,值为空  36个月以上，值不为空))")
    @Pattern(regexp = "^[0-9]*$", message = "{loanTermMin:'默认值只允许为数字}")
    private String loanTermMin;
    @ApiModelProperty(value = "贷款期限最大值(3个月及以下  6个月及以下  12个月及以下  36个月及以下，值不为空  36个月以上，值为空))")
    @Pattern(regexp = "^[0-9]*$", message = "{loanTermMax:'默认值只允许为数字}")
    private String loanTermMax;
    @ApiModelProperty(value = "担保方式编码)")
    private String assureMethodCode;
    @ApiModelProperty(value = "网贷直联(0:否  1:是))")
    @Pattern(regexp = "^[01]$", message = "{onlineLoan:'默认值只允许为0,1'}")
    private String onlineLoan;
    @ApiModelProperty(value = "政策性产品(0:否  1:是))")
    @Pattern(regexp = "^[01]$", message = "{policyProduct:'默认值只允许为0,1'}")
    private String policyProduct;
    @ApiModelProperty(value = "贷款额度最小值(100万及以下  200万及以下  300万及以下  500万及以下  1000万及以下，值为空   1000万及以上，值不为空))")
    @Pattern(regexp = "^[0-9]*$", message = "{loanAmountMin:'默认值只允许为数字}")
    private String loanAmountMin;
    @ApiModelProperty(value = "贷款额度最小值(100万及以下  200万及以下  300万及以下  500万及以下  1000万及以下，值不为空   1000万及以上，值为空))")
    @Pattern(regexp = "^[0-9]*$", message = "{loanAmountMax:'默认值只允许为数字}")
    private String loanAmountMax;
    @ApiModelProperty(value = "关键词)")
    private String keyWord;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页",required = true)
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getLoanTermMin() {
        return loanTermMin;
    }

    public void setLoanTermMin(String loanTermMin) {
        this.loanTermMin = loanTermMin;
    }

    public String getLoanTermMax() {
        return loanTermMax;
    }

    public void setLoanTermMax(String loanTermMax) {
        this.loanTermMax = loanTermMax;
    }

    public String getAssureMethodCode() {
        return assureMethodCode;
    }

    public void setAssureMethodCode(String assureMethodCode) {
        this.assureMethodCode = assureMethodCode;
    }

    public String getOnlineLoan() {
        return onlineLoan;
    }

    public void setOnlineLoan(String onlineLoan) {
        this.onlineLoan = onlineLoan;
    }

    public String getPolicyProduct() {
        return policyProduct;
    }

    public void setPolicyProduct(String policyProduct) {
        this.policyProduct = policyProduct;
    }

    public String getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(String loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }

    public String getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(String loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }
}
