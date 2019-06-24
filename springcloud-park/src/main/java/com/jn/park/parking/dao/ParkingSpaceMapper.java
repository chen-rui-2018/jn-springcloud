package com.jn.park.parking.dao;

import com.jn.park.parking.model.ParkingSpaceParam;
import com.jn.park.parking.model.ParkingSpaceProtocolParam;
import com.jn.park.parking.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 15:31
 * @version： v1.0
 * @modified By:
 */
public interface ParkingSpaceMapper {


    /**
     * 查询停车位租赁协议
     * @param parkingSpaceProtocolParam
     * @return
     */
    ParkingSpaceProtocolVo getParkingSpaceProtocol(ParkingSpaceProtocolParam parkingSpaceProtocolParam);

    /**
     * 查询停车位列表
     * @param parkingSpaceParam
     * @return
     */
    List<ParkingSpaceVo> getParkingSpaceList(ParkingSpaceParam parkingSpaceParam);

    /**
     * 查询当前用户车位租赁记录
     * @param userAccount
     * @return
     */
    List<ParkingUserSpaceRentalVo> getParKingSpaceRentalListByUser(@Param(value = "userAccount") String userAccount);

    /**
     *
     * @param userAccount
     * @return
     */
    ParkingSpaceUserCountVo getParkingSpaceUserCount(@Param(value = "userAccount") String userAccount);

}
