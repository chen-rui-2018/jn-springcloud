package com.jn.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账单查询入參实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/29 20:59
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillParams" ,description = "账单查询入參实体类")
public class PayBillParams extends Page implements Serializable {
    private static final long serialVersionUID = -3611813821244989233L;

    @ApiModelProperty(value="账单编号",example = "201905090000003")
    @NotNull(message = "账单编号不能为空")
    private String billId;

    @ApiModelProperty(value="对象ID(传企业ID或用户ID)",example = "wangsong")
    @NotNull(message = "对象ID不能为空")
    private String objId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }
}
