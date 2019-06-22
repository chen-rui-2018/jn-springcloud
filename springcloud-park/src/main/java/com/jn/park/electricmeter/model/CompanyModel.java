package com.jn.park.electricmeter.model;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/6/21 17:44
 * @version： v1.0
 * @modified By:
 */

public class CompanyModel implements Serializable {
    private String companyName;
    private String companyId;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
