package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/01 15:28
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyDiagramInfoEditParam",description = "图解政策管理编辑（新增、修改）入参")
public class PolicyDiagramInfoEditParam implements Serializable {
    @ApiModelProperty(value = "政策id(新增时不传，修改时必传)",example = "xxx1234")
    private String policyId;
    @ApiModelProperty(value = "政策标题",required = true,example = "xxx政策")
    private String policyTitle;
    @ApiModelProperty(value = "专题类型(0：一号专题   1：民营专题)",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{thematicType:'默认值只允许为0,1'}")
    private String thematicType;
    @ApiModelProperty(value = "状态(0:无效  1:有效)",required = true,example = "1")
    @Pattern(regexp = "^[01]$", message = "{status:'默认值只允许为0,1'}")
    private String status;
    @ApiModelProperty(value = "有无关联政策原文(0:无  1:有 若是选择无，就不展示选择政策原文的列)",required = true,example = "0")
    private String isPolicyOriginal;
    @ApiModelProperty(value = "关联的政策原文id(若是有关联政策原文，需要选择一个政策原文)",example = "xxx12255")
    private String relationPolicyOriginalId;
    @ApiModelProperty(value = "政策图解url(上传图片的路径)")
    private String policyDiagramUrl;

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

    public String getThematicType() {
        return thematicType;
    }

    public void setThematicType(String thematicType) {
        this.thematicType = thematicType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsPolicyOriginal() {
        return isPolicyOriginal;
    }

    public void setIsPolicyOriginal(String isPolicyOriginal) {
        this.isPolicyOriginal = isPolicyOriginal;
    }

    public String getRelationPolicyOriginalId() {
        return relationPolicyOriginalId;
    }

    public void setRelationPolicyOriginalId(String relationPolicyOriginalId) {
        this.relationPolicyOriginalId = relationPolicyOriginalId;
    }

    public String getPolicyDiagramUrl() {
        return policyDiagramUrl;
    }

    public void setPolicyDiagramUrl(String policyDiagramUrl) {
        this.policyDiagramUrl = policyDiagramUrl;
    }


}
