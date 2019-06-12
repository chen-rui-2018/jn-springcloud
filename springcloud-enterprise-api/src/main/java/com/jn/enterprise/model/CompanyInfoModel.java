package com.jn.enterprise.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/6/10 16:47
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CompanyInfoModel" ,description = "企业信息实体")
public class CompanyInfoModel implements Serializable {
    private String   companyId;
    private String   companyName;
    private String   companyAvatar;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAvatar() {
        return companyAvatar;
    }

    public void setCompanyAvatar(String companyAvatar) {
        this.companyAvatar = companyAvatar;
    }
}
