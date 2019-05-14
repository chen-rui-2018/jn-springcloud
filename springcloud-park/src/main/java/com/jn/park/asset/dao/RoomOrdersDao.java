package com.jn.park.asset.dao;

import com.jn.park.asset.model.RoomOrdersModle;
import com.jn.park.asset.model.RoomPayOrdersModel;

import java.util.List;
import java.util.Map;

/**
* 房间租借订单dao
* @author： zhuyz
* @date： Created on 2019/5/7 19:32
* @version： v1.0
* @modified By:
*/
public interface RoomOrdersDao {
    /**
     * 通过订单编号返回支付订单
     * @param id
     * @return
     */
    RoomPayOrdersModel getPayOrders(String id);

    /**
     * 分页获取房间租借历史列表
     * @param account
     * @return
     */
    List<RoomOrdersModle> getRoomOrdersList(String account);

    /**
     * 获取订单租借详情
     * @param id
     * @return
     */
    RoomOrdersModle getRoomOrders(String id);

    /**
     * 更新房间订单状态
     * @param map
     */
    void updateRoomStatus(Map<String, Object> map);
}
