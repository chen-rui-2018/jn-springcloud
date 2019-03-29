package com.jn.park.policy.vo;

import com.jn.park.policy.model.PolicyDetailsShow;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/28 11:03
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyCenterHomeParam",description = "图解政策详情出参")
public class PolicyDiagramDetailsVo implements Serializable {
    @ApiModelProperty(value = "政策原文")
    private PolicyDetailsShow policyDetailsShow;
    @ApiModelProperty(value = "政策id")
    private String policyId;
    @ApiModelProperty(value = "图解政策url")
    private String policyDiagramUrl;
    @ApiModelProperty(value = "政策标题")
    private String policyTitle;
    @ApiModelProperty(value = "阅读次数")
    private Integer readNum;
    @ApiModelProperty(value = "发布日期")
    private String releaseDate;

    public PolicyDetailsShow getPolicyDetailsShow() {
        return policyDetailsShow;
    }

    public void setPolicyDetailsShow(PolicyDetailsShow policyDetailsShow) {
        this.policyDetailsShow = policyDetailsShow;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyDiagramUrl() {
        return policyDiagramUrl;
    }

    public void setPolicyDiagramUrl(String policyDiagramUrl) {
        this.policyDiagramUrl = policyDiagramUrl;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
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
}
