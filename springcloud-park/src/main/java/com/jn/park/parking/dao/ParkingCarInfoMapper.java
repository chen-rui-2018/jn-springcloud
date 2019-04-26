package com.jn.park.parking.dao;

import com.jn.park.parking.model.ParkingCarInfoParam;
import com.jn.park.parking.vo.ParkingAreaDetailVo;
import com.jn.park.parking.vo.ParkingCarInfoVo;
import com.jn.park.parking.vo.ParkingSpaceUserCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 19:31
 * @version： v1.0
 * @modified By:
 */
public interface ParkingCarInfoMapper {

    /**
     * 查询车辆列表
     * @param parkingCarInfoParam
     * @return
     */
    List<ParkingCarInfoVo> getCarInfoList(ParkingCarInfoParam parkingCarInfoParam);

    /**
     * 查询当前用户车辆统计数据
     * @param userAccount
     * @return
     */
    ParkingSpaceUserCountVo getUserCarInfoCount(@Param(value = "userAccount") String userAccount);

}
