package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 缴费统计查询入参
 * @author： jiangyl
 * @date： Created on 2019/3/13 10:57
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillCountParam", description = "缴费统计查询入参")
public class PayBillCountParam {
    @ApiModelProperty(value = "账期开始时间[yyyy-MM-dd HH:mm:ss]",example = "2019-03-24 10:00:00")
    private String billStartTime;
    @ApiModelProperty(value = "账期结束时间[yyyy-MM-dd HH:mm:ss]",example = "2019-03-24 10:00:00")
    private String billEndTime;
    @ApiModelProperty(value = "账单类型[不传查所有]{暂定：001楼宇租金 002物业费 003水费 004电费 005停车费 006维修费 007广告费}",example = "['005','006']"
            ,notes = "暂定：001楼宇租金 002物业费 003水费 004电费 005停车费 006维修费 007广告费")
    private String[] billTypeIds;

    public String getBillStartTime() {
        return billStartTime;
    }

    public void setBillStartTime(String billStartTime) {
        this.billStartTime = billStartTime;
    }

    public String getBillEndTime() {
        return billEndTime;
    }

    public void setBillEndTime(String billEndTime) {
        this.billEndTime = billEndTime;
    }

    public String[] getBillTypeIds() {
        return billTypeIds;
    }

    public void setBillTypeIds(String[] billTypeIds) {
        this.billTypeIds = billTypeIds;
    }
}
