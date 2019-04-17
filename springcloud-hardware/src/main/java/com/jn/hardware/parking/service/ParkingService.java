package com.jn.hardware.parking.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 17:12
 * @Version： v1.0
 * @Modified By:
 */
public interface ParkingService {
    /**
     * 道尔的临停预缴费信息(场内缴费)
     * todo 后面需写在配置文件中，分了正式和测试地址
     */
    String GET_DOOR_TEMPORARYCAR_PARKINGFEE_URL = "https://api-dev.drzk.cn/v2/car/temporarycar/parkingfee/parkid/%s";
    /**
     * 获取临停预缴费信息(场内缴费)
     * @param doorTemporaryCarParkingFeeRequest
     * @return
     */
    Result getTemporaryCarParkingFee(DoorTemporaryCarParkingFeeRequest doorTemporaryCarParkingFeeRequest);

}
