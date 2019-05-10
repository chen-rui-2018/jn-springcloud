package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.model.RoomInformationModel;
import com.jn.park.asset.model.RoomOrdersModle;
import com.jn.system.model.User;

import java.sql.Date;
import java.util.List;

/**
* 房间信息Service
* @author： zhuyz
* @date： Created on 2019/5/7 16:03
* @version： v1.0
* @modified By:
*/
public interface RoomInformationService {
    /**
     * 分页返回房间租赁列表
     * @param page
     * @return
     */
    PaginationData<List<RoomInformationModel>> getRoomLeaseList(Page page);

    /**
     * 获取房间信息
     * @param id
     * @return
     */
    RoomInformationModel getRoomInformation(String id);

    /**
     * 租借资料填写
     * @param id
     * @param leaseEnterprise
     * @param contactName
     * @param contactPhone
     * @param leaseStartTime
     * @param leaseEndTime
     */
    void leaseWriter(String id, String leaseEnterprise, String contactName, String contactPhone, Date leaseStartTime, Date leaseEndTime);

    /**
     * 新增房间订单
     * @param id
     * @param user
     * @return
     */
    String addRoomOrders(String id, User user);

}
