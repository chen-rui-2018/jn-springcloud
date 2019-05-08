package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorMonthlyRentCardRateParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 11:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "MonthyRentalCardRateRequest" ,description = "月租信息获取(含费率)入参实体")
public class MonthyRentalCardRateRequest implements Serializable {
    private static final long serialVersionUID = 6094441023030117417L;
    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场
     */
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;

    /**
     * 道尔 月租信息获取(含费率)入参入参对象
     */
    @ApiModelProperty(value = "道尔 月租信息获取(含费率)入参入参对象")
    private DoorMonthlyRentCardRateParam doorMonthlyRentCardRateParam;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public DoorMonthlyRentCardRateParam getDoorMonthlyRentCardRateParam() {
        return doorMonthlyRentCardRateParam;
    }

    public void setDoorMonthlyRentCardRateParam(DoorMonthlyRentCardRateParam doorMonthlyRentCardRateParam) {
        this.doorMonthlyRentCardRateParam = doorMonthlyRentCardRateParam;
    }

    @Override
    public String toString() {
        return "MonthyRentalCardRateRequest{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", doorMonthlyRentCardRateParam=" + doorMonthlyRentCardRateParam +
                '}';
    }
}
