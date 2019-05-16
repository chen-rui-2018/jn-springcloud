package com.jn.park.asset.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.asset.model.RoomBaseModel;
import com.jn.park.asset.model.RoomInformationModel;
import com.jn.park.asset.model.RoomPayOrdersItemModel;
import com.jn.park.asset.model.RoomPayOrdersModel;
import com.jn.pay.model.PayOrderNotify;

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

     /**
     * 创建支付订单
     * @param orderId
     * @param channelId
     * @return
     */
    public Result createPayOrder(String orderId,String channelId ,String userAccount);
    /**
     * 支付回调
     * @param payOrderNotify
     * @return
     */
    Result payCallBack(PayOrderNotify payOrderNotify);

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
    PaginationData<List<RoomPayOrdersModel>> getRoomOrdersList(String account, Page page);

    /**
     * 获取房间租借订单详情信息
     * @param orderId
     * @return
     */
    RoomPayOrdersModel getRoomOrders(String orderId,String userAccount);

    /**
     * 房间退租申请
     * @param id
     * @return
     */
    RoomPayOrdersItemModel quitApply(String id);
}
