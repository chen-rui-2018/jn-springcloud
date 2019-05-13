package com.jn.park.parking.service;

import com.jn.common.model.PaginationData;
import com.jn.park.parking.model.ParkingSpaceParam;
import com.jn.park.parking.vo.ParkingSpaceDetailVo;
import com.jn.park.parking.vo.ParkingSpaceRentalVo;
import com.jn.park.parking.vo.ParkingSpaceVo;

import java.util.List;

/**
 * 车位租赁
 * @author： jiangyl
 * @date： Created on 2019/4/18 20:59
 * @version： v1.0
 * @modified By:
 */
public interface ParkingSpaceRentalService {

    /**
     * 根据租赁ID查询租赁信息
     * @param rentId
     * @return
     */
    ParkingSpaceRentalVo getParkingSpaceDetailById(String rentId);


}
