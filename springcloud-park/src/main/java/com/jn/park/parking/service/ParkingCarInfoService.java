package com.jn.park.parking.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.parking.model.ParkingCarInfoModel;
import com.jn.park.parking.model.ParkingCarInfoParam;
import com.jn.park.parking.model.ParkingRecordParam;
import com.jn.park.parking.vo.*;
import com.jn.system.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 车辆管理
 * @author： jiangyl
 * @date： Created on 2019/4/18 20:59
 * @version： v1.0
 * @modified By:
 */
public interface ParkingCarInfoService {

    /**
     * 查询园区车辆列表
     * @param parkingCarInfoParam
     * @return
     */
    PaginationData<List<ParkingCarInfoVo>> getCarInfoList(ParkingCarInfoParam parkingCarInfoParam);

    /**
     * 查询当前用户车辆列表
     * @param account
     * @return
     */
    PaginationData<List<ParkingCarInfoVo>>  getCarInfoListByNowUser(String account, Page page);

    /**
     * 查询当前用户车辆统计数据
     * @param userAccount
     * @return
     */
    ParkingSpaceUserCountVo getUserCarInfoCount(String userAccount);

    /**
     * 新增用户车辆
     * @param userCar
     * @param user
     * @return
     */
    String saveCarInfo(ParkingCarInfoModel userCar, User user);

    /**
     * 删除本人用户车辆
     * @param account
     * @param carId
     * @return
     */
    String deleteCarInfoByUser(String account,String carId);

    /**
     * 根据车牌号查询车辆信息
     * @param carLicense
     * @return
     */
    ParkingCarInfoVo getCarInfoByCarLicense(String carLicense);

    /**
     * 查询车辆停车记录
     * @param parkingRecordParam
     * @return
     */
    PaginationData<List<ParkingRecordVo>> getCarParkingRecordList(ParkingRecordParam parkingRecordParam);

    /**
     * 查询临停缴费车辆数据详情
     * @param carLicense
     * @return
     */
    ParkingRecordDetailVo getCarTempParkingDetail(String carLicense);

    /**
     * 计算时间差
     * @param beginTime
     * @param endTime
     * @return
     */
    String getTimeDifference(Date beginTime, Date endTime);
}
