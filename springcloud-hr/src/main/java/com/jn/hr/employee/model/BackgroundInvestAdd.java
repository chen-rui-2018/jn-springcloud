package com.jn.hr.employee.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author dt
 * @create 2019-04-15 下午 5:03
 */
@ApiModel(value = "BackgroundInvestAdd", description = "背景调查添加实体")
public class BackgroundInvestAdd implements Serializable {
    @ApiModelProperty(value = "id",required = true)
    @NotNull(message = "id不能为空")
    private String id;
    @ApiModelProperty(value = "身份核查（1：核查属实 2：核查不属实）",required = true)
    @NotNull(message = "身份核查不能为空")
    private Byte identityCheck;
    @ApiModelProperty(value = "学历核查（1：核查属实 2：核查不属实）",required = true)
    @NotNull(message = "学历核查不能为空")
    private Byte educationCheck;
    @ApiModelProperty(value = "上家公司名称",required = true)
    @NotNull(message = "上家公司名称不能为空")
    private String corporateName;
    @ApiModelProperty(value = "上家公司职位",required = true)
    @NotNull(message = "上家公司职位不能为空")
    private String corporateJob;
    @ApiModelProperty(value = "上家公司证明人",required = true)
    @NotNull(message = "上家公司证明人不能为空")
    private String companyCertifier;
    @ApiModelProperty(value = "核查人",required = true)
    @NotNull(message = "核查人不能为空")
    private String inspectors;
    @ApiModelProperty(value = "核查人联系电话",required = true)
    @NotNull(message = "核查人联系电话不能为空")
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
        return "BackgroundInvestAdd{" +
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

    /*public static void main(String[] args) throws Exception{
        BackgroundInvestAdd add=new BackgroundInvestAdd();
        add.setId("381256c0-e2a9-4c89-a5c5-f3166ba0ccf8");
        add.setIdentityCheck((byte)1);
        add.setEducationCheck((byte)2);
        add.setCorporateName("迪科");
        add.setCorporateJob("java开发");
        add.setCompanyCertifier("小张");
        add.setInspectors("dt");
        add.setInspectorsPhone("185678");
        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(add));

    }*/
}

