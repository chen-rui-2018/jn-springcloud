package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/14 16:32
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceHonorParam",description = "顾问荣誉资质入参")
public class ServiceHonorParam implements Serializable {
    @ApiModelProperty(value = "主键id(新增时传空，修改时必传)")
    private String id;
    @ApiModelProperty(value = "顾问账号",required = true,example = "wangsong")
    @NotNull(message="顾问账号不能为空")
    private String advisorAccount;
    @ApiModelProperty(value = "颁发机构",required = true,example = "xxx机构")
    @Size(max=64,message = "颁发机构长度最多为64个字")
    @NotNull(message="颁发机构不能为空")
    private String issuingAgency;
    @ApiModelProperty(value = "证书名称",required = true,example = "高级律师证")
    @NotNull(message="证书名称不能为空")
    private String certificateName;
    @ApiModelProperty(value = "证书类型(从获取指定证件类型接口获得证书类型，lawyerLicense:律师执业证   professionalAgentLicense：专业代理人执业证  cap：注册会计师)"
            ,required = true,example="lawyerLicense")
    @NotNull(message="证书类型不能为空")
    private String certificateCode;
    @ApiModelProperty(value = "颁发/获得时间",example = "201903")
    @Pattern(regexp = "((19[2-9][0-9])|(20[0-3][0-9]))((0[1-9])|(1[0-2]))",
            message = "{getTime:'颁发/获得时间格式错误'}")
    private String getTime;
    @ApiModelProperty(value = "证书证件",example = "xxx/photo.jpg")
    private String certificatePhoto;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getIssuingAgency() {
        return issuingAgency;
    }

    public void setIssuingAgency(String issuingAgency) {
        this.issuingAgency = issuingAgency;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getCertificatePhoto() {
        return certificatePhoto;
    }

    public void setCertificatePhoto(String certificatePhoto) {
        this.certificatePhoto = certificatePhoto;
    }

    @Override
    public String toString() {
        return "ServiceHonorParam{" +
                "id='" + id + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", issuingAgency='" + issuingAgency + '\'' +
                ", certificateName='" + certificateName + '\'' +
                ", certificateCode='" + certificateCode + '\'' +
                ", getTime='" + getTime + '\'' +
                ", certificatePhoto='" + certificatePhoto + '\'' +
                '}';
    }
}
