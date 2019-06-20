package com.jn.park.policy.vo;

import com.jn.enterprise.model.IBPSFile;
import com.jn.park.policy.model.PolicyDetailsShow;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

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
    @ApiModelProperty(value = "是否绑定原文政策")
    private String isPolicyDiagram;
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
    @ApiModelProperty(value = "附件url(未格式化处理)")
    private String fileUrl;
    @ApiModelProperty(value = "附件url(已格式化处理)")
    private List<IBPSFile> fileUrls;

    public String getIsPolicyDiagram() {
        return isPolicyDiagram;
    }

    public void setIsPolicyDiagram(String isPolicyDiagram) {
        this.isPolicyDiagram = isPolicyDiagram;
    }

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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public List<IBPSFile> getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(List<IBPSFile> fileUrls) {
        this.fileUrls = fileUrls;
    }

    @Override
    public String toString() {
        return "PolicyDiagramDetailsVo{" +
                "policyDetailsShow=" + policyDetailsShow +
                ", isPolicyDiagram='" + isPolicyDiagram + '\'' +
                ", policyId='" + policyId + '\'' +
                ", policyDiagramUrl='" + policyDiagramUrl + '\'' +
                ", policyTitle='" + policyTitle + '\'' +
                ", readNum=" + readNum +
                ", releaseDate='" + releaseDate + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileUrls=" + fileUrls +
                '}';
    }
}
