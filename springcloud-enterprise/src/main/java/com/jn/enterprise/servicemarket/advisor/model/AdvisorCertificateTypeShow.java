package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/23 16:42
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorCertificateTypeShow", description = "证件类型出参")
public class AdvisorCertificateTypeShow implements Serializable {
    @ApiModelProperty(value = "证书编码")
    private String certificateCode;
    @ApiModelProperty(value = "证书名称")
    private String certificateName;

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    @Override
    public String toString() {
        return "AdvisorCertificateTypeShow{" +
                "certificateCode='" + certificateCode + '\'' +
                ", certificateName='" + certificateName + '\'' +
                '}';
    }
}
