package com.jn.pay.vo;

import com.jn.pay.model.PayAccountBookMoneyRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * 账本明细实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/18 11:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookRecordVo" ,description = "账本明细实体类")
public class PayAccountBookRecordVo extends PayAccountBookMoneyRecord implements Serializable {
    private static final long serialVersionUID = 7360103002257889188L;

    @ApiModelProperty(value="月份")
    private String month;

    @ApiModelProperty(value="账本类型【ELECTRIC:电费，PROPERTY:物业费，REPAIR:维修费，ROOM_LEASE:房租费，GOODS_LEASE:物品租赁费，TEMPORARY_PARKING:停车费，PARKING_LEASE:车位费，WATER:水费，PROMOTION:宣传费，HEALTH:体检费】")
    private String acBookType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType;
    }
}
