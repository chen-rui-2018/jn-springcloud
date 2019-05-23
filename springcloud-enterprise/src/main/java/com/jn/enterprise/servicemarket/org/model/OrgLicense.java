package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 服务机构标签
 * @author： jiangyl
 * @date： Created on 2019/2/14 10:35
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgLicense",description = "服务机构标签")
public class OrgLicense implements Serializable {

    @ApiModelProperty(value = "证书ID[作为入参时，前台无需传值]")
    private String id;

    @ApiModelProperty(value = "机构ID[app录入时，该值传空。PC分批保存，该值必填]")
    private String orgId;

    @ApiModelProperty(value = "证书名称(app原型图无此字段，需添加)",required = true,example = "营业执照")
    @NotNull(message = "证书名称不能为空")
    private String certName;

    @ApiModelProperty(value = "证书文件路径",required = true,example = "**/**/**.png")
    @NotNull(message = "证书文件路径不能为空")
    private String fileUrl;

    @ApiModelProperty(value = "是否是特色标签 0否1是(app若无此字段固定传0)",required = true,example = "0")
    @NotNull(message = "是否是特色标签不能为空")
    private String isFeatures;

    @ApiModelProperty(value = "颁发时间 yyyy-MM-dd",example = "2017-01-01")
    private String awardTime;

    @ApiModelProperty(value = "颁发部门",example = "长沙工商管理局")
    private String awardDepart;

    @ApiModelProperty(value = "证书类型：1营业执照2执业资质3其他",example = "1")
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
