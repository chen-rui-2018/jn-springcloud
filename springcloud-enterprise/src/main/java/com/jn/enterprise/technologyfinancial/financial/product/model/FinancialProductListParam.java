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
    @ApiModelProperty(value = "贷款期限最小值(3个月及以下  6个月及以下  12个月及以下  36个月及以下,值为空  36个月以上，值不为空))，不限传空",example = "3")
    @Pattern(regexp = "^([0-9]*)|(\\s*)$", message = "{loanTermMin:'默认值只允许为数字}")
    private String loanTermMin;
    @ApiModelProperty(value = "贷款期限最大值(3个月及以下  6个月及以下  12个月及以下  36个月及以下，值不为空  36个月以上，值为空)不限传空)",example = "6")
    @Pattern(regexp = "^([0-9]*)|(\\s*)$", message = "{loanTermMax:'默认值只允许为数字}")
    private String loanTermMax;
    @ApiModelProperty(value = "担保方式编码（mortgage：抵押 ...）)",example = "mortgage")
    private String assureMethodCode;
    @ApiModelProperty(value = "网贷直联(0:否  1:是)，不限传空)",example = "0")
    @Pattern(regexp = "^[01]|(\\s*)$", message = "{onlineLoan:'默认值只允许为0,1'}")
    private String onlineLoan;
    @ApiModelProperty(value = "政策性产品(0:否  1:是)，不限传空)",example = "1")
    @Pattern(regexp = "^[01]|(\\s*)$", message = "{policyProduct:'默认值只允许为0,1'}")
    private String policyProduct;
    @ApiModelProperty(value = "贷款额度最小值(100万及以下  200万及以下  300万及以下  500万及以下  1000万及以下，值为空   1000万及以上，值不为空))，不限传空",example = "1100")
    @Pattern(regexp = "^[0-9]*|(\\s*)$", message = "{loanAmountMin:'默认值只允许为数字}")
    private String loanAmountMin;
    @ApiModelProperty(value = "贷款额度最小值(100万及以下  200万及以下  300万及以下  500万及以下  1000万及以下，值不为空   1000万及以上，值为空))，不限传空",example = "300")
    @Pattern(regexp = "^[0-9]*|(\\s*)$", message = "{loanAmountMax:'默认值只允许为数字}")
    private String loanAmountMax;
    @ApiModelProperty(value = "关键词)",example = "测试")
    private String keyWord;
    @ApiModelProperty(value = "是否需要分页  1:分页   0:不分页",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    @NotNull(message="是否需要分页不能为空")
    private String needPage;
    @ApiModelProperty(value = "产品类型,0常规 1 特色 不传则返回全部",example = "1")
    private String productType;
    @ApiModelProperty(value = "机构id",example = "orgid123456")
    private String orgId;
    @ApiModelProperty(value = "参考利率最小值",example = "2.56")
    @Pattern(regexp = "^^[1-9][0-9]*(\\.[0-9]{1,2})?$",message = "利率最小值符合规范,应为大于等于0的最多两位小数的数值 示例:2.56")
    private String refRateMin;
    @ApiModelProperty(value = "参考利率最大值)",example = "2.96")
    @Pattern(regexp = "^^[1-9][0-9]*(\\.[0-9]{1,2})?$",message = "利率最小值符合规范,应为大于等于0的最多两位小数的数值 示例:2.56")
    private String refRateMax;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getRefRateMin() {
        return refRateMin;
    }

    public void setRefRateMin(String refRateMin) {
        this.refRateMin = refRateMin;
    }

    public String getRefRateMax() {
        return refRateMax;
    }

    public void setRefRateMax(String refRateMax) {
        this.refRateMax = refRateMax;
    }

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

    @Override
    public String toString() {
        return "FinancialProductListParam{" +
                "loanTermMin='" + loanTermMin + '\'' +
                ", loanTermMax='" + loanTermMax + '\'' +
                ", assureMethodCode='" + assureMethodCode + '\'' +
                ", onlineLoan='" + onlineLoan + '\'' +
                ", policyProduct='" + policyProduct + '\'' +
                ", loanAmountMin='" + loanAmountMin + '\'' +
                ", loanAmountMax='" + loanAmountMax + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", needPage='" + needPage + '\'' +
                ", productType='" + productType + '\'' +
                ", orgId='" + orgId + '\'' +
                ", refRateMin='" + refRateMin + '\'' +
                ", refRateMax='" + refRateMax + '\'' +
                '}';
    }
}
