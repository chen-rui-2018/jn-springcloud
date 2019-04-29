package com.jn.enterprise.company.model;

import java.io.Serializable;
import java.util.List;

/**
 * 企业员工列表入参
 * @author： huxw
 * @date： Created on 2019-4-9 14:18:49
 * @version： v1.0
 * @modified By:
 */
public class StaffListInParam extends StaffListParam implements Serializable {

    private String comId;

    private List<String> accountList;

    public List<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }
}
