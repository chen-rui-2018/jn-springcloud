package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.park.asset.model.RoomOrdersModle;
import com.jn.park.asset.model.RoomPayOrdersModel;

import java.util.List;

/**
* 房间租赁订单service
* @author： zhuyz
* @date： Created on 2019/5/7 17:51
* @version： v1.0
* @modified By:
*/
public interface RoomOrdersService {
    /**
     * 返回支付订单
     * @param id
     * @return
     */
    RoomPayOrdersModel getPayOrders(String id);

    /**
     * 分页返回房间租借历史
     * @param page
     * @return
     */
    PaginationData<List<RoomOrdersModle>> getRoomOrdersList(String account,Page page);

    /**
     * 获取房间租借订单详情信息
     * @param id
     * @return
     */
    RoomOrdersModle getRoomOrders(String id);

    /**
     * 房间退租申请
     * @param id
     * @return
     */
    RoomOrdersModle quitApply(String id);
}
