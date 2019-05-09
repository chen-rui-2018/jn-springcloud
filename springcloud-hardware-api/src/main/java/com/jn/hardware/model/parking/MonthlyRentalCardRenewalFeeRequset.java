package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorMonthlyRentalCardRenewalFeeParam;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 11:16
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MonthlyRentalCardRenewalFeeRequset",description = "月租卡续费入参实体")
public class MonthlyRentalCardRenewalFeeRequset implements Serializable {

    private static final long serialVersionUID = 2590053590081793913L;
    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场
     */
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;

    /**
     * 道尔 月租卡续费入参实体
     */
    @ApiModelProperty(value = "道尔 月租卡续费入参实体对象",required = true)
    private DoorMonthlyRentalCardRenewalFeeParam doorMonthlyRentalCardRenewalFeeParam;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public DoorMonthlyRentalCardRenewalFeeParam getDoorMonthlyRentalCardRenewalFeeParam() {
        return doorMonthlyRentalCardRenewalFeeParam;
    }

    public void setDoorMonthlyRentalCardRenewalFeeParam(DoorMonthlyRentalCardRenewalFeeParam doorMonthlyRentalCardRenewalFeeParam) {
        this.doorMonthlyRentalCardRenewalFeeParam = doorMonthlyRentalCardRenewalFeeParam;
    }

    @Override
    public String toString() {
        return "MonthlyRentalCardRenewalFeeRequset{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", doorMonthlyRentalCardRenewalFeeParam=" + doorMonthlyRentalCardRenewalFeeParam +
                '}';
    }
}
