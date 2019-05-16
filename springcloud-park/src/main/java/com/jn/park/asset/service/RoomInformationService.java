package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.asset.model.RoomBaseModel;
import com.jn.park.asset.model.RoomInformationModel;

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
     * 获取房间信息
     * @param id
     * @return
     */
    RoomInformationModel getRoomInformation(String id);

    /**
     *
     * @param roomId
     * @param contactName
     * @param contactPhone
     * @param leaseStartTime
     * @param leaseEndTime
     * @param userAccount
     * @return
     */
    Result addRoomOrders(String roomId, String contactName, String contactPhone, Date leaseStartTime, Date leaseEndTime, String userAccount);

    /**
     * 获取房间基本信息
     * @param roomId
     * @return
     */
    RoomBaseModel getRoomBaseInfo(String roomId);

    /**
     * 分页返回房间租赁列表(可搜索)
     * @param page
     * @param name
     * @return
     */
    PaginationData<List<RoomInformationModel>> getRoomLeaseList(Page page, String name);
}
