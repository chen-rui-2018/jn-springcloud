package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 修改用户所属企业信息入参
 * @Author: yangph
 * @Date: 2019/2/21 15:50
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "UserCompanyInfo", description = "修改用户所属企业信息入参")
public class UserCompanyInfo implements Serializable {
    @ApiModelProperty("用户账号")
    private String account;
    @ApiModelProperty("所属企业编码")
    @Size(max = 32, message = "所属企业编码长度不能超过32个字")
    private String companyCode;
    @ApiModelProperty("所属机构名称")
    @Size(max =100, message = "所属企业名称长度不能超过100个字")
    private String companyName;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
