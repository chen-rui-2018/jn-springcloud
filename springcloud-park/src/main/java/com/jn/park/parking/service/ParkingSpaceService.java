package com.jn.park.parking.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.parking.model.ParkingSpaceAmountModel;
import com.jn.park.parking.model.ParkingSpaceApplyModel;
import com.jn.park.parking.model.ParkingSpaceModel;
import com.jn.park.parking.model.ParkingSpaceParam;
import com.jn.park.parking.vo.*;
import com.jn.system.model.User;

import java.util.Date;
import java.util.List;

/**
 * 停车位
 * @author： jiangyl
 * @date： Created on 2019/4/18 20:59
 * @version： v1.0
 * @modified By:
 */
public interface ParkingSpaceService {

    /**
     * 查询停车位列表
     * @param parkingSpaceParam
     * @return
     */
    PaginationData<List<ParkingSpaceVo>> getParkingSpaceList(ParkingSpaceParam parkingSpaceParam);

    /**
     * 查询停车位详情[已租车位关联出租户信息]
     * @param spaceId
     * @return
     */
    ParkingSpaceDetailVo getParkingSpaceDetailById(String spaceId);

    /**
     * 新增/修改车位
     * @param parkingSpaceModel
     * @return
     */
    String saveOrUpdateParkingSpace(ParkingSpaceModel parkingSpaceModel,String userAccount);

    /**
     * 删除车位
     * @param spaceId
     * @param userAccount
     * @return
     */
    String deleteParkingSpace(String spaceId,String userAccount);

    /**
     * 查询当前用户车位租赁记录
     * @param account
     * @return
     */
    PaginationData<List<ParkingUserSpaceRentalVo>> getParKingSpaceRentalListByUser(String account, Page page);

    /**
     * 查询当前用户车位统计数据
     * @param userAccount
     * @return
     */
    ParkingSpaceUserCountVo getParkingSpaceUserCount(String userAccount);

    /**
     * 车位申请
     * @param parkingSpaceApplyModel
     * @param user
     * @return
     */
    String applyParkingSpace(ParkingSpaceApplyModel parkingSpaceApplyModel, User user);

    /**
     * 租车位费用计算接口
     * @param parkingSpaceAmountModel
     * @param account
     * @return
     */
    ParkingSpaceAmountVo applyParkingSpaceAmount(ParkingSpaceAmountModel parkingSpaceAmountModel,String account);

    /**
     * 计算量时间间隔天数
     * @param startTime
     * @param endTime
     * @return
     */
    int getDayInterval(Date startTime, Date endTime);

    /**
     * 创建停车月卡缴费账单
     * @param rentId
     * @param user
     * @return
     */
    String createParkingSpaceBill(String rentId,User user);
}
