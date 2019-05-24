package com.jn.park.asset.dao;

import com.jn.park.asset.model.RoomInformationModel;
import com.jn.park.asset.model.RoomLeaseRecordModel;
import com.jn.park.asset.model.RoomOrdersModel;
import com.jn.park.asset.model.RoomPayOrdersModel;

import java.util.List;
import java.util.Map;

/**
* 房间信息dao
* @author： zhuyz
* @date： Created on 2019/5/7 19:20
* @version： v1.0
* @modified By:
*/
public interface RoomInformationDao {

    /**
     * 返回可租借的房间列表(可搜索)
     * @param name
     * @return
     */
    List<RoomInformationModel> getRoomLeaseList(String name);

    /**
     * 房间租借历史订单(新)
     * @param account
     * @return
     */
    List<RoomLeaseRecordModel> getNewRoomOrdersList(String account);

    /**
     * 房间租借详情(新)
     * @param orderId
     * @return
     */
    RoomOrdersModel getNewRoomOrders(String orderId);

}
