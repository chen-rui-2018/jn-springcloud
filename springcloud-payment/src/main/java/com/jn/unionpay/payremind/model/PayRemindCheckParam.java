package com.jn.unionpay.payremind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 账单核对审核提交入参
 * @author： jiangyl
 * @date： Created on 2019/3/18 16:03
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayRemindCheckParam", description = "账单核对审核提交入参")
public class PayRemindCheckParam implements Serializable {
    @ApiModelProperty(value = "审核项ID或账单ID[线下支付审核为审核项id(remind_id),线上支付为账单id(bill_id)]"
            ,notes = "[线下支付审核为审核项id(remind_id),线上支付为账单id(bill_id)]",required = true,example = "de2b944a227b41eb9b55fbd9a2cf10f4")
    @NotBlank(message = "审核项ID或账单ID不能为空")
    private String id;
    @ApiModelProperty(value = "审核状态[4支付审核通过5审核不通过]",required = true,example = "4")
    @NotBlank(message = "审核状态不能为空")
    @Pattern(regexp = "^[4,5]$", message = "{remindStatus:'审核状态只允许为4,5'}")
    private String remindStatus;
    @NotBlank(message = "审核备注不能为空")
    @ApiModelProperty(value = "审核备注",required = true,example = "审核通过")
    private String checkRemark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemindStatus() {
        return remindStatus;
    }

    public void setRemindStatus(String remindStatus) {
        this.remindStatus = remindStatus;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }
}