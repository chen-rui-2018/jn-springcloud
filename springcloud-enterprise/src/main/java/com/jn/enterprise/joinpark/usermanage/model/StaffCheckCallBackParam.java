package com.jn.enterprise.joinpark.usermanage.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 升级企业入参Bean
 * @author： jiangyl
 * @date： Created on 2019/3/5 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "StaffCheckCallBackParam",description = "升级员工回调入参")
public class StaffCheckCallBackParam implements Serializable {
    @NotNull(message = "申请ID不能为空")
    @ApiModelProperty(value = "申请ID",required = true)
    private String id;

    @NotNull(message = "审核状态不能为空")
    @ApiModelProperty(value = "审核状态",required = true)
    private String checkStatus;

    @NotNull(message = "审核人不能为空")
    @ApiModelProperty(value = "审核人",required = true)
    private String checkAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckAccount() {
        return checkAccount;
    }

    public void setCheckAccount(String checkAccount) {
        this.checkAccount = checkAccount;
    }
}
