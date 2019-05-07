package com.jn.park.parking.service;

import com.jn.park.parking.entity.TbParkingRecord;
import com.jn.park.parking.model.ParkingCarJoinParam;
import com.jn.park.parking.model.ParkingCarLeaveParam;
import com.jn.park.parking.vo.ParkingCarLeaveVo;
import com.jn.park.parking.vo.ParkingCarPayVo;

/**
 * 临时停车/停车服务
 * @author： jiangyl
 * @date： Created on 2019/4/18 20:59
 * @version： v1.0
 * @modified By:
 */
public interface ParkingTemporaryService {

    /**
     * 车辆入场请求接口
     * @param parkingCarJoinParam
     * @return
     */
    String carJoinParking(ParkingCarJoinParam parkingCarJoinParam);

    /**
     *  车辆离场请求接口，返回缴费数据
     * @param parkingCarLeaveParam
     * @return
     */
    ParkingCarLeaveVo carLeaveParking(ParkingCarLeaveParam parkingCarLeaveParam);

    /**
     * 计算停车费金额
     * @param parkingRecord
     * @return
     */
    Double calculateParkingAmount(TbParkingRecord parkingRecord);

    /**
     * 校验是否是月租车
     * @param carLicense 车牌号
     * @param areaId 车场ID
     * @return
     */
    Boolean checkCarIsMonthlyCard(String carLicense,String areaId);

    /**
     * 临停缴费账单创建
     * @param parkingId
     * @return
     */
    ParkingCarPayVo createCarParkingBill(String parkingId);


}
