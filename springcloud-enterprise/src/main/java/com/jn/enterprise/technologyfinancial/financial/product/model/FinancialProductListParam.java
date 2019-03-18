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
    @ApiModelProperty(value = "贷款期限(1:3个月及以下  2:6个月及以下  3:12个月及以下  4:36个月及以下  5:36个月以上))")
    @Pattern(regexp = "^[1-5]$", message = "{loanTerm:'默认值只允许输入1,2,3,4,5}")
    private String loanTerm;
    @ApiModelProperty(value = "担保方式编码)")
    private String assureMethodCode;
    @ApiModelProperty(value = "网贷直联(0:否  1:是))")
    @Pattern(regexp = "^[01]$", message = "{onlineLoan:'默认值只允许为0,1'}")
    private String onlineLoan;
    @ApiModelProperty(value = "政策性产品(0:否  1:是))")
    @Pattern(regexp = "^[01]$", message = "{policyProduct:'默认值只允许为0,1'}")
    private String policyProduct;
    @ApiModelProperty(value = "贷款额度(1:100万及以下  2:200万及以下  3:300万及以下  4:500万及以下  5:1000万及以下  6:1000万及以上))")
    @Pattern(regexp = "^[1-6]$", message = "{policyProduct:'默认值只允许为1,2,3,4,5,6'}")
    private String loanAmount;
    @ApiModelProperty(value = "关键词)")
    private String keyWord;
    @ApiModelProperty(value = "是否需要分页  0:分页   1:不分页")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
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

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
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
