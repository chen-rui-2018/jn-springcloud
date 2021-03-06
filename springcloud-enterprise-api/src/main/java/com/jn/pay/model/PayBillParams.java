package com.jn.pay.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

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
    private String billId;

    @ApiModelProperty(value="账单类型【ELECTRIC:电费，PROPERTY:物业费，REPAIR:维修费，ROOM_LEASE:房租费，GOODS_LEASE:物品租赁费，TEMPORARY_PARKING:停车费，PARKING_LEASE:车位费，WATER:水费，PROMOTION:宣传费，HEALTH:体检费】",example = "ELECTRIC")
    private String acBookType;

    @ApiModelProperty(value="支付状态（如 1:已支付、2:待支付、3:已撤销）")
    private String paymentState;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }
}
