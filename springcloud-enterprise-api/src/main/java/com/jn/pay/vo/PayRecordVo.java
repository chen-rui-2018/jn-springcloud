package com.jn.pay.vo;

import com.jn.pay.model.PayBill;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 账单缴费记录实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/18 11:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayRecordVo" ,description = "账单缴费记录实体类")
public class PayRecordVo extends PayBill implements Serializable {
    private static final long serialVersionUID = 7360103002257889188L;

    @ApiModelProperty(value="月份")
    private String month;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

}
