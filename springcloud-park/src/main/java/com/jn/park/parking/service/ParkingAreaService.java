package com.jn.park.parking.service;

import com.jn.common.model.PaginationData;
import com.jn.park.parking.model.ParkingAreaModel;
import com.jn.park.parking.model.ParkingAreaParam;
import com.jn.park.parking.model.ParkingCount;
import com.jn.park.parking.model.ParkingCountParam;
import com.jn.park.parking.vo.ParkingAreaDetailVo;
import com.jn.park.parking.vo.ParkingAreaVo;
import com.jn.park.parking.vo.ParkingServiceTypeVo;

import java.util.List;

/**
 * 停车场
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:41
 * @version： v1.0
 * @modified By:
 */
public interface ParkingAreaService{

    /**
     * 查询停车场列表[后台管理]
     * @param parkingAreaParam
     * @return
     */
    PaginationData<List<ParkingAreaVo>> getParkingAreaListForAdmin(ParkingAreaParam parkingAreaParam);

    /**
     * 查询停车场列表[前端]
     * @param parkingAreaParam
     * @return
     */
    PaginationData<List<ParkingAreaVo>> getParkingAreaList(ParkingAreaParam parkingAreaParam);

    /**
     * 根据ID查询停车场详情
     * @param areaId
     * @return
     */
    ParkingAreaDetailVo getParkingAreaDetailById(String areaId);

    /**
     * 查询停车场服务数据列表
     * @return
     */
    List<ParkingServiceTypeVo> getParkingServiceTypeList();

    /**
     * 新增或修改停车场信息
     * @param parkingAreaModel
     * @param userAccount
     * @return
     */
    String saveOrUpdateCarPark(ParkingAreaModel parkingAreaModel,String userAccount);

    /**
     * 删除停车场
     * @param areaId
     * @param userAccount
     * @return
     */
    String deleteCarPark(String areaId,String userAccount);

    /**
     * 统计停车场数据
     * @param parkingCountParam
     * @return
     */
    ParkingCount countParking(ParkingCountParam parkingCountParam);
}
