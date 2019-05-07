package com.jn.park.parking.dao;

import com.jn.park.parking.model.ParkingRecordRampDetailParam;
import com.jn.park.parking.model.ParkingRecordRampParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 19:31
 * @version： v1.0
 * @modified By:
 */
public interface ParkingRecordMapper {

    /**
     * 批量插入匝道系统同步过来的数据
     * @param list
     * @return
     */
    int insertParkingRecordByRamp(@Param(value = "list") List<ParkingRecordRampDetailParam> list);

    /**
     * 批量修改停车数据[处理车辆出场时间和状态]
     * @param list
     * @return
     */
    int updateParkingRecordByRamp(@Param(value = "list") List<ParkingRecordRampParam> list);

}
