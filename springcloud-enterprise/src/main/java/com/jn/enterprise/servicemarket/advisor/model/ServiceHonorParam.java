package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
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
public class ServiceHonorParam extends Page implements Serializable {
    @ApiModelProperty(value = "主键id(新增时传空，修改时必传)")
    private String id;
    @ApiModelProperty(value = "顾问账号")
    @NotNull(message="顾问账号不能为空")
    private String advisorAccount;
    @ApiModelProperty(value = "颁发机构")
    @Size(max=64,message = "颁发机构长度最多为64个字")
    private String issuingAgency;
    @ApiModelProperty(value = "证书名称")
    @NotNull(message="证书名称不能为空")
    private String certificateName;
    @ApiModelProperty(value = "证书类型")
    @NotNull(message="证书类型不能为空")
    private String certificateType;
    @ApiModelProperty(value = "获得时间(格式：201903)")
    @Pattern(regexp = "((19[2-9][0-9])|(20((0[0-9])|(1[0-8]))))((0?[1-9])|(1[0-2]))",
            message = "{getTime:'获得时间格式错误'}")
    private String getTime;
    @ApiModelProperty(value = "证书证件")
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

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
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
                ", certificateType='" + certificateType + '\'' +
                ", getTime='" + getTime + '\'' +
                ", certificatePhoto='" + certificatePhoto + '\'' +
                '}';
    }
}
