package com.jn.park.parking.dao;

import com.jn.park.parking.vo.ParkingAreaDetailVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 19:31
 * @version： v1.0
 * @modified By:
 */
public interface ParkingAreaMapper {

    /**
     * 根据停车场ID查询停车场数据详情
     * @param areaId
     * @return
     */
    ParkingAreaDetailVo getParkingAreaDetailById(@Param(value = "areaId")String areaId);

}
