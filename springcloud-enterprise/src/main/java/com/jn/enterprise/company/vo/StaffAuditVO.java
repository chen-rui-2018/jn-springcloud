package com.jn.enterprise.company.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工审核出参
 * @author： huxw
 * @date： Created on 2019-4-9 14:18:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "StaffAuditVO",description = "员工审核出参")
public class StaffAuditVO implements Serializable {

    @ApiModelProperty(value = "员工ID")
    private String staffId;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "企业ID")
    private String comId;
    @ApiModelProperty(value = "企业名称")
    private String comName;
    @ApiModelProperty(value = "提交审核时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inviteTime;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
    }
}
