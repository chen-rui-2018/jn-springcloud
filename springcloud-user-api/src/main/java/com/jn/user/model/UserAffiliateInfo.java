package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 修改用户所属机构信息入参
 * @Author: yangph
 * @Date: 2019/2/21 15:14
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "UserAffiliateInfo", description = "修改用户所属机构信息入参")
public class UserAffiliateInfo implements Serializable {
    @ApiModelProperty("用户账号(可一次修改多个账号)")
    @NotNull(message = "用户账号不能为空")
    private List<String> accountList;
    @ApiModelProperty("所属机构编码")
    @Size(max = 32, message = "所属机构编码长度不能超过32个字")
    private String affiliateCode;
    @ApiModelProperty("所属机构名称")
    @Size(max =100, message = "所属机构名称长度不能超过100个字")
    private String affiliateName;

    public List<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }

    public String getAffiliateCode() {
        return affiliateCode;
    }

    public void setAffiliateCode(String affiliateCode) {
        this.affiliateCode = affiliateCode;
    }

    public String getAffiliateName() {
        return affiliateName;
    }

    public void setAffiliateName(String affiliateName) {
        this.affiliateName = affiliateName;
    }
}
