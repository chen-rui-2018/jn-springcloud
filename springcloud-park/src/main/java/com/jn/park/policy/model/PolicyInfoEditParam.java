package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/29 14:11
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyInfoEditParam",description = "政策管理编辑（新增、修改）入参")
public class PolicyInfoEditParam implements Serializable {
    @ApiModelProperty(value = "政策id(新增时不传，修改时必传)",example = "xxx1234")
    private String policyId;
    @ApiModelProperty(value = "政策标题",required = true,example = "xxx政策")
    private String policyTitle;
    @ApiModelProperty(value = "政策级别编码(从政策级别列表接口获取)",required = true,example="national_level")
    private String policyLevelCode;
    @ApiModelProperty(value = "政策级别名称(从政策级别列表接口获取)",required = true,example = "国家级")
    private String policyLevelName;
    @ApiModelProperty(value = "政策分类编码(从政策分类列表接口获取)",required = true,example = "financial_guidance")
    private String policyClassCode;
    @ApiModelProperty(value = "政策分类名称(从政策分类列表接口获取)",required = true,example = "财政引导")
    private String policyClassName;
    @ApiModelProperty(value = "专题类型(0：一号专题   1：民营专题)",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{thematicType:'默认值只允许为0,1'}")
    private String thematicType;
    @ApiModelProperty(value = "支持方式(1:奖励  2:其他  ...)",required = true,example = "1")
    @Pattern(regexp = "^[0-9]$", message = "{supportMethod:'默认值只允许为0-9的数值'}")
    private String supportMethod;
    @ApiModelProperty(value = "支持产业(1:所有产业  2:其他 ...)",required = true,example = "1")
    @Pattern(regexp = "^[0-9]$", message = "{supportIndustry:'默认值只允许为0-9的数值'}")
    private String supportIndustry;
    @ApiModelProperty(value = "发文单位")
    private String issueUnit;
    @ApiModelProperty(value = "状态(0:无效  1:有效)",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{status:'默认值只允许为0,1'}")
    private String status;
    @ApiModelProperty(value = "有无关联政策图解(0:无  1:有，若是选择无，就不展示选择图解政策的列)",required = true,example = "0")
    private String isPolicyDiagram;
    @ApiModelProperty(value = "关联的政策图解id(若是有关联管理图解政策，需要选择一个图解政策)",example = "xxx1234")
    private String relationPolicyDiagramId;
    @ApiModelProperty(value = "政策内容",required = true,example = "xxx政策内容")
    @NotBlank(message = "政策内容不能为空")
    private String policyContent;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public String getPolicyLevelCode() {
        return policyLevelCode;
    }

    public void setPolicyLevelCode(String policyLevelCode) {
        this.policyLevelCode = policyLevelCode;
    }

    public String getPolicyLevelName() {
        return policyLevelName;
    }

    public void setPolicyLevelName(String policyLevelName) {
        this.policyLevelName = policyLevelName;
    }

    public String getPolicyClassCode() {
        return policyClassCode;
    }

    public void setPolicyClassCode(String policyClassCode) {
        this.policyClassCode = policyClassCode;
    }

    public String getPolicyClassName() {
        return policyClassName;
    }

    public void setPolicyClassName(String policyClassName) {
        this.policyClassName = policyClassName;
    }

    public String getThematicType() {
        return thematicType;
    }

    public void setThematicType(String thematicType) {
        this.thematicType = thematicType;
    }

    public String getSupportMethod() {
        return supportMethod;
    }

    public void setSupportMethod(String supportMethod) {
        this.supportMethod = supportMethod;
    }

    public String getSupportIndustry() {
        return supportIndustry;
    }

    public void setSupportIndustry(String supportIndustry) {
        this.supportIndustry = supportIndustry;
    }

    public String getIssueUnit() {
        return issueUnit;
    }

    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsPolicyDiagram() {
        return isPolicyDiagram;
    }

    public void setIsPolicyDiagram(String isPolicyDiagram) {
        this.isPolicyDiagram = isPolicyDiagram;
    }

    public String getRelationPolicyDiagramId() {
        return relationPolicyDiagramId;
    }

    public void setRelationPolicyDiagramId(String relationPolicyDiagramId) {
        this.relationPolicyDiagramId = relationPolicyDiagramId;
    }

    public String getPolicyContent() {
        return policyContent;
    }

    public void setPolicyContent(String policyContent) {
        this.policyContent = policyContent;
    }
}
