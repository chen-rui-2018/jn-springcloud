package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 审核员工入参
 * @author： huxw
 * @date： Created on 2019-4-11 10:01:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ReviewStaffParam",description = "审核员工入参")
public class ReviewStaffParam implements Serializable {

    @ApiModelProperty(value = "审核状态（1审核通过 -1审核不通过）", required = true, example = "1")
    @Pattern(regexp = "^-?1$", message = "审核状态只允许为-1,1")
    @NotNull(message = "审核状态不能为空")
    private String checkStatus;

    @ApiModelProperty(value = "员工ID", required = true)
    @NotNull(message = "员工ID不能为空")
    private String staffId;

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
