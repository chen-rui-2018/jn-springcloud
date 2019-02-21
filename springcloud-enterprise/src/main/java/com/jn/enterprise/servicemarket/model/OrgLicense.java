package com.jn.enterprise.servicemarket.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 服务机构标签
 * @author： jiangyl
 * @date： Created on 2019/2/14 10:35
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgLicense",description = "服务机构标签")
public class OrgLicense {

    @ApiModelProperty(value = "证书ID")
    private String id;

    @ApiModelProperty(value = "机构ID")
    private String orgId;

    @ApiModelProperty(value = "证书名称")
    private String certName;

    @ApiModelProperty(value = "证书文件路径")
    private String fileUrl;

    @ApiModelProperty(value = "是否是特色标签 0否1是")
    private String isFeatures;

    @ApiModelProperty(value = "颁发时间 yyyy-MM-dd")
    private String awardTime;

    @ApiModelProperty(value = "颁发部门")
    private String awardDepart;

    @ApiModelProperty(value = "证书类型：1营业执照2执业资质3其他")
    private String certType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getIsFeatures() {
        return isFeatures;
    }

    public void setIsFeatures(String isFeatures) {
        this.isFeatures = isFeatures;
    }

    public String getAwardTime() {
        return awardTime;
    }

    public void setAwardTime(String awardTime) {
        this.awardTime = awardTime;
    }

    public String getAwardDepart() {
        return awardDepart;
    }

    public void setAwardDepart(String awardDepart) {
        this.awardDepart = awardDepart;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }
}
