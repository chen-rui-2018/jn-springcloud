package com.jn.park.parking.service;

import com.jn.park.parking.model.ParkingViolationModel;

/**
 * 智慧停车-违停
 * @author： jiangyl
 * @date： Created on 2019/4/23 17:39
 * @version： v1.0
 * @modified By:
 */
public interface ParkingViolationService {

    /**
     * 保存车辆违停信息
     * @param parkingViolationModel
     * @param account
     * @return
     */
    String saveParkingViolation(ParkingViolationModel parkingViolationModel,String account);

}
