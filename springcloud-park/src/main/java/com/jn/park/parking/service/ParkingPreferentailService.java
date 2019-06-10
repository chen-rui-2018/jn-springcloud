package com.jn.park.parking.service;

import com.jn.common.model.PaginationData;
import com.jn.park.parking.model.ParkingAreaModel;
import com.jn.park.parking.model.ParkingAreaParam;
import com.jn.park.parking.vo.ParkingAreaDetailVo;
import com.jn.park.parking.vo.ParkingAreaVo;
import com.jn.park.parking.vo.ParkingPreferentialVo;
import com.jn.park.parking.vo.ParkingServiceTypeVo;

import java.util.List;

/**
 * 优惠政策
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:41
 * @version： v1.0
 * @modified By:
 */
public interface ParkingPreferentailService {

    /**
     * 前端查询优惠政策列表
     * @return
     */
    List<ParkingPreferentialVo> getParkingPreferentialList(String account);

    /**
     * 查询某个停车场优惠政策
     * @param areaId
     * @return
     */
    List<ParkingPreferentialVo> getParkingPreferentialListForArea(String areaId,String account);
}
