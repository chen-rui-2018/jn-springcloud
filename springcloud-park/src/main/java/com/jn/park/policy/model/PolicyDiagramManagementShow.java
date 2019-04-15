package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/1 14:52
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyDiagramManagementShow",description = "图解政策管理出参")
public class PolicyDiagramManagementShow implements Serializable {
    @ApiModelProperty(value = "政策标题")
    private String policyTitle;
    @ApiModelProperty(value = "图解政策url(缩略图)")
    private String policyDiagramUrl;
    @ApiModelProperty(value = "阅读次数")
    private Integer readNum;
    @ApiModelProperty(value = "发布时间")
    private String releaseDate;
    @ApiModelProperty(value = "政策原文关联")
    private String relationPolicyOriginalName;
    @ApiModelProperty(value = "关联的政策原文id")
    private String relationPolicyOriginalId;
    @ApiModelProperty(value = "状态(0:无效  1:有效)")
    private String status;

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public String getPolicyDiagramUrl() {
        return policyDiagramUrl;
    }

    public void setPolicyDiagramUrl(String policyDiagramUrl) {
        this.policyDiagramUrl = policyDiagramUrl;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRelationPolicyOriginalName() {
        return relationPolicyOriginalName;
    }

    public void setRelationPolicyOriginalName(String relationPolicyOriginalName) {
        this.relationPolicyOriginalName = relationPolicyOriginalName;
    }

    public String getRelationPolicyOriginalId() {
        return relationPolicyOriginalId;
    }

    public void setRelationPolicyOriginalId(String relationPolicyOriginalId) {
        this.relationPolicyOriginalId = relationPolicyOriginalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PolicyDiagramManagementShow{" +
                "policyTitle='" + policyTitle + '\'' +
                ", policyDiagramUrl='" + policyDiagramUrl + '\'' +
                ", readNum=" + readNum +
                ", releaseDate='" + releaseDate + '\'' +
                ", relationPolicyOriginalName='" + relationPolicyOriginalName + '\'' +
                ", relationPolicyOriginalId='" + relationPolicyOriginalId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
