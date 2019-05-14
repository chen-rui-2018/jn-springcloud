package com.jn.park.parking.service;

import com.jn.park.parking.model.ParkingRecordRampParam;

import java.util.List;

/**
 * 匝道系统对接service
 *
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:43
 * @version： v1.0
 * @modified By:
 */
public interface ParkingServerService {

    /**
     * 定时同步匝道系统停车数据
     * @return
     */
    Boolean getInParkingCarInfoList();

    /**
     * 定时同步匝道系统车辆出场数据
     * @return
     */
    Boolean getOutParkingCarInfoList();

    /**
     * 调用匝道查询停车信息（不计算金额，只同步数据）
     * @param carLicense
     * @return
     */
    ParkingRecordRampParam getParkingByCarLicense(String carLicense);

    /**
     * 将匝道同步过来的数据批量入库【需是去重后的数据】
     * @param parkingRecordRampParam
     * @return
     */
    int insertParkingRecordByRamp( List<ParkingRecordRampParam> parkingRecordRampParam);

    /**
     * 批量修改停车数据[处理车辆出场时间和状态]
     * @param parkingRecordRampParam
     * @return
     */
    int updateParkingRecordByParam( List<ParkingRecordRampParam> parkingRecordRampParam);

    /**
     * 道尔 车辆入场推送接口
     * @param carList
     * @return 返回处理成功的记录id
     */
    String carJoinParking(List carList,String parkId);

    /**
     * 道尔 车辆出场推送接口
     * @param carList
     * @return 返回处理成功的记录id
     */
    String carOutParking(List carList);

}
