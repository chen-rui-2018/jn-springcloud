package com.jn.enterprise.company.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工邀请状态列表出参
 * @author： huxw
 * @date： Created on 2019-4-9 14:18:49
 * @version： v1.0
 * @modified By:
 */
public class StaffStatusList extends Page implements Serializable {

    private String staffId;

    private String statusShow;

    private String account;

    private Date checkTime;

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStatusShow() {
        return statusShow;
    }

    public void setStatusShow(String statusShow) {
        this.statusShow = statusShow;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
