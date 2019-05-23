package com.jn.hr.employee.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-15 下午 5:20
 */
@ApiModel(value = "BackgroundInvest", description = "背景调查实体")
public class BackgroundInvest implements Serializable {
    @ApiModelProperty(value = "唯一标识符",required = true)
    private String id;
    @ApiModelProperty(value = "身份核查（1：核查属实 2：核查不属实）",required = true)
    private Byte identityCheck;
    @ApiModelProperty(value = "学历核查（1：核查属实 2：核查不属实）",required = true)
    private Byte educationCheck;
    @ApiModelProperty(value = "上家公司名称",required = true)
    private String corporateName;
    @ApiModelProperty(value = "上家公司职位",required = true)
    private String corporateJob;
    @ApiModelProperty(value = "上家公司证明人",required = true)
    private String companyCertifier;
    @ApiModelProperty(value = "核查人",required = true)
    private String inspectors;
    @ApiModelProperty(value = "核查人联系电话",required = true)
    private String inspectorsPhone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Byte getIdentityCheck() {
        return identityCheck;
    }

    public void setIdentityCheck(Byte identityCheck) {
        this.identityCheck = identityCheck;
    }

    public Byte getEducationCheck() {
        return educationCheck;
    }

    public void setEducationCheck(Byte educationCheck) {
        this.educationCheck = educationCheck;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCorporateJob() {
        return corporateJob;
    }

    public void setCorporateJob(String corporateJob) {
        this.corporateJob = corporateJob;
    }

    public String getCompanyCertifier() {
        return companyCertifier;
    }

    public void setCompanyCertifier(String companyCertifier) {
        this.companyCertifier = companyCertifier;
    }

    public String getInspectors() {
        return inspectors;
    }

    public void setInspectors(String inspectors) {
        this.inspectors = inspectors;
    }

    public String getInspectorsPhone() {
        return inspectorsPhone;
    }

    public void setInspectorsPhone(String inspectorsPhone) {
        this.inspectorsPhone = inspectorsPhone;
    }

    @Override
    public String toString() {
        return "BackgroundInvest{" +
                "id='" + id + '\'' +
                ", identityCheck=" + identityCheck +
                ", educationCheck=" + educationCheck +
                ", corporateName='" + corporateName + '\'' +
                ", corporateJob='" + corporateJob + '\'' +
                ", companyCertifier='" + companyCertifier + '\'' +
                ", inspectors='" + inspectors + '\'' +
                ", inspectorsPhone='" + inspectorsPhone + '\'' +
                '}';
    }
}
