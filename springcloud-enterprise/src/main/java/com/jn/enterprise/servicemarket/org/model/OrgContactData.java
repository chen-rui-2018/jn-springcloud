package com.jn.enterprise.servicemarket.org.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 服务机构联系方式
 * @author： jiangyl
 * @date： Created on 2019/2/18 15:30
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgContactData",description = "服务机构联系方式")
public class OrgContactData implements Serializable {

    @ApiModelProperty(value = "机构ID")
    private String orgId;
    @ApiModelProperty(value = "省")
    @NotNull(message = "省不能为空")
    private String orgProvince;
    @ApiModelProperty(value = "市")
    @NotNull(message = "市不能为空")
    private String orgCity;
    @ApiModelProperty(value = "区县")
    @NotNull(message = "区县不能为空")
    private String orgArea;
    @ApiModelProperty(value = "详细地址")
    @NotNull(message = "详细地址不能为空")
    private String orgAddress;
    @ApiModelProperty(value = "咨询电话")
    @NotNull(message = "咨询电话不能为空")
    private String orgPhone;
    @ApiModelProperty(value = "联系人姓名")
    @NotNull(message = "联系人姓名不能为空")
    private String conName;
    @ApiModelProperty(value = "服务商网址")
    private String orgWeb;
    @ApiModelProperty(value = "联系人手机")
    @NotNull(message = "联系人手机不能为空")
    private String conPhone;
    @ApiModelProperty(value = "联系人邮箱")
    @NotNull(message = "联系人邮箱不能为空")
    private String conEmail;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgProvince() {
        return orgProvince;
    }

    public void setOrgProvince(String orgProvince) {
        this.orgProvince = orgProvince;
    }

    public String getOrgCity() {
        return orgCity;
    }

    public void setOrgCity(String orgCity) {
        this.orgCity = orgCity;
    }

    public String getOrgArea() {
        return orgArea;
    }

    public void setOrgArea(String orgArea) {
        this.orgArea = orgArea;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getOrgWeb() {
        return orgWeb;
    }

    public void setOrgWeb(String orgWeb) {
        this.orgWeb = orgWeb;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }
}
