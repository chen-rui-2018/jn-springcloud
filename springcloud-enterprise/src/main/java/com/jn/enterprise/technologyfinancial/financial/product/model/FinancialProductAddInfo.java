package com.jn.enterprise.technologyfinancial.financial.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 科技金融添加产品信息
 * @author： chenr
 * @date： Created on 2019/3/19 16:01
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinancialProductAddInfo",description = "科技金融添加产品信息")
public class FinancialProductAddInfo implements Serializable {
    @ApiModelProperty(value = "产品id,不要传值")
    private String productId;
    @ApiModelProperty(value = "浏览数", hidden = true)
    private String viewCount;
    @ApiModelProperty(value = "产品类型,(0:常规-1:特色)",example = "0",required = true)
    @NotBlank(message = "产品类型不能为空")
    @Pattern(regexp = "^[0-1]$",message = "产品类型,只能为0或1")
    private String productType;
    @ApiModelProperty(value="产品编号",required = true,example = "CG000131226.0570718997558")
    @NotBlank(message = "产品编号不能为空")
    private String serialNumber;
    @ApiModelProperty(value = "业务领域id",required = true,example = "00000000000000001111111111111111")
    @NotBlank(message = "领域id不能为空")
    private String signoryId;
    @ApiModelProperty(value = "业务领域名称",required = true,example = "科技金融")
    @NotBlank(message = "领域名称不能为空")
    private String signoryName;
    @ApiModelProperty(value = "产品名称",required = true,example = "无忧贷款")
    @NotBlank(message = "产品名称不能为空")
    @Size(max = 20,message = "产品名称最大字符数为20")
    private String productName;
    @ApiModelProperty(value = "服务机构id,", hidden =  true, example = "00000000000000001111111111111111")
//    @NotBlank(message = "服务机构id不能为空")
    private String orgId;
    @ApiModelProperty(value = "服务机构名称",hidden = true,example = "北京快手")
//    @NotBlank(message = "服务机构名称不能为空")
    private String orgName;
    @ApiModelProperty(value = "参考利率最小值",required = true,example = "2.56")
    @NotBlank(message = "参考利率不能为空")
    @Pattern(regexp = "^^[1-9][0-9]*(\\.[0-9]{1,2})?$",message = "利率最小值符合规范,应为大于等于0的最多两位小数的数值 示例:2.56")
    private String refRateMin;
    @ApiModelProperty(value = "参考利率最大值)",required=true,example = "2.96")
    @NotBlank(message = "参考利率不能为空")
    @Pattern(regexp = "^^[1-9][0-9]*(\\.[0-9]{1,2})?$",message = "利率最小值符合规范,应为大于等于0的最多两位小数的数值 示例:2.56")
    private String refRateMax;
    @ApiModelProperty(value = "是否网贷直连(0:否-1:是)",required=true,example = "1")
    @Pattern(regexp = "^[0-1]$",message = "是否网贷直连,只能为0或1")
    @NotBlank(message = "是否网贷直连不能为空")
    private String isOnlineLoan;
    @ApiModelProperty(value="是否政策性产品(0:否  1:是)",required=true,example = "1")
    @Pattern(regexp = "^[0-1]$",message = "是否政策性产品,只能为0或1")
    @NotBlank(message = "是否政策性产品不能为空")
    private String isPolicyPro;
    @ApiModelProperty(value="是否通用产品(0:否  1:是)",required=true,example = "1")
    @Pattern(regexp = "^[0-1]$",message = "是否通用产品,只能为0或1")
    @NotBlank(message = "是否通用产品不能为空")
    private String isGeneralPro;
    @ApiModelProperty(value="是否人民币(0:否  1:是)",required=true,example = "1")
    @Pattern(regexp = "^[0-1]$",message = "是否人民币,只能为0或1")
    @NotBlank(message = "是否人民币不能为空")
    private String isRmb;
    @ApiModelProperty(value="贷款类表编码",required=true,example = "A11123...")
    @NotBlank(message = "贷款类表编码不能为空")
    private String loanCategoryCode;
    @ApiModelProperty(value="贷款类别名称",required=true,example = "抵押贷款")
    @NotBlank(message = "贷款类别名称不能为空")
    private String loanCategoryName;
    @ApiModelProperty(value = "贷款额度最小值",required = true,example = "1000")
    @Pattern(regexp="^^[1-9][0-9]*(\\.[0-9]{1,2})?$",message = "贷款额度只能为正数字")
    @NotBlank(message = "贷款额度最小值不能为空")
    private String loanAmountMin;
    @ApiModelProperty(value = "贷款额度最大值",required = true,example = "1000000")
    @Pattern(regexp="^^[1-9][0-9]*(\\.[0-9]{1,2})?$",message = "贷款额度只能为正数字")
    @NotBlank(message = "贷款额度最大值不能为空")
    private String loanAmountMax;
    @ApiModelProperty(value="贷款最大期限",required = true,example = "36")
    @Pattern(regexp="^[1-9][0-9]*$",message = "贷款期限为正整数")
    @NotBlank(message = "贷款最大期限不能为空")
    private String loanTermMax;
    @ApiModelProperty(value="贷款最小期限",required = true,example = "6")
    @Pattern(regexp="^[1-9][0-9]*$",message = "贷款期限为正整数")
    @NotBlank(message = "贷款最小期限不能为空")
    private String loanTermMin;
    @ApiModelProperty(value = "担保方式编码",required = true,example = "dbfs111...")
    @NotBlank(message = "担保方式编码不能为空")
    private String assureMethodCode;
    @ApiModelProperty(value = "担保方式名称",required = true,example = "抵押担保")
    @NotBlank(message = "担保方式名称不能为空")
    private String assureMethodName;
    @ApiModelProperty(value = "产品图片")
    private String pictureUrl;
    @ApiModelProperty(value = "产品特点")
    @Size(max = 165 , message = "产品特点最大长度为165个字符")
    private String productFeature;
    @ApiModelProperty(value = "申请条件")
    @Size(max = 165 , message = "产品特点最大长度为165个字符")
    private String applyCondition;
    @ApiModelProperty(value = "提交材料")
    @Size(max = 85 , message = "产品特点最大长度为85个字符")
    private String submitMaterial;
    @ApiModelProperty(value = "适用客户")
    private String applicableCust;
    @ApiModelProperty(value = "模板id,机构上架产品时使用,不用传值")
    private String templateId;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private String createdTime;
    @ApiModelProperty(value = "创建者账号", hidden = true)
    private String creatorAccount;

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    public String getSignoryName() {
        return signoryName;
    }

    public void setSignoryName(String signoryName) {
        this.signoryName = signoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getIsOnlineLoan() {
        return isOnlineLoan;
    }

    public void setIsOnlineLoan(String isOnlineLoan) {
        this.isOnlineLoan = isOnlineLoan;
    }

    public String getIsPolicyPro() {
        return isPolicyPro;
    }

    public void setIsPolicyPro(String isPolicyPro) {
        this.isPolicyPro = isPolicyPro;
    }

    public String getIsGeneralPro() {
        return isGeneralPro;
    }

    public void setIsGeneralPro(String isGeneralPro) {
        this.isGeneralPro = isGeneralPro;
    }

    public String getIsRmb() {
        return isRmb;
    }

    public void setIsRmb(String isRmb) {
        this.isRmb = isRmb;
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

    public String getLoanTermMax() {
        return loanTermMax;
    }

    public void setLoanTermMax(String loanTermMax) {
        this.loanTermMax = loanTermMax;
    }

    public String getLoanTermMin() {
        return loanTermMin;
    }

    public void setLoanTermMin(String loanTermMin) {
        this.loanTermMin = loanTermMin;
    }

    public String getAssureMethodCode() {
        return assureMethodCode;
    }

    public void setAssureMethodCode(String assureMethodCode) {
        this.assureMethodCode = assureMethodCode;
    }

    public String getAssureMethodName() {
        return assureMethodName;
    }

    public void setAssureMethodName(String assureMethodName) {
        this.assureMethodName = assureMethodName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature;
    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    public String getSubmitMaterial() {
        return submitMaterial;
    }

    public void setSubmitMaterial(String submitMaterial) {
        this.submitMaterial = submitMaterial;
    }

    public String getApplicableCust() {
        return applicableCust;
    }

    public void setApplicableCust(String applicableCust) {
        this.applicableCust = applicableCust;
    }

    public String getLoanCategoryCode() {
        return loanCategoryCode;
    }

    public void setLoanCategoryCode(String loanCategoryCode) {
        this.loanCategoryCode = loanCategoryCode;
    }

    public String getLoanCategoryName() {
        return loanCategoryName;
    }

    public void setLoanCategoryName(String loanCategoryName) {
        this.loanCategoryName = loanCategoryName;
    }
}
