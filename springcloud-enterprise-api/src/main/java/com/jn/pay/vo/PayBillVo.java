package com.jn.pay.vo;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 账单查询VO
 *
 * @author： wzy
 * @date： Created on 2019/5/2 16:57
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillVo" ,description = "账单查询VO")
public class PayBillVo implements Serializable {
    private static final long serialVersionUID = -6645256359045252226L;

    @ApiModelProperty(value="账单类型")
    private String type;

    @ApiModelProperty(value="催缴总次数")
    private Integer totalReminderNumber;


    @ApiModelProperty(value="账单基础信息")
    List<PayBillReturnParamVo> payBillReturnParamVo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTotalReminderNumber() {
        return totalReminderNumber;
    }

    public void setTotalReminderNumber(Integer totalReminderNumber) {
        this.totalReminderNumber = totalReminderNumber;
    }

    public List<PayBillReturnParamVo> getPayBillReturnParamVo() {
        return payBillReturnParamVo;
    }

    public void setPayBillReturnParamVo(List<PayBillReturnParamVo> payBillReturnParamVo) {
        this.payBillReturnParamVo = payBillReturnParamVo;
    }
}
